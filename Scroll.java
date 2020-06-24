package game;

import city.cs.engine.*;

/**
 * Scroll Object
 */
public class Scroll extends StaticBody {

    private static final Shape shape = new PolygonShape(
            -0.099f,0.922f, 0.401f,0.904f, 0.888f,0.331f, 0.089f,-0.945f, -0.482f,-0.961f, -0.854f,-0.581f, -0.318f,0.604f);

    private static final BodyImage image =
        new BodyImage("data/scroll.gif", 2);

    public Scroll(World world) {
        super(world, shape);
        addImage(image);
        
    }

}
