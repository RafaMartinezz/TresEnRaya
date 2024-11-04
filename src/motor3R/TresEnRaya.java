package motor3R;

/**
 * Classic game of Tic-Tac-Toe where a human player competes against the
 * machine.
 * The human player starts, and the game alternates turns until one of the
 * players
 * wins or the board is completely filled, resulting in a draw.
 */
public class TresEnRaya {
    private Tablero tablero; // Game board
    private final char HUMANO; // Character representing the human player
    private final char MAQUINA; // Character representing the machine player
    private final char LIBRE = '_'; // Character representing an empty space on the board
    private boolean finPartida = false; // Flag to indicate if the game has ended
    private String ganador = "DRAW"; // Stores the winner of the game, or "DRAW" if no winner
    private final char DIFICULTAD; // Game difficulty level ('F' for easy, others in development)

    /**
     * Creates a 3x3 board initialized with empty cells represented by '_'.
     *
     * @param HUMANO     Character representing the human player's pieces.
     * @param MAQUINA    Character representing the machine player's pieces.
     * @param DIFICULTAD Character representing the difficulty level ('F' for easy).
     */
    public TresEnRaya(char HUMANO, char MAQUINA, char DIFICULTAD) {
        this.HUMANO = HUMANO;
        this.MAQUINA = MAQUINA;
        this.DIFICULTAD = DIFICULTAD;
        this.tablero = new Tablero(3, 3);
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                this.tablero.getMatriz()[fila][columna] = LIBRE;
            }
        }
    }

    /**
     * Checks if the game has ended.
     *
     * @return true if the game is over, otherwise false.
     */
    public boolean isFinPartida() {
        return this.finPartida;
    }

    /**
     * Retrieves the difficulty level of the game as a descriptive string.
     *
     * @return A string describing the difficulty level.
     */
    public String getDIFICULTAD() {
        String description;
        if (this.DIFICULTAD == 'F') {
            description = "EASY";
        } else if (this.DIFICULTAD == 'I') {
            description = "INTERMEDIATE";
        } else {
            description = "HARD";
        }
        return description;
    }

    /**
     * Gets the game board as a 2D character array.
     *
     * @return 2D character array representing the board.
     */
    public char[][] getTablero() {
        return this.tablero.getMatriz();
    }

    /**
     * Gets the winner of the game.
     *
     * @return A string indicating the winner ("HUMANO", "MAQUINA", or "DRAW").
     */
    public String getGanador() {
        return this.ganador;
    }

    /**
     * Allows the human player to place a piece on the board.
     * If the human player wins, sets the game to over.
     *
     * @param fila    The row number to place the piece.
     * @param columna The column number to place the piece.
     */
    public void mueveHumano(int fila, int columna) {
        this.tablero.getMatriz()[fila][columna] = this.HUMANO;
        if (hayTresEnRaya(this.HUMANO)) {
            this.finPartida = true;
            this.ganador = "HUMANO";
        }
    }

    /**
     * Allows the machine player to place a piece on the board.
     * Currently only implements the "easy" difficulty, where the machine places
     * a piece in the first available position.
     */
    public void mueveMaquina() {
        if (this.DIFICULTAD == 'F') {
            OUTER: for (int fila = 0; fila < 3; fila++) {
                for (int columna = 0; columna < 3; columna++) {
                    if (this.tablero.getMatriz()[fila][columna] == LIBRE) {
                        this.tablero.getMatriz()[fila][columna] = MAQUINA;
                        break OUTER;
                    }
                }
            }
            if (hayTresEnRaya(MAQUINA)) {
                this.finPartida = true;
                this.ganador = "MAQUINA";
            }
        }
    }

    /**
     * Checks if a given player has three in a row (horizontally, vertically, or
     * diagonally).
     *
     * @param jugador Character representing the player to check (HUMANO or
     *                MAQUINA).
     * @return true if the player has three in a row, otherwise false.
     */
    boolean hayTresEnRaya(char jugador) {
        boolean tresRaya = false;

        // Check rows and columns for three in a row
        for (int i = 0; i < 3; i++) {
            boolean lineaFila = true;
            for (int j = 0; j < 3; j++) {
                if (this.tablero.getMatriz()[i][j] != jugador) {
                    lineaFila = false;
                    break;
                }
            }
            if (lineaFila) {
                tresRaya = true;
            }

            boolean lineaColumna = true;
            for (int j = 0; j < 3; j++) {
                if (this.tablero.getMatriz()[j][i] != jugador) {
                    lineaColumna = false;
                    break;
                }
            }
            if (lineaColumna) {
                tresRaya = true;
            }
        }

        // Check main diagonal
        boolean diagonal = true;
        for (int i = 0; i < 3; i++) {
            if (this.tablero.getMatriz()[i][i] != jugador) {
                diagonal = false;
                break;
            }
        }

        // Check opposite diagonal
        boolean diagonalInv = true;
        for (int i = 0; i < 3; i++) {
            if (this.tablero.getMatriz()[i][2 - i] != jugador) {
                diagonalInv = false;
                break;
            }
        }

        // If any winning condition is met
        if (diagonal || diagonalInv) {
            tresRaya = true;
        }
        return tresRaya;
    }

    /**
     * Checks if the board is completely filled with pieces.
     *
     * @return true if the board is full, otherwise false.
     */
    public boolean tableroLleno() {
        boolean lleno = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.tablero.getMatriz()[i][j] == LIBRE) {
                    lleno = false;
                }
            }
        }
        return lleno;
    }
}

/**
 * Represents a game board used for the Tic-Tac-Toe game. The TresEnRaya class
 * uses an instance of Tablero to track moves.
 */
class Tablero {
    private int filas; // Number of rows
    private int columnas; // Number of columns
    private char[][] matriz; // 2D array representing the game board

    /**
     * Creates a game board with specified rows and columns.
     *
     * @param filas    Number of rows in the board.
     * @param columnas Number of columns in the board.
     */
    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new char[filas][columnas];
    }

    /**
     * Gets the number of rows on the board.
     *
     * @return Number of rows.
     */
    public int getFilas() {
        return filas;
    }

    /**
     * Sets the number of rows on the board.
     *
     * @param filas New number of rows.
     */
    public void setFilas(int filas) {
        this.filas = filas;
    }

    /**
     * Gets the number of columns on the board.
     *
     * @return Number of columns.
     */
    public int getColumnas() {
        return columnas;
    }

    /**
     * Sets the number of columns on the board.
     *
     * @param columnas New number of columns.
     */
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    /**
     * Gets the board matrix.
     *
     * @return 2D character array representing the board.
     */
    public char[][] getMatriz() {
        return matriz;
    }
}
