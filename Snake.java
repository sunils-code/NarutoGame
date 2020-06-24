package game;

import city.cs.engine.*;

/**
 * Snake character
 */
public class Snake extends Walker {


    private static final Shape shape = new PolygonShape(
            -1.11f,2.43f, 0.52f,2.39f, 2.44f,-1.2f, 1.06f,-2.37f, -1.79f,-2.36f, -2.49f,-1.34f);

    private static final BodyImage image =
        new BodyImage("data/snake1.gif", 5);

    public Snake(World world) {
        super(world, shape);
        addImage(image);
        
    }

}