// Note: the students may have chosen other names for the classes
// methods and attributes.
// This a possible solution. Any other solution that satisfies the
// specifications, as stated in the exam questions, must be accepted.


class Vessel implements Updatable, Drawable
{

    // utile pour la modularisation

    private void createMuscularCells() {} // called by ctor

    private void generateRandomBloodCells() {} // called by update


    private double length;

    private double rv; //1/2 taille intérieure du vaisseau (hauteur)mus

    private double muscThickness;
    // m in the exam

    private List <Cell> cells;

    private double viscosity;    /* coeff de viscosité */

    // for part 2 of the exercise
        private  int muscularCellCount;
    private int  initialMuscularCellCount;

    // generates the muscle cells: calls generateMuscularCells()
    public Vessel(double rv, double thickness, double length, double viscosity) {}


    // used to compute the  BloodCell's speed at their creation

    public double getPressureGradientAt(Vec2d position) {}


    public double getViscosity() {}

    // used by MuscCell.takeOxygen()
    public double getOxygenAt(Vec2d) {}

    // to know if a cell is inside the vessel
    // (modularisation)
    public boolean isInside(Vec2d p) {}

    // draws all the cells
    @Override
    public void draw(Canvas canvas)
    {
    }

    @Override
    public void update(double dt)
    {
        // 1
        generateRandomBloodCells();
        // 0.5 pour la boucle
        for (int i=0; i < cells.size(); ++i) {
            // 1
            cells[i].update(dt);

            if (cells[i].isDead()) {
                cells.remove(i);
		--i;
            }
        }
    }

    //  dies is the number os MuscleCell is reduced by half
    // when compared to their creation at the Vessel's construction
    public bool isDead() {}


    // can be used by generateMuscularCells and BloodCellGenerator
    // 0.5 bonus
    public bool addCell(Cell cell) {}

    public void decreaseMuscCellCount() {}


};



/* Classe Cell 
*/

abstract class Cell implements Updatable, Drawable
{
    private Vec2d position;
    private Vessel  owner;

    // must not redefine draw and update
    // malus of -0.5 in case of useless redefinition

    public Cell (Vessel owner,  Vec2d position) {}

    public abstract bool isDead();


    // needed by  the update methods of the subclasses
    protected Vessel getOwner() {}

    // needed to move
    //  can also be coded as:
    // void move(double dy)
     protected void setPosition( Vec2d newPosition) {}

}

/* Classe BloodCell 
*/
class BloodCell extends Cell
{

    // bonus +0.5 if private
    // computes the new position using the speed
    // and current position (modularisation)
    private void move(double dt) {}

    private final Vec2d speed;

    
    // uses owner.getViscosity() and owner.getPressureGradientAt()
    public BloodCell(Vessel owner,  Vec2d position) {}

    // calls move(dt)
    @Override
    public void update(double dt) {}

    // 1.5 dont 0.5 pour les explications
    // dies if outside the vessel
    public boolean isDead() {}

    @Override
    public void draw(Canvas w) {}


}

/* Classe MuscCell 
*/

class MuscCell extends  Cell
{

    
    private void looseOxygen(double dt);

    // uses owner.getOxygenAt(getPosition());
    private void takeOxygen();

    // level of oxygen in the cell
    private double oxygen;

    public MuscCell(Vessel owner,  Vec2d position) {}

    //uses looseOxygen et takeOxygen
    @Override
    public void update(double dt) {}

    // 0.5

    @Override
    void draw(Canvas w) {}

    // dies if the level of oxygen is too low
    @Override
    bool isDead() {}


};

