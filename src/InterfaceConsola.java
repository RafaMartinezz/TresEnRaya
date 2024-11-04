import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import motor3R.TresEnRaya;

/**
 * Console interface for the Tic-Tac-Toe game, providing methods to present game
 * instructions, print the game board, and handle player and machine turns.
 */
public class InterfaceConsola {

    /**
     * Presents the initial game instructions to the player.
     */
    public static void presentarJuego() {
        System.out.println("Welcome to the magic of Tic-Tac-Toe! Prepare for an unforgettable experience!");
        System.out.println("The game board is 3x3, and the game ends when one of us gets three in a row.");
        System.out.println("I’ll win, of course, because you’re just a rookie!");
        System.out.println("We’ll take turns placing a piece in a square on the board.");
        System.out.println("You’ll need to specify the row and column of the square you want to choose.");
        System.out.println("Let’s get started!");
    }

    /**
     * Prints the current state of the game board to the console.
     *
     * @param tablero The 3x3 game board as a 2D character array.
     */
    public static void imprimirTablero(char tablero[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    /**
     * Displays a message indicating it's the player’s turn and prompts for row and
     * column input.
     */
    public static void turnoJugador() {
        System.out.println("It's your turn, Player!");
        System.out.println("Please enter the row and column.");
    }

    /**
     * Displays a message indicating it's the machine’s turn.
     */
    public static void turnoMaquina() {
        System.out.println("It's my turn!");
    }

    /**
     * Announces the winner of the game.
     *
     * @param ganador The name of the winner ("Player", "Machine", or "DRAW").
     */
    public static void ganador(String ganador) {
        System.out.println("The winner is " + ganador);
    }

    /**
     * Prompts the player to select the difficulty level for the game.
     */
    public static void dificultad() {
        System.out.println("What difficulty level do you choose? EASY: 'F', INTERMEDIATE: 'I', or HARD: 'D'?");
    }

    /**
     * Main method that runs the Tic-Tac-Toe game in the console.
     * Handles alternating turns between the player and the machine, as well as
     * checking for game end conditions.
     *
     * @param args Command-line arguments (not used).
     * @throws Exception InterruptedException if thread sleep is interrupted.
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Present game instructions and ask for difficulty level
        presentarJuego();
        dificultad();
        char dif = sc.nextLine().charAt(0);

        // Initialize the Tic-Tac-Toe game with specified characters and difficulty
        TresEnRaya ter = new TresEnRaya('X', 'O', dif);
        System.out.println("You have chosen difficulty: " + ter.getDIFICULTAD());

        // Display the initial empty board
        imprimirTablero(ter.getTablero());

        // Main game loop: alternate turns until the board is full or someone wins
        while (!ter.tableroLleno()) {
            // Player's turn
            turnoJugador();
            ter.mueveHumano(sc.nextInt(), sc.nextInt());
            imprimirTablero(ter.getTablero());

            // Check if the player has won
            if (ter.isFinPartida()) {
                ganador(ter.getGanador());
                break;
            }

            // Machine's turn
            turnoMaquina();
            TimeUnit.SECONDS.sleep(1); // Small delay to simulate thinking
            ter.mueveMaquina();
            imprimirTablero(ter.getTablero());

            // Check if the machine has won
            if (ter.isFinPartida()) {
                ganador(ter.getGanador());
                break;
            }

            // Brief delay between rounds
            TimeUnit.SECONDS.sleep(1);
        }

        // Close the scanner to prevent resource leak
        sc.close();
    }
}
