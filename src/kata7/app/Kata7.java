package kata7.app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import kata7.control.*;
import kata7.model.Block;
import kata7.view.BlockDisplay;

/**
 *
 * @author FernandoSanfielReyes
 * @version 3.0 2021/01/13 20:46 GMT
 *
 */

public class Kata7 extends JFrame{
    
    private Block block;
    private BlockDisplay blockDisplay;
    private BlockPresenter blockPresenter;
    private HashMap<String,Command> commands;

    public static void main(String[] args) {
        new Kata7().execute();
    }

    public Kata7() {
        this.setTitle("Block shifter");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(717, 779);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().add(blockPanel());
        KeyHandler keyHandler = new KeyHandler();
        addKeyListener(keyHandler);
        setFocusable(true);
        this.add(toolbar(), BorderLayout.SOUTH);
    }
    
    private void execute() {
        this.block = new Block(4,4);
        this.blockPresenter = new BlockPresenter(block, blockDisplay);
        this.commands = createCommands();
        this.setVisible(true);
    }

    private JPanel blockPanel() {
        BlockPanel panel = new BlockPanel(Block.MAX);
        this.blockDisplay = panel;
        return panel;
    }
    
    private HashMap<String, Command> createCommands(){
        HashMap<String,Command> commands = new HashMap<>();
        commands.put("UP", new UpCommand(block));
        commands.put("DOWN", new DownCommand(block));
        commands.put("LEFT", new LeftCommand(block));
        commands.put("RIGHT", new RightCommand(block));
        return commands;
    }
    
    private JMenuBar toolbar() {
        JMenuBar result = new JMenuBar();
        result.setLayout(new FlowLayout(FlowLayout.CENTER));
        result.add(button("UP"));
        result.add(button("DOWN"));
        result.add(button("LEFT"));
        result.add(button("RIGHT"));
        return result;
    }
    
    private JButton button(String command) {
        JButton button = new JButton(command);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(command).execute();
            }
        });
        return button;
    }
    
        private class KeyHandler implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W') {
                UpCommand up = new UpCommand(block);
                up.execute();
            }
            if (e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
                DownCommand down = new DownCommand(block);
                down.execute();
            }
            if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
                LeftCommand left = new LeftCommand(block);
                left.execute();
            }
            if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
                RightCommand right = new RightCommand(block);
                right.execute();
            }
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getExtendedKeyCode() == KeyEvent.VK_UP) {
                UpCommand up = new UpCommand(block);
                up.execute();
            }
            if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
                DownCommand down = new DownCommand(block);
                down.execute();
            }
            if (e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
                LeftCommand left = new LeftCommand(block);
                left.execute();
            }
            if (e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
                RightCommand right = new RightCommand(block);
                right.execute();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } 
    }
}
