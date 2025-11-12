package Ex6;

class ToStringEq {
	public static void main(String[] args)
		{
			System.out.println("Test 1 :");
			Rectangle rect = new Rectangle(12.5, 4.0);
			System.out.println(rect);
			System.out.println();
			
			System.out.println("Test 2: ");
			// le type de rect1 est RectangleColore 
			// l'objet contenu dans rect1 est de type RectangleColore
			RectangleColore rect1 = new RectangleColore(12.5, 4.0, "rouge");
			System.out.println(rect1);
			System.out.println();

			System.out.println("Test 3 :");

            // le type de rect2 est Rectangle 
			// l'objet contenu dans rect2 est de type RectangleColore
			Rectangle  rect2 = new RectangleColore(25.0/2, 8.0/2, new String("rouge"));
			System.out.println(rect2);

			System.out.println (rect1.equals(rect2)); // 1.
			System.out.println (rect2.equals(rect1)); // 2.
			System.out.println(rect1.equals(null));   // 3.
			System.out.println (rect.equals(rect1));  // 4.
			System.out.println (rect1.equals(rect));  // 5.
		}
}

class Rectangle{
    protected double largeur;
    protected double hauteur;

    public Rectangle(double l, double h){
        this.hauteur = h;
        this.largeur = l;
    }

    @Override
    public String toString(){
        return "Rectangle:" + "\n\t largeur : " + largeur + "\n\t hauteur : " + hauteur;
    }

    @Override
    public boolean equals(Object object){
        if(object == null) return false;
        else {
            if(object.getClass() != Rectangle.class) return false;
            else
                return largeur == ((Rectangle) object).largeur && hauteur == ((Rectangle) object).hauteur;
        }
    }
}

class RectangleColore extends Rectangle{
    protected String color;
    public RectangleColore(double l, double h, String color) {
        super(l, h);
        this.color = color;
    }

    @Override
    public String toString(){
        return super.toString() + "\n\t couleur : " + color;
    }

    @Override
    public boolean equals(Object object){
        if(object == null) return false;
        else {
            if(object.getClass() != RectangleColore.class) return false;
            else
                return largeur == ((RectangleColore) object).largeur && hauteur == ((RectangleColore) object).hauteur
                        && color.equals(((RectangleColore) object).color);
        }
    }
}