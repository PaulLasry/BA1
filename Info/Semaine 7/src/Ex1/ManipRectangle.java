package Ex1;

public class ManipRectangle {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(1.5,12.8);
        System.out.println("Surface : " + rect.surface());
        rect.setLargeur(3.2);
        rect.setLargeur(6.9);
        System.out.println("Surface : " + rect.surface());
    }
}

class Rectangle{
    private double hauteur;
    private double largeur;

    public Rectangle(double hauteur, double largeur){
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    public double getHauteur(){
        return this.hauteur;
    }

    public double getLargeur(){
        return this.largeur;
    }

    public void setHauteur(double h){
        if(h > 0){
            h = -h;
        }
        this.hauteur = h;
    }

    public void setLargeur(double l){
        if(l > 0){
            l = -l;
        }
        this.largeur = l;
    }

    public double surface(){
        return hauteur * largeur;
    }
}