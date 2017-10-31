import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class tronMain {
    public static void main(String[] args)
    {
        /* Initial set up done before running the game */
        /* Will receive each player name as they are input from player() function */
        String player = createPlayer();

        /* Gives each player a random colour */
        String lcColour = lightCycle();

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

        /* Game Start Up */
        tronWindow game = new tronWindow();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(createGridX,createGridY);
        game.setVisible(true);
    }

    private static int createGrid(String widthOrHeight)
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
        else
        {
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


    /* private static void leaderBoard(String player, int jetLength)
    {
        receives winning players name and jet wall length, and puts it on a leader board.
        Will store winning player's name and jet wall length from current and previous games
    }
    */

    private static String lightCycle()
    {
        /* Must always be facing inwards away from grid */
        /* Given random colour from a selection of 9 (red, green, blue, black, white, orange, pink, yellow, purple) */
        Random dice = new Random();
        int number;
        number = dice.nextInt(8);
        String colour = "";
        if(number == 0)
        {
            colour = "red";
        }

        else if(number == 1)
        {
            colour = "green";
        }

        else if(number == 2)
        {
            colour = "blue";
        }

        else if(number == 3)
        {
            colour = "black";
        }

        else if(number == 4)
        {
            colour = "white";
        }

        else if(number == 5)
        {
            colour = "orange";
        }

        else if(number == 6)
        {
            colour = "pink";
        }

        else if(number == 7)
        {
            colour = "yellow";
        }

        else if(number == 8)
        {
            colour = "purple";
        }

        return colour;
        /* cannot stop once cycle has started, can speed up and slow down */
        /* Light cycle and jet trail are the same colour */
    }
}
