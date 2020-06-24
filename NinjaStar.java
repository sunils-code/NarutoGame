package game;

import city.cs.engine.*;

/**
 * A ninja star.
 */
public class NinjaStar extends DynamicBody {
    private NinjaStar star;
    private static final float radius = 0.5f;
    private static final Shape starShape = new CircleShape(radius);
    private static final BodyImage starImage =
        new BodyImage("data/shuriken-2.png", 2*radius);

    /**
     * Construct a ninja star.
     */
    public NinjaStar(World world) {
        super(world, starShape);
        addImage(starImage);
        
        this.addCollisionListener(new Kill(star));
        
    }
}