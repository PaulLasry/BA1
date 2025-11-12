import java.util.ArrayList;

// PROGRAMME PRINCIPAL (A NE PAS MODIFIER)
class Poste {

	public static void  main(String args[]) {
		//Cr'eation d'une boite-aux-lettres
		// 30  est la capacit'e maximale de la
		// boite aux lettres
		// (pas necessaire si vous dêcidez d'utiliser
		// un ArrayList).
		Boite boite = new Boite();

		//Creation de divers courriers/colis..
		Lettre lettre1 = new Lettre(200, true, "Chemin des Acacias 28, 1009 Pully", "A3");
		Lettre lettre2 = new Lettre(800, false, "", "A4"); // invalide

		Publicite pub1 = new Publicite(1500, true, "Les Moilles  13A, 1913 Saillon");
		Publicite pub2 = new Publicite(3000, false, ""); // invalide

		Colis colis1 = new Colis(5000, true, "Grand rue 18, 1950 Sion", 30);
		Colis colis2 = new Colis(3000, true, "Chemin des fleurs 48, 2800 Delemont", 70); //Colis invalide !

		boite.ajouterCourrier(lettre1);
		boite.ajouterCourrier(lettre2);
		boite.ajouterCourrier(pub1);
		boite.ajouterCourrier(pub2);
		boite.ajouterCourrier(colis1);
		boite.ajouterCourrier(colis2);


		System.out.println("Le montant total d'affranchissement est de " +
						   boite.affranchir());
		boite.afficher();
		
		System.out.println("La boite contient " + boite.courriersInvalides()
						   + " courriers invalides");
	}
}

class Boite{
    ArrayList<Envoi> envois;
    public Boite(){
        this.envois = new ArrayList<>();
    }

    public boolean ajouterCourrier(Envoi envoi){
        return this.envois.add(envoi);
    }

    public int courriersInvalides(){
        int nbCourrierInvalides = 0;
        for(Envoi courrier : envois){
            if(!courrier.isValid()) nbCourrierInvalides++;
        }
        return nbCourrierInvalides;
    }

    public double affranchir(){
        double montant = 0;
        for(Envoi envoi : envois){
            montant += envoi.affranchir();
        }
        return montant;
    }

    public void afficher(){
        for(Envoi envoi : envois){
            System.out.println(envoi);
        }
    }
}

class Envoi{
    private final double poid;
    private final boolean express;
    private final String addressExpedition;

    public Envoi(double poid, boolean express, String addressExpedition){
        this.poid = poid;
        this.express = express;
        this.addressExpedition = addressExpedition;
    }

    @Override
    public String toString(){
        return "\n\tPoid : " + poid + "\n\tEst express ? : " + (isExpress() ? "oui" : "non")
                + "\n\tAddresse de destination : " + addressExpedition;
    }

    public boolean isValid(){
        return !addressExpedition.isBlank();
    }

    public double getPoid() {
        return poid;
    }

    public String getAddressExpedition() {
        return addressExpedition;
    }

    public boolean isExpress() {
        return express;
    }

    public double affranchir(){
        assert this.isValid();
        double montant = 5 * (poid / 1000.0);
        return isExpress() ? (2*montant) : montant;
    }
}

class Lettre extends Envoi{
    private final String format;

    public Lettre(double poid, boolean express, String addressExpedition, String format){
        super(poid, express, addressExpedition);
        this.format = format;
    }

    @Override
    public double affranchir(){
        assert super.isValid();

        double montantBase = switch (format) {
            case "A3" -> 3.5;
            case "A4" -> 2.5;
            default -> throw new IllegalStateException("Unexpected value: " + super.getAddressExpedition());
        };
        double montant = montantBase + (super.getPoid())/1000.0;

        return super.isExpress() ? (2*montant) : montant;
    }

    @Override
    public String toString(){
        return "Courier" + "\n" + (super.isValid() ? "" : "(Courrier Invalide)") + super.toString()
                + "\n\tPrix : " + this.affranchir() + "\n\tFormat :" + format;
    }
}

class Colis extends Envoi{
    private final double volume;

    public Colis(double poid, boolean express, String addressExpedition, double volume){
        super(poid, express, addressExpedition);
        this.volume = volume;
    }

    @Override
    public boolean isValid(){
        return super.isValid() && volume <= 50;
    }

    @Override
    public double affranchir(){
        assert this.isValid();
        double montant = (0.25 * this.volume) + (super.getPoid()/1000.0);
        return super.isExpress() ? (2*montant) : montant;
    }

    @Override
    public String toString(){
        return "Colis" + "\n" + (this.isValid() ? "" : "(Colis Invalide)") + super.toString()
                + "\n\tPrix : " + this.affranchir() + "\n\tVolume : " + volume;
    }
}

class Publicite extends Envoi{
    public Publicite(double poid, boolean express, String addressExpedition){
        super(poid, express, addressExpedition);
    }

    @Override
    public String toString(){
        return "Publicité\n" + (super.isValid() ? "" : "(Publicité Invalide)") + super.toString()
                + "\n\tPrix : " + this.affranchir();
    }
}