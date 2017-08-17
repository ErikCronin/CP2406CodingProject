public class tronMain {
    public static void main(String args[])
    {
        /* Base code for the game will go here, things such as: */
        /* Booting the game, calling to other functions and GUI */
        /* Will receive each player name as they are input from player() function */
        /* Sends winning player's name and jet wall length to leaderboard */
    }

    public static void player()
    {
        /* Ask for player name. */
        /* If first player input, how many players? (must be at least 2) */
        /* Ask for grid size (call to grid function) */
    }

    public static void grid()
    {
        /* receives input from player function to create grid */
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
