import java.util.Random;
import javax.swing.JOptionPane;

public class tronMain {
    public static void main(String[] args)
    {
        /* Base code for the game will go here, things such as: */
        /* Booting the game, calling to other functions and GUI */
        /* Will receive each player name as they are input from player() function */
        String lcColour = lightCycle();
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
        JOptionPane.showMessageDialog(null, "Hello " + player + "!\nYou will have a(n) " + lcColour + " light cycle.\nYour grid size is: " + createGridX + " by " + createGridY, "Game Setup", JOptionPane.PLAIN_MESSAGE);
    }

    private static int createGrid(String widthOrHeight)
    {
        int createGrid;
        String gridInput = JOptionPane.showInputDialog("Enter your " + widthOrHeight + ". (Between 500 and 10,000)");
        createGrid = Integer.parseInt(gridInput);

        /* Grid error check */
        if(createGrid < 500 || createGrid > 10000)
        {
            while(createGrid < 500)
            {
                gridInput = JOptionPane.showInputDialog("Sorry that was too low. Please reinput " + widthOrHeight + ". (Between 500 and 10,000)");
                createGrid = Integer.parseInt(gridInput);
            }

            while(createGrid > 10000)
            {
                gridInput = JOptionPane.showInputDialog("Sorry that was too high. Please reinput " + widthOrHeight + ". (Between 500 and 10,000)");
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
        String nameInput = JOptionPane.showInputDialog("Please enter your name: ");
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
