package game;

import city.cs.engine.*;

/**
 * Sasuke character
 */
public class Sasuke extends Walker {

    private static final Shape shape = new PolygonShape(
            0.09f,1.7f, 1.71f,0.81f, 1.46f,-1.67f, -1.56f,-1.55f, -1.28f,-0.15f);

    private static final BodyImage image =
        new BodyImage("data/sasuke_2.gif", 5);

    public Sasuke(World world) {
        super(world, shape);
        addImage(image);
    }

}