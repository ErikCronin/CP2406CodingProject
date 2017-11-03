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
    int winnerScore = 0;


    public tronbg()
    {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        tronmain colourSearch = new tronmain();
        int cycleColour = colourSearch.tronbgCycleColour();
        Graphics2D cycle = (Graphics2D) g;
        Graphics2D currentScore = (Graphics2D) g;

        currentScore.drawString("Score: " + Integer.toString(winnerScore),15,15);

        if(cycleColour == 0)
        {
            cycle.setColor(Color.RED);
        }
        else if(cycleColour == 1)
        {
            cycle.setColor(Color.GREEN);
        }
        else if(cycleColour == 2)
        {
            cycle.setColor(Color.BLUE);
        }
        else if(cycleColour == 3)
        {
            cycle.setColor(Color.BLACK);
        }
        else if(cycleColour == 4)
        {
            cycle.setColor(Color.WHITE);
        }
        else if(cycleColour == 5)
        {
            cycle.setColor(Color.ORANGE);
        }
        else if(cycleColour == 6)
        {
            cycle.setColor(Color.PINK);
        }
        else if(cycleColour == 7)
        {
            cycle.setColor(Color.YELLOW);
        }
        else if(cycleColour == 8)
        {
            cycle.setColor(Color.MAGENTA);
        }
        cycle.fillRect(locx,locy,15, 15);
        paintComponent(cycle);
    }

    public void paintComponent(Graphics p)
    {
        Graphics2D trail = (Graphics2D) p;
        trail.fillRect(beginX,beginY,15,15);
    }

    public void actionPerformed(ActionEvent e)
    {

        if(locx <= 0 || locy <= 0)
        {
            gameOver(winnerScore);
            System.exit(0);
        }
        else if(locx >= (gridWidth - 15) || locy >= (gridHeight - 30))
        {
            gameOver(winnerScore);
            System.exit(0);
        }
        else
            repaint();
            locx += velx;
            locy += vely;
            winnerScore++;
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

    public static void gameOver(int score)
    {
        JOptionPane.showMessageDialog(null, "You have died! Your score was " + score, "GAME OVER",
                JOptionPane.PLAIN_MESSAGE);
    }
}