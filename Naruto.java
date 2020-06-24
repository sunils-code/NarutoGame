package game;

import city.cs.engine.*;

/**
 * Naruto character
 */
public class Naruto extends Walker {

    Shape shape = new PolygonShape(
            -1.68f,-0.74f, 0.9f,-0.75f, 0.9f,-1.84f, -1.74f,-1.84f);

    private static final BodyImage right =
        new BodyImage("data/naruto_1.gif", 3.75f);
    
    private static final BodyImage left =
        new BodyImage("data/naruto_l.gif", 3.75f);

    private int scrollCount;
    private int lifeCount;
//
    
    public Naruto(World world) {
        super(world);
        Shape lower = new PolygonShape(
            -0.76f,-0.79f, -0.78f,-1.8f, -1.7f,-1.8f, -1.65f,-0.84f);
            SolidFixture lowerFixture= new SolidFixture(this, lower);
            
            Shape mid = new PolygonShape(
            -0.65f,0.12f, -0.73f,-1.82f, 0.65f,-1.84f, 0.69f,0.12f);
            SolidFixture midFixture= new SolidFixture(this, mid);
        
            Shape head = new PolygonShape(
           1.58f,1.0f, 1.59f,-0.57f, 0.68f,-0.57f, 0.7f,1.01f);
            SolidFixture headFixture= new SolidFixture(this, head);
        
        addImage(right);
        scrollCount = 0;
        lifeCount = 1;
        
    }

    public static BodyImage getRight() {
        return right;
    }

    public static BodyImage getLeft() {
        return left;
    }
        
    public int getScrollCount() {
        return scrollCount;
    }

    public void incrementScrollCount() {
        scrollCount++;
        System.out.println("Scroll Count = " + scrollCount);
    }
    
    public int getLifeCount() {
        return lifeCount;
    }

    public void decrementLifeCount() {
        lifeCount--;
        System.out.println("Life Count = " + lifeCount);
        if(lifeCount == 0){
        Naruto.this.destroy();
        System.out.println("Naruto Died");
        System.exit(lifeCount);
        }
    }

}
