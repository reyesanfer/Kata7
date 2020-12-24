package kata7.view;

/**
 *
 * @author FernandoSanfielReyes
 * @version 1.0 2020/12/23 08:53 GMT
 *
 */

public interface BlockDisplay {
    
    public static final int SIZE = 100;
    
    public void paintBlock(int x, int y);
    public void on(Moved moved);
    
    public interface Moved {
        void to(int x, int y);
    }
    
}
