// Draft de corrigé : exemple de solution attendue
// non paufiné à des fins de publications

// Bonus global:
// + 0.25 par annotation @Override correcte
// Malus de 1 point par cas de masquage d'attribut 

// malus de 2 points par cas d'héritage qui ne représentent pas un lien EST-UN
//
//////////////////////////////////////////////////////////////////////////////////
// Une brindille
// Total : 4 points
// 0.5 pour la coquille vide de classe 
// 0.5 pt : droit d'accès publique/protégé aux méthodes
// 0.5 pt: droit d'accès privé aux attributs

class WoodChip extends Positionable 
{
	//0.5
	private double length;

	// 2
	public Woodchip(Vector position, double length) {}
	
}
//////////////////////////////////////////////////////////////////////////////////
// les termites asexuées
// Total : 20  points
// 0.5 pour la coquille vide de classe 
// 0.5pt : droit d'accès publique/protégé aux méthodes
// 0.5pt: droit d'accès privé aux attributs
// 1 pour l'implémentation de Updatable
// 1 pour l'héritage

class Termite extends Positionable implements Updatable
{
	// 1.5
	public final static double ENERGY_TRESHOLD = 20.0;
	public final static double ENERGY_LOSS = 0.1;
	public final static double ENERGY_GAIN = 0.3;
	
	//0.5
	private Vector home;
	//0.5
	private Vector target;
	// 0.5
	private WoodChip carriedWood;
	//0.5
	private double energy;
	//0.5
	private MovingMode movingMode;

	// 1
	public Termite(Vector position, double energy);


	// 1.5
	@Override
	public void update(float dt, Environment env)
	// corps non demandé dans l'examen
		{

			switch (movingMode){
			  case TARGET_MOVE:
				  targetMove(dt, env);
				  if (reachedTarget()){
					  if (carriedWood != null){
						  env.addWoodChipAt(carriedWood, target); 
						  env.increaseWoodQuantity(target);
					  }
					  carriedWood = null;
					  increaseEnergy();
					  movingMode = RANDOM_MOVE;
				  }
				  
			break;
			case RANDOM_MOVE:
				randomMove(dt, env);
				if (getEnergy() < Termite.ENERGY_TRESHOLD){
					movingMode = TARGET_MOVE;
					setTarget(getHome());
					return;
				}
				
				Wood woodChip = env.getCollidingWoodChip(this);
				// si elle porte du bois elle n'en ramasse pas une seconde fois.
				if (woodChip != null && carriedWood==null){
					carriedWood = woodchip;
					env.removeWoodChip(woodChip);
					movingMode = TARGET_MOVE;
					setTarget(getHome());
				}
			default:
				/*do nothing*/
			}
			looseEnergy();
		}

	// 1
	public boolean isDead()
		{
			return false;
		}

	// 1
	protected  void setHome(Vector position); // change l'appartenance à une termitière  (admis ici même si seules les termites sexuées peuvent migrer)

	// pour retourner à sa termitière
	// 1
	protected Vector getHome()
		{
			return home;
		}

	//1
	protected  void setTarget(Vector position); // cible du déplacement

	//1
	protected void setEnergy(double energy)
		{}

	//1
	protected double getEnergy() { return energy };
	
	//1 (éléments de modularisation important)
	protected void randomMove(float dt, Environment env)
		{}
	
	// 1
	protected void targetMove(float dt, Environment env)
		{}
	

	// 1 optionel
	protected boolean isTargetReached() {
		return false ; 
	}

	// 1
	protected void setMovingMode(MovingMode mode)
		{}
	

	// 1
	protected  MovingMode getMovingMode() 
		{
			return movingMode;
		}
	

// 1 (nécessaire pour l'implémentation du update de SexedTermite
	protected Vector getTarget() 
		{
			return target;
		}
}

//////////////////////////////////////////////////////////////////////////////////
// les termites sexuées
// Total : 7.5  points
// 0.5 pour la coquille vide de classe 
// 0.5pt : droit d'accès publique/protégé aux méthodes
// 0.5 pt: droit d'accès privé aux attributs
// 1 pour l'héritage

class SexedTermite extends Termit
{
	// (accepté dans Termite, aurait la valeur false toujours)
	// 0.5
	private boolean isMigrating;

