package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the naruto to collect things.
 */
public class Pickup implements CollisionListener {
    private Naruto naruto;
    
    
    public Pickup(Naruto naruto) {
        this.naruto = naruto;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getReportingBody() instanceof Scroll && e.getOtherBody() == naruto) {
            naruto.incrementScrollCount();
            e.getReportingBody().destroy();
        }
            else if(e.getReportingBody() instanceof Snake && e.getOtherBody() == naruto) {
                naruto.decrementLifeCount();

            }
            else if(e.getReportingBody() instanceof Sasuke && e.getOtherBody() == naruto) {
                System.out.println("You Caught Sasuke, Level Complete!");
                e.getReportingBody().destroy();
                
            }
    }
    
}
