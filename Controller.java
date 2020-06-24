package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Key handler to control an Walker.
 */
public class Controller extends KeyAdapter {

    private static final float JUMPING_SPEED = 13;
    private static final float WALKING_SPEED = 7;

    private Walker body;
    private WorldView view;
    boolean FacingR = true;

    private NinjaStar ninjaStar;

    public Controller(Walker body, WorldView view) {
        this.body = body;
        this.view = view;
    }

    /**
     * Handle key press events for walking and jumping.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_W) { // J = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_A) {
            body.startWalking(-WALKING_SPEED); // A = walk left
            FacingR=false;
            body.removeAllImages();
            body.addImage(Naruto.getLeft());
        } else if (code == KeyEvent.VK_D) {
            FacingR=true;
            body.startWalking(WALKING_SPEED); // D = walk right
            body.removeAllImages();
            body.addImage(Naruto.getRight());
        } else if (code == KeyEvent.VK_SPACE) {
            if (FacingR == true) {
                ninjaStar = new NinjaStar(view.getWorld());
                ninjaStar.setPosition(new Vec2(body.getPosition()));
                ninjaStar.applyImpulse(new Vec2(60, 0));
                
            }
            if(FacingR==false){
            ninjaStar = new NinjaStar(view.getWorld());
                ninjaStar.setPosition(new Vec2(body.getPosition()));
                ninjaStar.applyImpulse(new Vec2(-60, 0));
            }
        }
    }

    /**
     * Handle key release events (stop walking).
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            body.stopWalking();
        }
    }
}
