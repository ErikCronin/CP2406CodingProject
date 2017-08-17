import java.util.Scanner;

public class tronMain {
    public static void main(String[] args)
    {
        /* Base code for the game will go here, things such as: */
        /* Booting the game, calling to other functions and GUI */
        /* Will receive each player name as they are input from player() function */
        /* Sends winning player's name and jet wall length to leaderboard */
        /* Creates grid based on user input */

        /* Grid width creation */
        int createGridX = createGrid();

        /* Grid height creation */
        int createGridY = createGrid();

        System.out.println("Your grid size is: " + createGridX + " by " + createGridY);
    }

    public static int createGrid()
    {
        int createGrid;
        boolean gridBoolean = false;
        System.out.println("Please input your grid width (Between 500 and 10,000)");
        Scanner gridInput = new Scanner(System.in);
        createGrid = gridInput.nextInt();

        /* Grid error check */
        if(createGrid < 500 || createGrid > 10000)
        {
            while(createGrid < 500)
            {
                System.out.println("reinput (Between 500 and 10,000)");
                gridInput = new Scanner(System.in);
                createGrid = gridInput.nextInt();
            }

            while(createGrid > 10000)
            {
                System.out.println("reinput you dang fool (Between 500 and 10,000)");
                gridInput = new Scanner(System.in);
                createGrid = gridInput.nextInt();
            }
        }
        else
        {}

        return createGrid;
    }

    public static void player()
    {
        /* Ask for player name. */
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
        /* cannot stop once cycle has started, can speed up and slow down */
        /* Lightcycle and jet trail are the same colour */
    }

    public static void cycleColour()
    {
        /* runs a random number generator between 1 and 9 to give an assigned colour to a player */
        /* must not be able to give the same colour twice */
    }
}
