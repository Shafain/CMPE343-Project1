import java.util.Scanner;

public class University {
    
    static final char PLAYER = 'X';
    static final char AI = 'O';
    static final int MAX_DEPTH = 3;

    static void playGame(Scanner user, int cols, int rows, boolean vsComputer) {
        char[][] board = new char[rows][cols];
        initializeBoard(board);
        boolean playerOneTurn = true;
        boolean gameOver = false;

        while (!gameOver) {
            printBoard(board);
            if (playerOneTurn || !vsComputer) {
                String currentPlayer = playerOneTurn ? "Player 1" : "Player 2";
                System.out.println(currentPlayer + ", choose a column (1-" + cols + "): ");

                int chosenColumn;

                try {
                    chosenColumn = Integer.parseInt(user.nextLine()) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    continue;
                }

                char currentDisc = playerOneTurn ? PLAYER : 'O';
                boolean validMove = (chosenColumn >= 0 && chosenColumn < cols) 
                                    && placeDisc(board, chosenColumn, currentDisc);

                if (!validMove) {
                    System.out.println("Column full or invalid! Try again.");
                    continue;
                }

            } else {
                int aiChosenColumn = getBestMove(board, MAX_DEPTH);
                placeDisc(board, aiChosenColumn, AI);
                System.out.println("Computer chose column " + (aiChosenColumn + 1));
            }

            if (checkWin(board, playerOneTurn ? PLAYER : (vsComputer ? AI : 'O'))) {
                printBoard(board);
                System.out.println((playerOneTurn ? "Player 1" : (vsComputer ? "Computer" : "Player 2")) + " wins!");
                gameOver = true;
            } else if (isFull(board)) {
                printBoard(board);
                System.out.println("It's a draw!");
                gameOver = true;
            }

            playerOneTurn = !playerOneTurn;
        }
    }

