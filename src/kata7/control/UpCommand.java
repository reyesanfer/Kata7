
package kata7.control;

import kata7.model.Block;

/**
 *
 * @author FernandoSanfielReyes
 * @version 1.0 2020/12/23 08:52 GMT
 *
 */

public class UpCommand implements Command{
    
    private final Block block;

    public UpCommand(Block block) {
        this.block = block;
    }

    @Override
    public void execute() {
        block.up();
    }

}
