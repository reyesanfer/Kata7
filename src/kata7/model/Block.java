
package kata7.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author FernandoSanfielReyes
 * @version 2.0 2020/12/24 14:42 GMT
 *
 */

public class Block {
    
    private int x;
    private int y;
    public static final int MAX = 7;
    private final Timer timer;
    private final List<Observer> observers = new ArrayList<>();

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
        this.timer = new Timer();
        this.timer.schedule(task(), 1000, 650);
    }

    public int x() {
        return this.x;
    }
    
    public int y(){
        return this.y;
    }
    
    public void left() {
        if (this.x == 1) return;
        this.x--;
        changed();
    }

    public void rigth() {
        if (this.x == MAX) return;
        this.x++;
        changed();
    }
    
    public void up() {
        if (this.x == MAX) return;
        this.y++;
        changed();
    }
    
    public void down() {
        if (this.y == 1) return;
        this.y--;
        changed();
    }

    private TimerTask task() {
        return new TimerTask() {
            @Override
            public void run() {
                double r = Math.random();
                if (r >= 0.20) return;
                if (r >= 0.15) left();
                else if (r >= 0.10) rigth();
                else if (r >= 0.05) up();
                else if (r >= 0.00) down();
            }
        };
    }
    
    private void changed() {
        for (Observer observer : observers) observer.changed();
    }
    
    public void register(Observer observer){
        observers.add(observer);
    }

    public void movedTo(int x, int y) {
        this.x = x;
        this.y = y;
        changed();
    }
    
    public interface Observer {
        void changed();
    }
    
}