	//0.5
	private char gender;

	// 1.5
	public SexedTermite(Vector position, double energy, char gender);

	// 1.5
	@Override
	public void update(float dt, Environment env) 
		{
			if (isMigrating){  // 0.5
				if (reachedTarget()){ // 1
					if (!env.existTermitaryAt(getTarget())) // 1
					{
						env.addTermitaryAt(target); // 1
						// admis que le add et Remove soit fait dans setHome mais ça
						// doir être documenté
						env.removeTermitFromTermitary(this, getHome());//1
						setHome(target); // 1
						env.addTermitToTermitary(this, getHome());// 1
					}
					setMovingMode(RANDOM_MOVE);// 0.5
					isMigrating = false;// 0.5
					return;
				}
				else {
					// la cible de la migration a été décidée lors du
					// déclenchement de la migration
					targetMove(dt, env); // 1
					looseEnergy(); // peut être codé dans targetMove; // 0.5
				}
				return;
			}
			// se comportent comme les termites asexuées
			super.update(dt, env); //1
		}


	
	//(accepté dans Termite s'il y a une collection
	//hétérogène de termites dans la termitière)
	// 1
	protected void setMigrating() {} //nécessaire pour  le update de la termitière

	
	

}

// 
//////////////////////////////////////////////////////////////////////////////////
// les termitières
// Total : 13.5 points
// 0.5 pour la coquille vide de classe 
// 0.5pt : droit d'accès publique/protégé aux méthodes
// 0.5 pt: droit d'accès privé aux attributs
// 1 pour l'implémentation de Updatable
// 1 pour l'héritage


class Termitary extends Positionnable implements  Updatable
{
	//0.5
	public final static int TRESHOLD_FOR_MIGRATION = 1000.0;
	// La classe WoodChip représente une brindille
	//1.5
	private List <WoodChip> woodChips = new ArrayList<>();    // ensemble de brindilles
// 1.5
	private List <Termite> termites = new ArrayList<>()
	// bonus
	// en dupliquant les collections: setMigrating() peut ne s'appliquer qu'aux
	// termites sexuées.
		// bonus 0.5
	private List <SexedTermites> termites = new ArrayList<>()

// 1
		public Termitary(Vector position);
	
	// fait évoluer les termites
	// fait que des nouvelles termites
	// soient crées (certaines sexuées et certaines non)
	// utilise Termit::setMigrating() et Termit::setHome() et isDead
	// 1 + 1.5 pour les commentaires
	@Override
	public void update(float dt, Environment env);
	

	
	protected void reproduction(); // optionnel
	protected void setMigrationTarget(Vector v) {} //optionnel

	//1
	public void addWoodchip(Woodchip)
		{}

	//1
	public void addTermite(Termite);
	// 1
	public void removeTermite(Termite);
	

}


// FOURNI

interface Updatable
{
	void update(float dt, Environment env);
}

abstract class Positionable 
{
	private Vector position;
	
	public Positionable(Vector position) {}
	
	public Vector getPosition()
		{
			return position;
		}
	public void setPosition()
		{}
	
}

class Environment 
{
	private List<WoodChip>   woodchips   = new ArrayList<>();
	private List<Termitary>  termitaries = new ArrayList<>();
	
	// ajoute une termitière à une position donnée
	public void addTermitaryAt(Vector position){}

	// ajoute une brindille à une position donnée
	public void addWoodChipAt(Vector position){}

	// supprime une brindille donnée de l'ensemble de brindilles
	public void removeWoodChip(WoodChip woodChip){}
	
	// retourne true s'il existe une termitière à la position donnée
	public boolean existTermitaryAt(Vector position){}

	//retourne une brindille en collision avec une termite (suffisamment proche)
	public WoodChip getCollidingWoodChip(Termit termit){ return null;}
	

	// augmente de  1 le nombre de brindille de la termitière située à la position donnée
	public void increaseWoodQuantityAt(Vector position){}

	// fait évoluer les termitières
	public void simulate(float dt) {}

	public void removeTermitFromTermitary(Termit t, Vector TermitaryPosition);
	public void addTermitToTermitary(Termit t, Vector TermitaryPosition);
}


				
	
	
	
