import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class tronbg extends JPanel implements ActionListener, KeyListener
{
    Timer t = new Timer(3, this);

    //location X & Y, Velocity X & Y
    tronmain bikePlaceX = new tronmain();
    tronmain bikePlaceY = new tronmain();
    int gridWidth = bikePlaceX.gridStartX();
    int gridHeight = bikePlaceY.gridStartY();
    int beginX = startSpot(gridWidth);
    int beginY = startSpot(gridHeight);
    int locx = beginX, locy = beginY, velx = 0, vely = 0;

    public tronbg()
    {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paint(Graphics g)
    {
        tronmain colourSearch = new tronmain();

        int cycleColour = colourSearch.tronbgCycleColour();

        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        if(cycleColour == 0)
        {
            g2.setColor(Color.RED);
        }
        else if(cycleColour == 1)
        {
            g2.setColor(Color.GREEN);
        }
        else if(cycleColour == 2)
        {
            g2.setColor(Color.BLUE);
        }
        else if(cycleColour == 3)
        {
            g2.setColor(Color.BLACK);
        }
        else if(cycleColour == 4)
        {
            g2.setColor(Color.WHITE);
        }
        else if(cycleColour == 5)
        {
            g2.setColor(Color.ORANGE);
        }
        else if(cycleColour == 6)
        {
            g2.setColor(Color.PINK);
        }
        else if(cycleColour == 7)
        {
            g2.setColor(Color.YELLOW);
        }
        else if(cycleColour == 8)
        {
            g2.setColor(Color.MAGENTA);
        }
        g2.fillRect(locx,locy,15, 15);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(locx <= 0 || locy <= 0)
        {
            gameOverMsg();
        }
        else if(locx >= (gridWidth - 15) || locy >= (gridHeight - 30))
        {
            gameOverMsg();
        }
        else
            repaint();
            locx += velx;
            locy += vely;
    }

    public void up()
    {
        vely = -1;
        velx = 0;
    }

    public void down()
    {
        vely = 1;
        velx = 0;
    }

    public void left()
    {
        vely = 0;
        velx = -1;
    }

    public void right()
    {
        vely = 0;
        velx = 1;
    }

    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W)
        {
            up();
        }

        if(code == KeyEvent.VK_S)
        {
            down();
        }

        if(code == KeyEvent.VK_A)
        {
            left();
        }

        if(code == KeyEvent.VK_D)
        {
            right();
        }
    }

    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}

    public static int startSpot(int bikeRoll)
    {
        //Rolls die to assign a random colour to player
        Random dice = new Random();
        int number;
        number = dice.nextInt(bikeRoll);
        return number;
    }

    public static void gameOverMsg()
    {
        JOptionPane.showMessageDialog(null, "You have died! Please Try Again :)", "GAME OVER",
                JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }
}