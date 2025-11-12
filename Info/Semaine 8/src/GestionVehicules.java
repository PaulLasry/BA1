/*
class GestionVehicules {
	// Pour repréesenter l'année courante:
	// Il est aussi bien sur possible d'utiliser la classe Date
	// pour r'ecupérer cette information automatiquement.
	private static int ANNEE_ACTUELLE = 2020;	
	/*
	public static void main(String[] args) {
		Vehicule[] garage = new Vehicule[3];
		Avion[] hangar = new Avion[2];

		garage[0] = new Vehicule("Peugeot", 2005, 147325.79, 2.5, 5, 180.0, 12000);
		garage[1] = new Vehicule("Porsche", 1999, 250000.00, 6.5, 2, 280.0, 81320);
		garage[2] = new Vehicule("Fiat", 2001, 7327.30, 1.6, 3, 65.0, 3000);

		hangar[0] = new Avion("Cessna", 1982, 1230673.90, "HELICES", 250);
		hangar[1] = new Avion("Nain Connu", 1993, 4321098.00, "REACTION", 1300);

		for (int i = 0; i < garage.length; i++) {
			garage[i].calculePrix(ANNEE_ACTUELLE);
			garage[i].affiche();
		}

		for (int i = 0; i < hangar.length; i++) {
			hangar[i].calculePrix(ANNEE_ACTUELLE);
			hangar[i].affiche();
		}
	}


}

class Vehicule {
    private String marque;
    private int dateAchat;
    private double prixAchat;
    private double prixCourant;

    public Vehicule(String marque, int dateAchat, double prixAchat, double prixCourant){
        this.marque = marque;
        this.dateAchat = dateAchat;
        this.prixAchat = prixAchat;
        this.prixCourant = prixCourant;
    }

    public void afficher(){
        System.out.print("Marque : " + marque +", date d'achat "+ dateAchat+", prix d'achat "+ prixAchat
                +", prix courant " + prixCourant);
    }

    public void calculerPrix(int anneeActuelle, double taux){
        int age = anneeActuelle - dateAchat;
        for(int i = 1; i <= age; i++){
            this.prixCourant += (taux/100.0) * this.prixCourant;
        }
    }
    public void calculerPrix(int anneeActuelle){
        calculerPrix(anneeActuelle, 1);
    }

    public String getMarque() {
        return marque;
    }

    public double getPrixCourant() {
        return prixCourant;
    }

    public void setPrixCourant(double prixCourant) {
        this.prixCourant = prixCourant;
    }
}

class Voiture extends Vehicule{

    private double cylindree;
    private int nombrePortes ;
    private double puissance ;
    private double kilometrage;

    public Voiture(String marque, int dateAchat, double prixAchat, double prixCourant) {
        super(marque, dateAchat, prixAchat, prixCourant);

    }

    public void calculerPrix(int anneeActuelle) {
        super.calculerPrix(anneeActuelle, 2);
        double nouveauPrix = super.getPrixCourant();
        String marque = super.getMarque();
        if(kilometrage % 10000 > 5000){
            nouveauPrix -= (5.0/100.0)*nouveauPrix;
        }
        if(marque.equals("Renault") || marque.equals("Fiat")){
            nouveauPrix -= (10.0/100.0)*nouveauPrix;
        } else if (marque.equals("Porsche")) {
            nouveauPrix += (20.0/100.0)*nouveauPrix;
        }
        super.setPrixCourant(nouveauPrix);
    }
}

class Avion extends Vehicule{
    private String typesMoteur;
    private double heureVol;

    public Avion(String marque, int dateAchat, double prixAchat, double prixCourant, String typesMoteur, double heureVol){
        super(marque, dateAchat, prixAchat, prixCourant);
        this.typesMoteur = typesMoteur;
        this.heureVol = heureVol;
    }

    public void afficher(){
        super.afficher();
        System.out.println(", type de moteur " + typesMoteur + ", heures de vol " +heureVol);
    }

    public void calculerPrix(int anneeActuelle){
        double nouveauPrix = super.getPrixCourant();
        if(typesMoteur.equals("HELICES")){

        }
    }
}
 */