import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class tronMain extends JFrame
{
    int x, y;
    int colourGen = lightCycle();

    public class AL extends KeyAdapter
    {

        public void keyPressed(KeyEvent e)
        {
            int keyCode = e.getKeyCode();
            if(keyCode == e.VK_A)
            {
                x=x-2;
            }

            if(keyCode == e.VK_D)
            {
                x=x+2;
            }

            if(keyCode == e.VK_W)
            {
                y=y-2;
            }

            if(keyCode == e.VK_S)
            {
                y=y+2;
            }
        }

        public void keyReleased(KeyEvent e)
        {

        }
    }

    public tronMain()
    {
        x = 150;
        y = 150;
        String lcColour = "";

        if(colourGen == 0)
        {
            lcColour = "Red";
        }
        else if(colourGen == 1)
        {
            lcColour = "Green";
        }
        else if(colourGen == 2)
        {
            lcColour = "Blue";
        }
        else if(colourGen == 3)
        {
            lcColour = "Black";
        }
        else if(colourGen == 4)
        {
            lcColour = "White";
        }
        else if(colourGen == 5)
        {
            lcColour = "Orange";
        }
        else if(colourGen == 6)
        {
            lcColour = "Pink";
        }
        else if(colourGen == 7)
        {
            lcColour = "Yellow";
        }
        else if(colourGen == 8)
        {
            lcColour = "Magenta";
        }

        /* Initial set up done before running the game */
        /* Will receive each player name as they are input from player() function */
        String player = createPlayer();

        /* Sends winning player's name and jet wall length to leader board */

        /* Creates grid based on user input */
        /* Grid width creation */
        String gridWidth = "width";
        int createGridX = createGrid(gridWidth);
        /* Grid height creation */
        String gridHeight = "height";
        int createGridY = createGrid(gridHeight);

        /* Startup Menu completion */
        JOptionPane.showMessageDialog(null, "Hello " + player + "!\nYou will have a(n) " +
                        lcColour + " light cycle.\nYour grid size is: " + createGridX + " by " + createGridY,
                "Game Setup", JOptionPane.PLAIN_MESSAGE);

        addKeyListener(new AL());
        setTitle("TRAWN");
        setSize(createGridX, createGridY);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static int createGrid(String widthOrHeight)
    {
        int createGrid;
        String gridInput = JOptionPane.showInputDialog(null, "Please enter desired "
                + widthOrHeight + ". (Between 500 and 10,000)", widthOrHeight, JOptionPane.PLAIN_MESSAGE);
        createGrid = Integer.parseInt(gridInput);

        /* Grid error check */
        if(createGrid < 500 || createGrid > 10000)
        {
            while(createGrid < 500)
            {
                gridInput = JOptionPane.showInputDialog(null, "Sorry that was too low. " +
                                "Please reinput " + widthOrHeight + ". (Between 500 and 10,000)",
                        "TOO LOW!", JOptionPane.PLAIN_MESSAGE);
                createGrid = Integer.parseInt(gridInput);
            }

            while(createGrid > 10000)
            {
                gridInput = JOptionPane.showInputDialog(null, "Sorry that was too high. " +
                                "Please reinput " + widthOrHeight + ". (Between 500 and 10,000)",
                        "TOO HIGH!", JOptionPane.PLAIN_MESSAGE);
                createGrid = Integer.parseInt(gridInput);
            }
        }
        return createGrid;
    }

    private static String createPlayer()
    {
        /* Ask for player name. */
        String nameInput = JOptionPane.showInputDialog(null, "Please enter your name: ",
                "Enter your name :)", JOptionPane.PLAIN_MESSAGE);
        return nameInput;

        /* If first player input, how many players? (must be at least 2) */
    }

    private static int lightCycle()
    {
        /* Must always be facing inwards away from grid */
        /* Given random colour from a selection of 9 (red, green, blue, black, white, orange, pink, yellow, purple) */
        Random dice = new Random();
        int number;
        number = dice.nextInt(8);
        return number;
        /* cannot stop once cycle has started, can speed up and slow down */
        /* Light cycle and jet trail are the same colour */
    }

    public void paint(Graphics g)
    {
        if(colourGen == 0)
        {
            g.setColor(Color.RED);
        }
        else if(colourGen == 1)
        {
            g.setColor(Color.GREEN);
        }
        else if(colourGen == 2)
        {
            g.setColor(Color.BLUE);
        }
        else if(colourGen == 3)
        {
            g.setColor(Color.BLACK);
        }
        else if(colourGen == 4)
        {
            g.setColor(Color.WHITE);
        }
        else if(colourGen == 5)
        {
            g.setColor(Color.ORANGE);
        }
        else if(colourGen == 6)
        {
            g.setColor(Color.PINK);
        }
        else if(colourGen == 7)
        {
            g.setColor(Color.YELLOW);
        }
        else if(colourGen == 8)
        {
            g.setColor(Color.MAGENTA);
        }

        g.fillOval(x, y, 15, 15);


        repaint();
    }

    public static void main(String[] args)
    {
        new tronMain();
    }
}