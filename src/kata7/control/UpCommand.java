
package kata7.control;

import kata7.model.Block;

/**
 *
 * @author FernandoSanfielReyes
 * @version 2.0 2021/01/14 00:48 GMT
 *
 */

public class UpCommand implements Command{
    
    private final Block block;

    public UpCommand(Block block) {
        this.block = block;
    }

    @Override
    public void execute() {
        if (block.y() < 7) {
            block.up();
        }
    }

}