    static void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                board[i][j] = '.';
    }

    static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) System.out.print(c + " ");
            System.out.println();
        }
        for (int i = 1; i <= board[0].length; i++) System.out.print(i + " ");
        System.out.println("\n");
    }

    static boolean placeDisc(char[][] board, int col, char disc) {
        for (int i = board.length - 1; i >= 0; i--) {
            if (board[i][col] == '.') { board[i][col] = disc; return true; }
        }
        return false;
    }

    static boolean checkWin(char[][] board, char disc) {
        int rows = board.length, cols = board[0].length;
        // Horizontal
        for (int r = 0; r < rows; r++)
            for (int c = 0; c <= cols - 4; c++)
                if (board[r][c] == disc && board[r][c+1] == disc && board[r][c+2] == disc && board[r][c+3] == disc) return true;
        // Vertical
        for (int r = 0; r <= rows - 4; r++)
            for (int c = 0; c < cols; c++)
                if (board[r][c] == disc && board[r+1][c] == disc && board[r+2][c] == disc && board[r+3][c] == disc) return true;
        // Diagonal \
        for (int r = 0; r <= rows - 4; r++)
            for (int c = 0; c <= cols - 4; c++)
                if (board[r][c] == disc && board[r+1][c+1] == disc && board[r+2][c+2] == disc && board[r+3][c+3] == disc) return true;
        // Diagonal /
        for (int r = 3; r < rows; r++)
            for (int c = 0; c <= cols - 4; c++)
                if (board[r][c] == disc && board[r-1][c+1] == disc && board[r-2][c+2] == disc && board[r-3][c+3] == disc) return true;
        return false;
    }

    static boolean isFull(char[][] board) {
        for (int c = 0; c < board[0].length; c++) if (board[0][c] == '.') return false;
        return true;
    }

    static int getBestMove(char[][] board, int depth) {
        int bestScore = Integer.MIN_VALUE;
        int bestCol = 0;
        for (int c = 0; c < board[0].length; c++) {
            if (board[0][c] == '.') {
                char[][] temp = copyBoard(board);
                placeDisc(temp, c, AI);
                int score = minimax(temp, depth - 1, false);
                if (score > bestScore) { bestScore = score; bestCol = c; }
            }
        }
        return bestCol;
    }

    static int minimax(char[][] board, int depth, boolean maximizingPlayer) {
        if (checkWin(board, AI)) return 1000;
        if (checkWin(board, PLAYER)) return -1000;
        if (isFull(board) || depth == 0) return 0; // Simple heuristic: 0

        if (maximizingPlayer) {
            int maxEval = Integer.MIN_VALUE;
            for (int c = 0; c < board[0].length; c++) {
                if (board[0][c] == '.') {
                    char[][] temp = copyBoard(board);
                    placeDisc(temp, c, AI);
                    maxEval = Math.max(maxEval, minimax(temp, depth-1, false));
                }
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (int c = 0; c < board[0].length; c++) {
                if (board[0][c] == '.') {
                    char[][] temp = copyBoard(board);
                    placeDisc(temp, c, PLAYER);
                    minEval = Math.min(minEval, minimax(temp, depth-1, true));
                }
            }
            return minEval;
        }
    }

    static char[][] copyBoard(char[][] board) {
        char[][] newBoard = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) newBoard[i] = board[i].clone();
        return newBoard;
    }

    static void game_mode(Scanner user, int cols, int rows){
        boolean breaker = true;

        while (breaker) { 
            System.out.println("Excellent! Now choose the Game Mode: ");
            System.out.println("[A]Single Player vs Computer");
            System.out.println("[B]Two-players");
            System.out.println("[C]Return to Main Menu");
            String game_mode = user.nextLine();
            if (game_mode.length() != 1) {
                System.out.println("Invalid input! Please enter only a single character: A, B, C, D, or E.");
            }
            char game_ch = game_mode.charAt(0);
            switch (game_ch) {
                case 'A':
                    playGame(user, cols, rows, true);
                    break;
                case 'B':
                    playGame(user, cols, rows, false);
                    break;
                case 'C':
                    breaker = false;
                    break;
                default:
                    System.err.println("Invalid input! Please choose again.");
            }
        }
    }

    static void optianD(Scanner user){
        boolean breaker = true;

        while(breaker){
            System.out.println("This is game Connect 4, please choose the size of the board: ");
            System.out.println("[A]5 X 4");
            System.out.println("[B]6 X 5");
            System.out.println("[C]7 X 6");
            System.out.println("[D]Return to Main Menu");
            String input = user.nextLine();
            if (input.length() != 1) {
                System.out.println("Invalid input! Please enter only a single character: A, B, C, D, or E.");
                continue;
            }
            char charinput = input.charAt(0);
            switch (charinput) {
                case 'A':
                    game_mode(user, 5, 4);
                    break;
                case 'B':
                    game_mode(user, 6 ,5);
                    break;
                case 'C':
                    game_mode(user, 7, 6);
                    break;
                case 'D':
                    breaker = false;
                    break;
                default:
                    System.err.println("Invalid input! Please choose again.");
            }
        }
    }


        static boolean selectionmenu(Scanner user){
        System.out.println("[A]Primary School");
        System.out.println("[B]Secondary School");
        System.out.println("[C]High School");
        System.out.println("[D]University");
        System.out.println("[E]Terminate");

        String input = user.nextLine();

        if (input.length() != 1) {
            System.out.println("Invalid input! Please enter only a single character: A, B, C, D, or E.");
            return true;
        }

        char charinput = input.charAt(0);

        switch (charinput) {
            case 'A':

                break;
            case 'B':
                
                break;
            case 'C':

                break;
            case 'D':
                optianD(user);
                break;
            case 'E':
                System.out.println("Terminating the program...");
                return false;
            default:
                System.out.println("Invalid input! Please choose again.");
            }
        return true;
    }

    public static void main(String[] args) {
        try (Scanner user = new Scanner(System.in)) {
            boolean breaker = true;
            System.out.println("Hello choose one of these: ");
            while(breaker){
                breaker = selectionmenu(user);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
