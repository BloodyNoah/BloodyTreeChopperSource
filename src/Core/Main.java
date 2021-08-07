
package Core;

import java.awt.Graphics2D;

import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

@ScriptManifest(author = "BloodyNoah", info = "Simple Power Chopper", name = "Bloody Tree Chopper", version = 0, logo = "")
public class Main extends Script {

    @Override
    public void onStart() {
        log("Let's get started!");
    }

    @Override
    public int onLoop() throws InterruptedException {
        RS2Object tree = getObjects().closest("Tree");

        if(getInventory().isFull()){
            log("Dropping Logs");
            getInventory().dropAll("logs");
        }
        else if(tree != null && !myPlayer().isAnimating()){
            log("Chopping...");
            tree.interact("Chop down");
            sleep(random(100, 1000));
        }
        return random(500, 1000);

    }

    @Override
    public void onExit() {
        log("Thanks for running my Script!!!");
    }

    @Override
    public void onPaint(Graphics2D g) {

    }

}