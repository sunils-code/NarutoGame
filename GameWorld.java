package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Sunil Sheemar
 */

/**
 * A world with some bodies.
 */
public class GameWorld extends World {
    private Naruto naruto;
    private Sasuke sasuke;
    private Scroll scroll;
    private Snake snake;
//    private NinjaStar ninjaStar;
    
    public GameWorld() {
        super();
        
        
        // make the ground
        Shape groundShape = new BoxShape(51, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -12.5f));
        
        //walls
        Shape leftWallShape = new BoxShape(0.5f, 13, new Vec2(-51.5f, 12.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        
        Shape rightWallShape = new BoxShape(0.5f, 13, new Vec2(51.5f, 12.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);
        
        // create the ceiling
        Shape Ceiling = new BoxShape(51, 0.5f);
        Body ceiling = new StaticBody(this, Ceiling);
        ceiling.setPosition(new Vec2(0, 12.5f));
        
        

        // make platforms
        Shape platformShape = new BoxShape(7, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-6, -6));
        

        // make naruto character
        naruto = new Naruto(this);
        naruto.setPosition(new Vec2(-22, -9.5f));
        
        // make sasuke character
        sasuke = new Sasuke(this);
        sasuke.setPosition(new Vec2(20, -10.5f));
        sasuke.addCollisionListener(new Pickup(naruto));
        sasuke.startWalking(1.5f);
 
        // make snake character
        snake = new Snake(this);
        snake.setPosition(new Vec2(15, -11.5f));
        snake.addCollisionListener(new Pickup(naruto));
        snake.startWalking(-2.8f);
        
        // make scrolls
        for (int i = 0; i < 5; i++) {
            Body scroll = new Scroll(this);
            scroll.setPosition(new Vec2(i*2-10, -4));
            scroll.addCollisionListener(new Pickup(naruto));
            
            
        }
    }
    
    public Naruto getPlayer() {
        return naruto;
    }
}
