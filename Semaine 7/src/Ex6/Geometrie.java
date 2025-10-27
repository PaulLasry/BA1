package Ex6;

import java.util.Scanner;

public class Geometrie {
    public static void main(String[] args) {
        Triangle t = Triangle.creerTriangleDepuisLaConsole();

        System.out.println("Périmètre : " + t.perimetre());
        System.out.println("Le triangle " + (t.isIsocele() ? "est " : "n'est pas ") + "isocèle");
    }
}

class Triangle{
    private Point p1;
    private Point p2;
    private Point p3;
    private double cote1;
    private double cote2;
    private double cote3;

    private static final double EPSILON = 0.000001;

    public Triangle(Point p1, Point p2, Point p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.cote1 = Point.distance(this.p1, this.p2);
        this.cote2 = Point.distance(this.p2, this.p3);
        this.cote3 = Point.distance(this.p3, this.p1);
    }

    public static Triangle creerTriangleDepuisLaConsole(){
        Point p1 = Point.creerPointDepuisLaConsole();
        Point p2 = Point.creerPointDepuisLaConsole();
        Point p3 = Point.creerPointDepuisLaConsole();

        return new Triangle(p1, p2, p3);
    }

    public double perimetre(){
        return cote1 + cote2 + cote3;
    }

    public boolean isIsocele() {
        boolean c1_eq_c2 = Math.abs(cote1 - cote2) < EPSILON;
        boolean c1_eq_c3 = Math.abs(cote1 - cote3) < EPSILON;
        boolean c2_eq_c3 = Math.abs(cote2 - cote3) < EPSILON;

        return c1_eq_c2 || c1_eq_c3 || c2_eq_c3;
    }
}

class Point{
    private double x;
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public static Point creerPointDepuisLaConsole(){
        System.out.println("Création d'un point");
        Scanner kyb = new Scanner(System.in);
        System.out.print("   Veuillez entrer x : ");
        double x = kyb.nextDouble();
        System.out.print("   Veuillez entrer y : ");
        double y = kyb.nextDouble();

        return new Point(x, y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static double distance(Point p1, Point p2){
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();

        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }
}

