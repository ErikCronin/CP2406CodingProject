import java.util.Scanner;
import java.util.Random;

public class tronMain {
    public static void main(String[] args)
    {
        /* Base code for the game will go here, things such as: */

        /* Booting the game, calling to other functions and GUI */

        /* Will receive each player name as they are input from player() function */
        lightCycle();
        boolean playerBoolean = false;
        String player = createPlayer();
        System.out.println("Hello " + player + "!");

        /* Sends winning player's name and jet wall length to leaderboard */

        /* Creates grid based on user input */
        /* Grid width creation */
        String gridWidth = "width";
        int createGridX = createGrid(gridWidth);

        /* Grid height creation */
        String gridHeight = "height";
        int createGridY = createGrid(gridHeight);

        System.out.println("Your grid size is: " + createGridX + " by " + createGridY);
    }

    public static int createGrid(String widthOrHeight)
    {
        int createGrid;
        System.out.println("Please input your grid " + widthOrHeight + " (Between 500 and 10,000)");
        Scanner gridInput = new Scanner(System.in);
        createGrid = gridInput.nextInt();

        /* Grid error check */
        if(createGrid < 500 || createGrid > 10000)
        {
            while(createGrid < 500)
            {
                System.out.println("Sorry, that was too low. Please reinput " + widthOrHeight + " (Between 500 and 10,000)");
                gridInput = new Scanner(System.in);
                createGrid = gridInput.nextInt();
            }

            while(createGrid > 10000)
            {
                System.out.println("Sorry, that was too high. Please reinput " + widthOrHeight + " (Between 500 and 10,000)");
                gridInput = new Scanner(System.in);
                createGrid = gridInput.nextInt();
            }
        }
        else
        {
            System.out.println("Thank you!");
        }

        return createGrid;
    }

    public static String createPlayer()
    {
        /* Ask for player name. */
        System.out.println("Please input you're name: ");
        Scanner nameInput = new Scanner(System.in);
        return nameInput.nextLine();

        /* If first player input, how many players? (must be at least 2) */
    }


    public static void leaderboard(String player, int jetLength)
    {
        /* receives winning players name and jet wall length, and puts it on a leaderboard. */
        /* Will store winning player's name and jet wall length from current and previous games */
    }

    public static void lightCycle()
    {
        /* Must always be facing inwards away from grid */
        /* Given random colour from a selection of 9 (red, green, blue, black, white, orange, pink, yellow, purple) */
        Random dice = new Random();
        int number;
        number = dice.nextInt(8);
        System.out.println(number + " ");
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

        System.out.println("Your light cycle colour is: " + colour);
        /* cannot stop once cycle has started, can speed up and slow down */
        /* Lightcycle and jet trail are the same colour */
    }
}
