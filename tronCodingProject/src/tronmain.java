import javax.swing.*;
import java.util.Random;

public class tronmain
{
    public static int chosenColour;
    public static void main(String args[])
    {
        //Initial Variable Set-Up
        String player = "";
        String gridWidth = "width";
        String gridHeight = "height";
        int chosenGridWidth = 0;
        int chosenGridHeight = 0;
        String lcColour = "";

        //Input Player Name
        player = createPlayer();

        //User Input for creating grid
        //Creates Grid Width
        chosenGridWidth = createGrid(gridWidth);
        //Creates Grid Height
        chosenGridHeight = createGrid(gridHeight);

        //Decides chosen colour for player
        chosenColour = colourGen();
        if(chosenColour == 0)
        {
            lcColour = "Red";
        }
        else if(chosenColour == 1)
        {
            lcColour = "Green";
        }
        else if(chosenColour == 2)
        {
            lcColour = "Blue";
        }
        else if(chosenColour == 3)
        {
            lcColour = "Black";
        }
        else if(chosenColour == 4)
        {
            lcColour = "White";
        }
        else if(chosenColour == 5)
        {
            lcColour = "Orange";
        }
        else if(chosenColour == 6)
        {
            lcColour = "Pink";
        }
        else if(chosenColour == 7)
        {
            lcColour = "Yellow";
        }
        else if(chosenColour == 8)
        {
            lcColour = "Magenta";
        }

        //Game Set-Up Confirmation
        JOptionPane.showMessageDialog(null, "Hello " + player + "!\nYou will have a(n) " +
                        lcColour + " light cycle.\nYour grid size is: " + chosenGridWidth + " by " + chosenGridHeight,
                "Game Setup", JOptionPane.PLAIN_MESSAGE);

        //Initial Game Set Up
        tronbg bike = new tronbg();
        JFrame game = new JFrame();
        game.add(bike);
        game.setResizable(false);
        game.setVisible(true);
        game.setSize(chosenGridWidth,chosenGridHeight);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setTitle("TRON");
    }

    //Used to call the colour chosen for the bike to tronbg.java
    public int tronbgCycleColour()
    {
        int cycleColour = chosenColour;
        return cycleColour;
    }

    private static String createPlayer()
    {
        // Asks for player name
        String nameInput = JOptionPane.showInputDialog(null, "Please enter your name: ",
                "Enter your name :)", JOptionPane.PLAIN_MESSAGE);
        return nameInput;
    }

    public static int createGrid(String widthOrHeight)
    {
        int gridSize;

        //user input for grid width and height
        String gridInput = JOptionPane.showInputDialog(null, "Please enter desired "
                + widthOrHeight + ". (Between 500 and 10,000)", widthOrHeight, JOptionPane.PLAIN_MESSAGE);
        gridSize = Integer.parseInt(gridInput);

        // Grid error check
        if(gridSize < 500 || gridSize > 10000)
        {
            while(gridSize < 500)
            {
                gridInput = JOptionPane.showInputDialog(null, "Sorry that was too low. " +
                                "Please reinput " + widthOrHeight + ". (Between 500 and 10,000)",
                        "TOO LOW!", JOptionPane.PLAIN_MESSAGE);
                gridSize = Integer.parseInt(gridInput);
            }

            while(gridSize > 10000)
            {
                gridInput = JOptionPane.showInputDialog(null, "Sorry that was too high. " +
                                "Please reinput " + widthOrHeight + ". (Between 500 and 10,000)",
                        "TOO HIGH!", JOptionPane.PLAIN_MESSAGE);
                gridSize = Integer.parseInt(gridInput);
            }
        }
        return gridSize;
    }

    public static int colourGen()
    {
        //Rolls die to assign a random colour to player
        Random dice = new Random();
        int number;
        number = dice.nextInt(8);
        return number;
    }
}