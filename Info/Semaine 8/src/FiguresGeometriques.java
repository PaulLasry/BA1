/*
class FiguresGeometriques {

	public static void main(String[] args) {
        RectangleColore r = new RectangleColore(4.3, 12.5, 4);
        System.out.println(r.getLargeur());
	}


}

class Figure{
    private double x;
    private double y;

    public Figure(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Figure(){
        this(0, 0);
    }

    public void afficher(){
        System.out.println("x : " + x + " y :" + y);
    }

    public double x(){
        return x;
    }
    public double y(){
        return y;
    }
    public void x(double x){
        this.x = x;
    }
    public void y(double y){
        this.y = y;
    }
}

class Rectangle extends Figure {

	private double largeur;
	private double longueur;

	public Rectangle(double largeur, double longueur) {
		this.largeur = largeur;
		this.longueur = longueur;
	}

	public double surface() {
		return largeur * longueur;
	}

	public double getLongueur() {
		return longueur;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double l) {
		largeur = l;
	}

	public void setLongueur(double l) {
		longueur = l;
	}
}

class RectangleColore extends Rectangle{
    private int color;

    public RectangleColore(double l, double h, int color){
        super(l, h);
        this.color = color;
    }
}

class Cercle extends Figure{
	private double rayon;

	public Cercle(double x, double y, double r) {
        super(x, y);
		rayon = r;
	}

	public void affiche() {
        super.afficher();
		System.out.println("rayon = " + rayon);
	}

	public double getX() {
		return super.x();
	}

	public double getY() {
		return super.y();
	}

	public void setCentre(double x, double y) {
	}

	public boolean estInterieur(double x, double y) {
		return (((x - this.x) * (x - this.x) + (y - this.y) * (y - this.y))
					<= rayon * rayon);
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double r) {
		if (r < 0.0) r = 0.0;
		rayon = r;
	}
}

 */
