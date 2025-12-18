
// TODO à CORRIGER POUR LE CORPS DE UPDATE
// + ajouter commentaire pour l'analyse
/* HIERARCHIE DE SOURCES DE LUMIERE
4.5 + 5.5 + 6.5 + 6.5 = */

/* Classe Light
   coquille implémentation et abstract: 1 pt 
   -0.5 pour override inutile de updatable
   -0.5 pour la présence d'un attribut position
Light: 4.5
 */
abstract class Light implements Updatable {

    //0.5
    private double intensity; // intensité de la source de lumière

    // 1
    public Light(double intensity){}

  // calcule la quantité d'énergie émise au cours du temps
  // en un  point donné p
  //2 
    abstract double getEnergyAt(Vec2d p);
}

/* Classe PointLight
   *  0.5 pour la coquille vide de classe
   *  0.5 pour l'héritage de Light
 PointLight = 5.5
 */
class PointLight extends Light {

    //0.5
  private Vec2d position;

  // 1.5
    public PointLight(double d_intensity,  Vec2d position){}
  // chaque type de lumière possède une méthode de calcul qui lui est propre

  // 1.25
    @Override
    double getEnergyAt( Vec2d position){}

  // 
  // fait changer l'intensité selon un algorithme spécifique.
  // 1.25
    @Override
    void update(double dt, Environment){}
  
}

/* Classe SpotLight
   *  0.5 pour la coquille vide de classe
   *  0.5 pour l'héritage de Light
   SpotLight = 6.5
 */
class SpotLight extends Light {

      //0.5
    private Vec2d position;
    //0.5
    private double angleOuverture;
  // 0.5
  private Vec2d diffusionDirection;
  //1.5
    public SpotLight(double intensity,  Vec2d  position,  Vec2d diffDirection, double angleOuverture) {}
  
  // chaque type de lumière possède une méthode de calcul qui lui est propre
  // 1.25
    @Override
    double getEnergyAt( Vec2d position){}
  
  // 1.25
  // fait changer l'intensité selon un algorithme spécifique.
    @Override
    void update(double dt, Environment){}
}

/* Classe DirectionalLight
   *  0.5 pour la coquille vide de classe
   *  0.5 pour l'héritage publique de Light
   DirectionalLight = 6.5
 */

class DirectionalLight extends Light {

  //0.5
  private double d_angle; // angle actuel

  // 1(pour la bonne modularisation)
    void rotate(double dt){} // tourne notre source de lumière à chaque pas de temps
    
  // 1.5
    public DirectionalLight(double d_intensity, double d_angle){}
  // chaque type de lumière possède une méthode de calcul qui lui est propre

  // 1.25
    @Override
    double getEnergyAt( Vec2d position){}
  
  // une source directionnelle se déplace à chaque pas de temps
  //appelle rotate()
  // 1.25 (dont 0.5 pour le commentaire)
    @Override
    void update(double dt, Environment){}
};

// fourni en partie
class Environment {
  private double width; // largeur de l'environnement
  private double height; // hauteur de l'environement
  private List <Light> lights; // ensemble des sources de lumière de l'environement
  private List <Plant> plants; // ensemble des plantes de l'environement
    
  // génère toutes les plantes initiales
  // en les repartissant aleatoirement 
    public Environment(double width, double height, int nbInitialPlants){}


  // met à jour les sources de lumieres et les plantes
  // decide de la fin de vie des plantes et les supprime
  // de la collection
    public void update(double dt){}


  // itère sur les sources de lumière
  // appelle leur méthode getEnergyAt
  // retourne la somme de la quantité d'énergie émise
  // par toutes les sources de lumière au point p
  //2.5 dont 1 pour le commentaire
    double getEnergyAt( Vec2d p) {}
  
    

  // methode pour ajouter une source de lumière
    protected boolean addLight(Light light) {}

  // methode pour ajouter une plante
    private boolean addPlant(Plant plant){}


};

/* FEUILLES ET PLANTES
3.5 + 11.5 + 2 (Env::getEnergyAt) = 17
 */

/* Classe Leaf
   coquille : .5
Leaf: 4
 */

class Leaf  {
   
//0.5 
   private Vec2d d_position; // position
    
  // 1
    public Leaf( Vec2d position) {}
  // 2 (dont 1 pour le commentaire)
  // nécessaire pour que la plante puisse connaitre combien d'énergie
  // est absorbée
    public Vec2d getPosition(){}
};

/* Classe Plant
   coquille  + : 0.5 + 0.5
Plant: 15
 */
class Plant implements  Updatable {
    // 0.5
    public final static double ENERGY_RATIO;
    // 0.5
    public final static double REPROD_TRESHOLD;
    // 0.5
    // donner aussi les points si AGE_MAX est
    // plutôt définie dans Leaf
    public final static  double AGE_MAX;
    //0.5
    Vec2 double position;
    //0.5
    double energie; // énergie de la plante
  // 0.5
    double age; // age de la plante
    //1.5
    List <Leaf> leaves; // ensemble des feuilles de la plante
  
    // appelle Environment.addPlant
  // utilise la position de la plante pour essaimer autour
  // 1 (dont 0.5 pour le commentaire)
    private void sowSeed(Environment env) {}

  // 1 dont 0,5 pour le commentaire
  // ajoute une feuille à une position aléatoire
    private void addLeaf(){}

 
    
  // initialise l'âge  zéro
  //2 (-0.25 par paramètre inutile)
    public Plant( Vec2d position, double energie){}
    public Plant(int nbLeaves, double age, Vec2d position, double energie){}

  //1 pour l'entête 
    @Override
    void update(double dt, Environment env) override  {
    // corps 
     age +=dt; //0.5
    //boucle 1.5
    for (Leaf leaf : leaves){
      d_energy += ENERGY_RATIO *
	env.getEnergyAt(leaf.getPosition()); 

    }
    loose_energy(dt); //0.5
    if (d_energy >= REPROD_THRESHOLD{ //1
      addLeaf(); // 0.5
      d_energy /=2; //0.5
    }
    if (isDead()) sowSeeds(env); //1.5
  }
  
  // retourne vrai si âge > ageMax
  // ou énergie <=0
  // nécessaire pour le update de l'environnement
  // 2 (dont 1 pour le commentaire)
  boolean isDead() ;
};



