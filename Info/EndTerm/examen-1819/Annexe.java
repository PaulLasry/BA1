/***************************************************
 *
 *       Annexe: Types principaux disponibles
 *
 ************************************************* */

/* classe représentant un vecteur à 3  dimensions,
   permet de représenter des positions et des volumes
*/

class Vec3d {
    /*contenu  de la classe non nécessaire ici */
};



/* Interface représentant des objets  évoluant au cours du temps
 */

interface Updatable {
    void update(double dt);
}

/* Ebauche de classe à compléter
 */

class Aquarium implements Updatable {
    // Classes Fish et Food à compléter
    
    // collection de poissons de l'aquarium
    private List<Fish> fishes;
    
    // collection de nutriments pour les poissons
    private List<Food> food;

    // fait évoluer l'aquarium et son contenu
    public void update(double dt) { }

    // methods to add or remove objects
    // from the fish and food collections
    
    void addFish();
    void addFood();
    void removeFood(Food);
    void removeFish(Fish);
}
