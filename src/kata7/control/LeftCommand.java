
package kata7.control;

import kata7.model.Block;

/**
 *
 * @author FernandoSanfielReyes
 * @version 1.0 2020/12/23 08:51 GMT
 *
 */

public class LeftCommand implements Command{
    
    private final Block block;

    public LeftCommand(Block block) {
        this.block = block;
    }

    @Override
    public void execute() {
        block.left();
    }

}
