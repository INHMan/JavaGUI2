import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Minimal Java Swing application.
 * 
 * @author Nathan Sprague
 * 
 */
public class GUIDemo extends JFrame
{
    private JPanel panel;
    private JButton biggerButton;
    private JButton smallerButton;
    private JButton teleportButton;
    private JButton randomSizeButton;
    
    /**
     * Set up the application.
     */
    public GUIDemo()
    {
        setTitle("Bigger/Smaller");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        biggerButton = new JButton("BIGGER");
        smallerButton = new JButton("SMALLER");
        teleportButton = new JButton("TELEPORT!");
        randomSizeButton = new JButton("RANDOM SIZE");
        biggerButton.addActionListener(new ButtonHandler());
        smallerButton.addActionListener(new ButtonHandler());
        teleportButton.addActionListener(new TeleportButtonHandler());
        randomSizeButton.addActionListener(new RandomSizeButtonHandler());
        add(panel);
        panel.add(biggerButton);
        panel.add(smallerButton);
        panel.add(teleportButton);
        panel.add(randomSizeButton);
        setVisible(true);
    }

    /**
     * This inner class exists to handle button events. There are other ways
     * this could have been done:
     * 
     * 1. GUIDemo could implement ActionListener itself. 
     * 2. Anonymous inner classes could be used to hand the events.
     */
    private class ButtonHandler implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            Dimension size = getSize();

            if (e.getSource().equals(biggerButton))
            {
                setSize(size.width + 10, size.height + 10);
            }
            else
            {
                setSize(size.width - 10, size.height - 10);
            }

        }
    }
    
    private class TeleportButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
				
			int newLocationX = (int)((Math.random() * 1920) + 1);
				
			int newLocationY = (int)((Math.random() * 1080) + 1);
				
			setLocation(newLocationX, newLocationY);
		}
  
    }
    
    private class RandomSizeButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int newLocationX = (int)((Math.random() * 1920) + 1);
			
			int newLocationY = (int)((Math.random() * 1080) + 1);
			
			setSize(newLocationX, newLocationY);
			
		}
  
    }

    /**
     * Start the app by creating a GUIDemo object.
     */
    public static void main(String[] args)
    {
        GUIDemo app = new GUIDemo();
    }
}
