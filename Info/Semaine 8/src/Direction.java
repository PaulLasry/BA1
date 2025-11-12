import java.util.ArrayList;

public class Direction {
    public static void main(String[] args) {
        EtudiantRegulier etudiant1 = new EtudiantRegulier("Peutimide", "Gaston", 2021
                , "SC", 6.0);
        EtudiantRegulier etudiant2 = new EtudiantRegulier("Rattrapeur", "Yvan", 2016
                , "SC", 2.5);
        EtudiantEchange etudiant3 = new EtudiantEchange("Borgue", "Björn", 2018, "IN"
                , "KTH");
        Enseignant enseignant1 = new Enseignant("Matheu", "Mathieu", 2015, "LMEP",
                10000, "Ph");
        Sectretaire secretaire1 = new Sectretaire("Scribona", "Sophie", 2005, "LMT",
                5000);

        EpflLiens tableau = new EpflLiens(etudiant1, etudiant2, etudiant3, enseignant1, secretaire1);
        tableau.afficher();
    }
}

class EpflLiens{
    private ArrayList<Personne> personnes = new ArrayList<>();
    private int nombreEtudiant;
    private double moyenneAgeEtudiant;

    public EpflLiens(Personne... personnes){
        this.nombreEtudiant = 0;
        double sommeAnnees = 0.0;
        for(Personne personne : personnes){
            if(personne instanceof Etudiant){
                this.nombreEtudiant++;
                sommeAnnees += 2024 - personne.getAnneInscription();
            }
            this.personnes.add(personne);
        }

        if (this.nombreEtudiant > 0) {
            this.moyenneAgeEtudiant = sommeAnnees / this.nombreEtudiant;
        } else {
            this.moyenneAgeEtudiant = 0.0;
        }
    }

    public void afficher(){
        System.out.println("Parmis les " + personnes.size() + " EPFLLiens, il y a " + nombreEtudiant +" étudiants");
        System.out.println("Ils sont la depuis " + moyenneAgeEtudiant + " ans en moyenne");
        System.out.println("Liste des EPFL Liens");
        for(Personne personne : personnes){
            System.out.println();
        }
    }
}

class Personne{
    private String nom;
    private String prenom;
    private int anneInscription;

    public Personne(String nom, String prenom, int anneInscription){
        this.nom = nom;
        this.prenom = prenom;
        this.anneInscription = anneInscription;
    }

    public String toString(){
        return "\n\tNom : " + nom + "\n\tPrenom : " + prenom + "\n\tAnnée : " +anneInscription;
    }

    public String getNom(){
        return this.nom;
    }
    public String getPrenom(){
        return this.prenom;
    }

    public int getAnneInscription(){
        return this.anneInscription;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public void setAnneInscription(int anneInscription){
        this.anneInscription = anneInscription;
    }
}

class Etudiant extends Personne{
    private String section;

    public Etudiant(String nom, String prenom, int anneInscription, String section){
        super(nom, prenom, anneInscription);
        this.section=section;
    }

    public String toString(){
        String personne = super.toString();
        return personne + "\n\tSection : " + section;
    }
}

class EtudiantRegulier extends Etudiant{
    private double notePrope;
    public EtudiantRegulier(String nom, String prenom, int anneInscription, String section, double notePrope){
        super(nom, prenom, anneInscription, section);
        this.notePrope=notePrope;
    }

    public String toString(){
        String etudiant = super.toString();
        return "Etudiant régulier :" + etudiant + "\n\tMoyenne : " + notePrope;
    }
}

class EtudiantEchange extends Etudiant{
    private String uniOrigine;
    public EtudiantEchange(String nom, String prenom, int anneInscription, String section, String uniOrigine){
        super(nom, prenom, anneInscription, section);
        this.uniOrigine=uniOrigine;
    }
    public String toString(){
        String etudiant = super.toString();
        return "Etudiant d'échange :" + etudiant + "\n\tUni d'origine : " + uniOrigine;
    }
}

class Employe extends Personne{
    private String labo;
    private double salaire;
    public Employe(String nom, String prenom, int anneInscription, String labo, double salaire){
        super(nom, prenom, anneInscription);
        this.labo = labo;
        this.salaire=salaire;
    }

    public String toString(){
        String personne = super.toString();
        return personne + "\n\tLaboratoire : " + labo + "\n\tSalaire : " + salaire;
    }
}

class Sectretaire extends Employe{
    public Sectretaire(String nom, String prenom, int anneInscription, String labo, double salaire){
        super(nom, prenom, anneInscription, labo, salaire);
    }
    public String toString(){

        return "Secrétaire : " + super.toString();
    }
}

class Enseignant extends Employe{
    private String section;
    public Enseignant(String nom, String prenom, int anneInscription, String labo, double salaire, String section){
        super(nom, prenom, anneInscription, labo, salaire);
        this.section = section;
    }

    public String toString(){
        String employe = super.toString();
        return "Enseignant : " +employe + "\n\tSection : " + section;
    }
}