package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the NinjaStars to Kill the Snake.
 */
public class Kill implements CollisionListener {
   
    private NinjaStar star;
   
    public Kill(NinjaStar star){
        this.star = star;
    }
   
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Snake) {
           if (e.getReportingBody() instanceof NinjaStar){
               e.getOtherBody().destroy();
               e.getReportingBody().destroy();
               System.out.println("You Defeated Orochimaru!");
           }
        }
    }
}