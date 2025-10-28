
//Check if java time library is the best way to use
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Project1 {
    static double[] sort(int size, double[] array) {
        for (int i = 0; i < size - 1; i++) {
            int minVal = i;
            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[minVal]) {
                    minVal = j;
                }
            }
            double temp = array[i];
            array[i] = array[minVal];
            array[minVal] = temp;
        }
        return array;
    }

    static double median(int size, double[] stat_arr) {
        if (size % 2 == 0) {
            return (stat_arr[size / 2 - 1] + stat_arr[size / 2]) / 2.0;
        } else {
            return stat_arr[size / 2];
        }
    }

    static double arith_mean(int size, double[] stat_arr) {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += stat_arr[i];
        }
        return sum / size;
    }

    static double geo_mean(int size, double[] stat_arr) {
        double product = 1.0;
        for (int i = 0; i < size; i++) {
            product *= stat_arr[i];
        }
        return Math.pow(product, 1.0 / size);
    }

    static double formula(double[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }
        return (1.0 / arr[index]) + formula(arr, index + 1);
    }

    static double harmonic_mean(int size, double[] stat_arr) {
        double sum = formula(stat_arr, 0);
        return size / sum;
    }

    static void stat_info_arr(Scanner user) {
        System.out.println("Enter the array size: ");
        int size = user.nextInt();
        double[] stat_arr = new double[size];
        int count = 1;
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the " + count + " number");
            stat_arr[i] = user.nextDouble();
            count++;
        }

        user.nextLine();

        sort(size, stat_arr);

        System.out.println("Median: " + median(size, stat_arr));
        System.out.println("Arithmetic mean: " + arith_mean(size, stat_arr));
        System.out.println("Geometric mean: " + geo_mean(size, stat_arr));
        System.out.println("Harmonic mean: " + harmonic_mean(size, stat_arr));
    }

    static double euclid_dist(int[] array1, int[] array2) {
        double sum = 0;
        for (int i = 0; i < array1.length; i++) {
            sum += Math.pow(array1[i] - array2[i], 2);
        }
        return Math.sqrt(sum);
    }

    static int manhattan_dist(int[] array1, int[] array2) {
        int sum = 0;
        for (int i = 0; i < array1.length; i++) {
            sum += Math.abs(array1[i] - array2[i]);
        }
        return sum;
    }

    static double cos_similar(int[] array1, int[] array2) {
        double dotProduct = 0;
        double normA = 0;
        double normB = 0;

        for (int i = 0; i < array1.length; i++) {
            dotProduct += array1[i] * array2[i];
            normA += Math.pow(array1[i], 2);
            normB += Math.pow(array2[i], 2);
        }

        if (normA == 0 || normB == 0) {
            return 0.0;
        }

        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }

    static void dist_btwn_arr(Scanner user) {
        System.out.println("Enter the dimension: ");
        int dimension = user.nextInt();
        int[] array1 = new int[dimension];
        int[] array2 = new int[dimension];
        for (int i = 0; i < dimension; i++) {
            System.out.println("Enter the " + (i + 1) + "st" + " element of the array 1: ");
            int number = user.nextInt();
            array1[i] = number;
        }
        for (int i = 0; i < dimension; i++) {
            System.out.println("Enter the " + (i + 1) + "st" + " element of the array 2: ");
            int number = user.nextInt();
            array2[i] = number;
        }

        user.nextLine();

        System.out.println("Manhattan distance: " + manhattan_dist(array1, array2));
        System.out.println("Euclidean distance: " + euclid_dist(array1, array2));
        System.out.println("Cosine similarity: " + cos_similar(array1, array2));

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    static void optionC(Scanner user) {
        boolean breaker = true;

        while (breaker) {
            System.out.println("\n[A] Statistical information about an Array");
            System.out.println("[B] Distance between Two Arrays");
            System.out.println("[C] Return to Main Menu");
            String input = user.nextLine();
            if (input.length() != 1) {
                System.out.println("Invalid input! Please enter only a single character: A, B, or C.");
                continue;
            }
            char charinput = input.charAt(0);
            switch (charinput) {
                case 'A':
                    stat_info_arr(user);
                    break;
                case 'B':
                    dist_btwn_arr(user);
                    break;
                case 'C':
                    breaker = false;
                    break;
                default:
                    System.err.println("Invalid input! Please choose again.");
            }
        }
    }

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
            for (char c : row)
                System.out.print(c + " ");
            System.out.println();
        }
        for (int i = 1; i <= board[0].length; i++)
            System.out.print(i + " ");
        System.out.println("\n");
    }

    static boolean placeDisc(char[][] board, int col, char disc) {
        for (int i = board.length - 1; i >= 0; i--) {
            if (board[i][col] == '.') {
                board[i][col] = disc;
                return true;
            }
        }
        return false;
    }

    static boolean checkWin(char[][] board, char disc) {
        int rows = board.length, cols = board[0].length;
        // Horizontal
        for (int r = 0; r < rows; r++)
            for (int c = 0; c <= cols - 4; c++)
                if (board[r][c] == disc && board[r][c + 1] == disc && board[r][c + 2] == disc
                        && board[r][c + 3] == disc)
                    return true;
        // Vertical
        for (int r = 0; r <= rows - 4; r++)
            for (int c = 0; c < cols; c++)
                if (board[r][c] == disc && board[r + 1][c] == disc && board[r + 2][c] == disc
                        && board[r + 3][c] == disc)
                    return true;
        // Diagonal \
        for (int r = 0; r <= rows - 4; r++)
            for (int c = 0; c <= cols - 4; c++)
                if (board[r][c] == disc && board[r + 1][c + 1] == disc && board[r + 2][c + 2] == disc
                        && board[r + 3][c + 3] == disc)
                    return true;
        // Diagonal /
        for (int r = 3; r < rows; r++)
            for (int c = 0; c <= cols - 4; c++)
                if (board[r][c] == disc && board[r - 1][c + 1] == disc && board[r - 2][c + 2] == disc
                        && board[r - 3][c + 3] == disc)
                    return true;
        return false;
    }

    static boolean isFull(char[][] board) {
        for (int c = 0; c < board[0].length; c++)
            if (board[0][c] == '.')
                return false;
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
                if (score > bestScore) {
                    bestScore = score;
                    bestCol = c;
                }
            }
        }
        return bestCol;
    }

    static int minimax(char[][] board, int depth, boolean maximizingPlayer) {
        if (checkWin(board, AI))
            return 1000;
        if (checkWin(board, PLAYER))
            return -1000;
        if (isFull(board) || depth == 0)
            return 0; // Simple heuristic: 0

        if (maximizingPlayer) {
            int maxEval = Integer.MIN_VALUE;
            for (int c = 0; c < board[0].length; c++) {
                if (board[0][c] == '.') {
                    char[][] temp = copyBoard(board);
                    placeDisc(temp, c, AI);
                    maxEval = Math.max(maxEval, minimax(temp, depth - 1, false));
                }
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (int c = 0; c < board[0].length; c++) {
                if (board[0][c] == '.') {
                    char[][] temp = copyBoard(board);
                    placeDisc(temp, c, PLAYER);
                    minEval = Math.min(minEval, minimax(temp, depth - 1, true));
                }
            }
            return minEval;
        }
    }

    static char[][] copyBoard(char[][] board) {
        char[][] newBoard = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            newBoard[i] = board[i].clone();
        return newBoard;
    }

    static void game_mode(Scanner user, int cols, int rows) {
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

    static void optianD(Scanner user) {
        boolean breaker = true;

        while (breaker) {
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
                    game_mode(user, 6, 5);
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

    static void zodiac_sign(int day, int month) {
        switch (month) {
            case 1:
                if (day >= 20) {
                    System.out.println("Your sign is Aquarius");
                } else {
                    System.out.println("Your sign is Capricon");
                }
                break;
            case 2:
                if (day <= 18) {
                    System.out.println("Your sign is Aquarius");
                } else {
                    System.out.println("Your sign is Pisces");
                }
                break;
            case 3:
                if (day <= 20) {
                    System.out.println("Your sign is Pisces");
                } else {
                    System.out.println("Your sign is Aries");
                }
                break;
            case 4:
                if (day <= 19) {
                    System.out.println("Your sign is Aries");
                } else {
                    System.out.println("Your sign is Taurus");
                }
                break;
            case 5:
                if (day <= 20) {
                    System.out.println("Your sign is Taurus");
                } else {
                    System.out.println("Your sign is Gemini");
                }
                break;
            case 6:
                if (day <= 21) {
                    System.out.println("Your sign is Gemini");
                } else {
                    System.out.println("Your sign is Cancer");
                }
                break;
            case 7:
                if (day <= 22) {
                    System.out.println("Your sign is Cancer");
                } else {
                    System.out.println("Your sign is Leo");
                }
                break;
            case 8:
                if (day <= 22) {
                    System.out.println("Your sign is Leo");
                } else {
                    System.out.println("Your sign is Virgo");
                }
                break;
            case 9:
                if (day <= 22) {
                    System.out.println("Your sign is Virgo");
                } else {
                    System.out.println("Your sign is Libra");
                }
                break;
            case 10:
                if (day <= 22) {
                    System.out.println("Your sign is Libra");
                } else {
                    System.out.println("Your sign is Scorpio");
                }
                break;
            case 11:
                if (day <= 21) {
                    System.out.println("Your sign is Scorpio");
                } else {
                    System.out.println("Your sign is Sagittarius");
                }
                break;
            case 12:
                if (day <= 21) {
                    System.out.println("Your sign is Sagittarius");
                } else {
                    System.out.println("Your sign is Capricorn");
                }
                break;
            default:
                System.out.println("Something went wrong");
        }
    }

    static void age_and_zodiac(Scanner user) {
        System.out.println("Please enter your birthday: yyyy-MM-dd");
        String user_birth = user.nextLine();
        try {
            LocalDate time = LocalDate.now();
            LocalDate birthDay = LocalDate.parse(user_birth, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            int user_year = birthDay.getYear();
            int user_month = birthDay.getMonthValue();
            int user_day = birthDay.getDayOfMonth();

            int year = time.getYear();
            int month = time.getMonthValue();
            int day = time.getDayOfMonth();

            if (birthDay.isAfter(time)) {
                System.out.println("You can't be born in the future!");
                return;
            }

            int age = year - user_year;

            if (month < user_month || (month == user_month && day < user_day)) {
                age--;
            }

            zodiac_sign(user_day, user_month);
            System.out.println("Your age is" + age);

        } catch (Exception e) {
            System.err.println("Invalid format! Please type in: (yyyy-month-day)");
        }
    }

    static String reverse_the_word(String word) {
        char[] chars = word.toCharArray();
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            // Skip non-letters on the left
            if (!Character.isLetter(chars[left])) {
                left++;
            }
            // Skip non-letters on the right
            else if (!Character.isLetter(chars[right])) {
                right--;
            }
            // Swap only letters
            else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    static void reverse_the_text(Scanner user) {
        String text = user.nextLine();
        String[] words = text.split(" ");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            result.append(reverse_the_word(words[i]));
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        System.out.println(result.toString());
    }

    static void optionA(Scanner user) {
        boolean breaker = true;
        while (breaker) {
            System.out.println("[A]Age and Zodiac Sign Detector");
            System.out.println("[B]Reverse the Words");
            System.out.println("[C]Return to Main Menu");
            // change string to char
            String input = user.nextLine();
            if (input.length() != 1) {
                System.out.println("Invalid input! Please enter only a single character: A, B, C.");
                continue;
            }
            char charinput = input.charAt(0);
            switch (charinput) {
                case 'A':
                    System.out.println("Input your year-month-day in the order: ");
                    age_and_zodiac(user);
                    break;
                case 'B':
                    reverse_the_text(user);
                    break;
                case 'C':
                    breaker = false;
                    break;
                default:
                    System.err.println("Invalid input! Please enter a single character: A, B, C.");
            }
        }

    }

    static int prime_number_input(Scanner user) {
        System.out.println("Enter an integer n ≥ 12:");
        int n;
        while (true) {
            try {
                n = user.nextInt();
            } catch (Exception e) {
                System.err.println("Invalid input! Please enter an integer.");
                user.nextLine();
                continue;
            }

            if (n < 12) {
                System.err.println("Invalid input! Please enter a number ≥ 12.");
                continue;
            }
            return n;

        }

    }

    static List<Integer> eratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i] == true) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        if (n >= 2)
            primes.add(2);
        if (n >= 3)
            primes.add(3);

        for (int i = 4; i <= n; i++) {
            if (isPrime[i] == true) {
                primes.add(i);
            }
        }
        return primes;

    }

    static List<Integer> sundaram(int n) {
        boolean[] not_Prime = new boolean[n + 1];
        // find the correct index
        for (int i = 1; i <= (n - 2) / 2; i++) {
            for (int j = i; i + j + 2 * i * j <= (n - 2) / 2; j++) {
                not_Prime[i + j + 2 * i * j] = true;
            }
        }
        List<Integer> primes = new ArrayList<>();
        if (n >= 2)
            primes.add(2);
        for (int i = 1; i <= (n - 2) / 2; i++) {
            if (not_Prime[i] == false)
                // add prime numbers except the correct index
                primes.add(2 * i + 1);
        }
        return primes;

    }

    static List<Integer> atkin(int n) {
        boolean[] isPrime = new boolean[n + 1];
        int limit = (int) Math.sqrt(n);

        for (int x = 1; x <= limit; x++) {
            for (int y = 1; y <= limit; y++) {
                int number = 4 * x * x + y * y;
                if (number <= n && (number % 12 == 1 || number % 12 == 5)) {
                    isPrime[number] = !isPrime[number];
                }

                number = 3 * x * x + y * y;
                if (number <= n && number % 12 == 7) {
                    isPrime[number] = !isPrime[number];
                }

                number = 3 * x * x - y * y;
                if (x > y && number <= n && number % 12 == 11) {
                    isPrime[number] = !isPrime[number];
                }
            }
        }
        for (int i = 5; i <= limit; i++) {
            if (isPrime[i]) {
                int square = i * i;
                for (int j = square; j <= n; j += square) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        if (n >= 2) {
            primes.add(2);
        }
        if (n >= 3) {
            primes.add(3);
        }

        for (int i = 5; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    /*
     * Here is the Output of prime numbers
     * =========================================
     */
    static void prime_number_output(Scanner user) {
        int n = prime_number_input(user);
        // eratosthenes
        long startE = System.nanoTime();
        List<Integer> eratosthenes_algorithm = eratosthenes(n);
        long endE = System.nanoTime();
        double eratosthenes_time = (endE - startE) / 1_000_000.0;
        // sundaram
        long startS = System.nanoTime();
        List<Integer> sundaram_algorithm = sundaram(n);
        long endS = System.nanoTime();
        double sundaram_time = (endS - startS) / 1_000_000.0;

        // atkin
        long startA = System.nanoTime();
        List<Integer> atkin_algorithm = atkin(n);
        long endA = System.nanoTime();
        double atkin_time = (endA - startA) / 1_000_000.0;
        System.out.println("========Prime Number Genreation ========");
        System.out.println("Generating Prime Numbers up to " + n);
        System.out.println("Eratosthenes algorithm: \nfirst 3: " + eratosthenes_algorithm.subList(0, 3) + "\nLast 2: "
                + eratosthenes_algorithm.subList(eratosthenes_algorithm.size() - 2, eratosthenes_algorithm.size()));
        System.out.println("Execution time: " + eratosthenes_time);
        System.out.println("Sundaram algorithm: \nfirst 3: " + sundaram_algorithm.subList(0, 3) + "\nLast 2: "
                + sundaram_algorithm.subList(sundaram_algorithm.size() - 2, sundaram_algorithm.size()));
        System.out.println("Execution time: " + sundaram_time);
        System.out.println("Atkin algorithm: " + "\nfirst 3: " + atkin_algorithm.subList(0, 3) + "\nLast 2: "
                + atkin_algorithm.subList(atkin_algorithm.size() - 2, atkin_algorithm.size()));
        System.out.println("Execution time: " + atkin_time);
        user.nextLine();
    }

    static void evaluate_expression(Scanner user) {
        System.out.println("Enter a valid expression (use + - x : and parentheses):");
        String expr = user.nextLine().replaceAll("\\s+", "");

        // simple validation
        if (!expr.matches("[0-9x:+\\-()]+")) {
            System.err.println("Invalid characters! Try again.");
            return;
        }

        if (!isParenthesesBalanced(expr)) {
            System.err.println("Unbalanced parentheses! Try again.");
            return;
        }

        expr = expr.replace("x", "*").replace(":", "/");

        System.out.println("Step-by-step evaluation:");
        System.out.println(simplify(expr));
    }

    static boolean isParenthesesBalanced(String expr) {
        int count = 0;
        for (char c : expr.toCharArray()) {
            if (c == '(')
                count++;
            else if (c == ')')
                count--;
            if (count < 0)
                return false;
        }
        return count == 0;
    }

    static double evalSimple(String expr) {
        // evaluate a no-parentheses, basic expression left to right with */ before +-
        List<Double> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        StringBuilder num = new StringBuilder();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                num.append(c);
            } else {
                nums.add(Double.parseDouble(num.toString()));
                num.setLength(0);
                ops.add(c);
            }
        }
        nums.add(Double.parseDouble(num.toString()));

        // handle * and /
        for (int i = 0; i < ops.size();) {
            char op = ops.get(i);
            if (op == '*' || op == '/') {
                double a = nums.get(i), b = nums.get(i + 1);
                double res = (op == '*') ? a * b : a / b;
                nums.set(i, res);
                nums.remove(i + 1);
                ops.remove(i);
            } else
                i++;
        }

        // handle + and -
        double result = nums.get(0);
        for (int i = 0; i < ops.size(); i++) {
            char op = ops.get(i);
            double b = nums.get(i + 1);
            if (op == '+')
                result += b;
            else
                result -= b;
        }
        return result;
    }

    static String simplify(String expr) {
        // handle parentheses recursively
        int open = expr.lastIndexOf('(');
        if (open != -1) {
            int close = expr.indexOf(')', open);
            String inside = expr.substring(open + 1, close);
            double val = evalSimple(inside);
            String newExpr = expr.substring(0, open) + val + expr.substring(close + 1);
            System.out.println("= " + newExpr);
            return simplify(newExpr);
        }

        double finalVal = evalSimple(expr);
        System.out.println("= " + finalVal);
        return String.valueOf(finalVal);
    }

    static void optionB(Scanner user) {
        boolean breaker = true;
        while (breaker) {
            System.out.println("[A]Prime Numbers");
            System.out.println("[B]Step-by-step Eveluation of Expression");
            System.out.println("[C]Return to Main Menu");
            // change string to char
            String input = user.nextLine();
            if (input.length() != 1) {
                System.out.println("Invalid input! Please enter only a single character: A, B, C.");
                continue;
            }
            char charinput = input.charAt(0);
            switch (charinput) {
                case 'A':
                    prime_number_output(user);
                    break;
                case 'B':
                    evaluate_expression(user);
                    break;
                case 'C':
                    breaker = false;
                    break;
                default:
                    System.err.println("Invalid input! Please enter a signle character: A, B, C");
            }

        }
    }

    static boolean selectionmenu(Scanner user) {
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
                optionA(user);
                break;
            case 'B':
                optionB(user);
                break;
            case 'C':
                optionC(user);
                break;
            case 'D':
                optianD(user);
                break;
            case 'E':
                System.err.println("Terminating the program...");
                return false;
            default:
                System.err.println("Invalid input! Please choose again.");
        }
        return true;
    }

    public static void main(String[] args) {
        try (Scanner user = new Scanner(System.in)) {
            boolean breaker = true;
            final String RESET = "\u001B[0m";
            final String RED = "\u001B[31m";
            final String GREEN = "\u001B[32m";
            final String YELLOW = "\u001B[33m";
            final String BLUE = "\u001B[34m";
            final String MAGENTA = "\u001B[35m";
            final String CYAN = "\u001B[36m";
            final String WHITE = "\u001B[37m";

            System.out.println(RED + "   _      _      _      _      _      _      _      _      _      _   " + RESET);
            System.out
                    .println(GREEN + " _( )_  _( )_  _( )_  _( )_  _( )_  _( )_  _( )_  _( )_  _( )_  _( )_ " + RESET);
            System.out
                    .println(YELLOW + "(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)" + RESET);
            System.out.println(BLUE + " (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_) " + RESET);
            System.out.println(
                    MAGENTA + "   _      | | _  |  _  _ __  _                                    _   " + RESET);
            System.out.println(CYAN + " _( )_    |^|(/_ | (_ (_)|||(/_                                 _( )_ " + RESET);
            System.out
                    .println(WHITE + "(_ o _)                                                        (_ o _)" + RESET);
            System.out.println(RED + " (_,_)    _|_ _    _|_|_  _                                     (_,_) " + RESET);
            System.out
                    .println(GREEN + "   _       |_(_)    |_| |(/_                                      _   " + RESET);
            System.out
                    .println(YELLOW + " _( )_     _        o                                           _( )_ " + RESET);
            System.out.println(BLUE + "(_ o _)   |_) __ _  |  _  _ _|_   /|                           (_ o _)" + RESET);
            System.out.println(
                    MAGENTA + " (_,_)    |   | (_)_| (/_(_  |_    |                            (_,_) " + RESET);
            System.out.println(CYAN + "   _       _           _                             o            _   " + RESET);
            System.out
                    .println(WHITE + " _( )_    (_| __ _    |_)   __  _ __ |_  _  __ _                _( )_ " + RESET);
            System.out.println(RED + "(_ o _)   __| | (_)|_||     |||(/_||||_)(/_ | _>     o         (_ o _)" + RESET);
            System.out
                    .println(GREEN + " (_,_)                                                          (_,_) " + RESET);
            System.out
                    .println(YELLOW + "   _      _      _      _      _      _      _      _      _      _   " + RESET);
            System.out.println(BLUE + " _( )_  _( )_  _( )_  _( )_  _( )_  _( )_  _( )_  _( )_  _( )_  _( )_ " + RESET);
            System.out.println(
                    MAGENTA + "(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)" + RESET);
            System.out.println(CYAN + " (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_) " + RESET);

            System.out.println(WHITE
                    + " _____                                                                               _____ ");
            System.out.println(
                    "( ___ )-----------------------------------------------------------------------------( ___ )");
            System.out.println(
                    " |   |                                                                               |   | ");
            System.out.println(
                    " |   |  " + RED + " AA  K  K H  H M   M EEEE DDD      N   N  AA  ZZZZZ  AA  RRRR   OOO  V     V"
                            + WHITE + " |   | ");
            System.out.println(
                    " |   |  " + YELLOW + "A  A K K  H  H MM MM E    D  D     NN  N A  A    Z  A  A R   R O   O V     V"
                            + WHITE + " |   | ");
            System.out.println(
                    " |   |  " + GREEN + "AAAA KK   HHHH M M M EEE  D  D     N N N AAAA   Z   AAAA RRRR  O   O  V   V"
                            + WHITE + "  |   | ");
            System.out.println(
                    " |   |  " + CYAN + "A  A K K  H  H M   M E    D  D     N  NN A  A  Z    A  A R R   O   O   V V"
                            + WHITE + "   |   | ");
            System.out.println(
                    " |   |  " + BLUE + "A  A K  K H  H M   M EEEE DDD      N   N A  A ZZZZZ A  A R  RR  OOO     V"
                            + WHITE + "    |   | ");
            System.out.println(
                    " |   |                                                                               |   | ");
            System.out.println(
                    " |   |                                                                               |   | ");
            System.out.println(" |   |  " + MAGENTA + "K  K U   U  AA  N   N DDD  Y   Y K  K" + WHITE
                    + "                                        |   | ");
            System.out.println(" |   |  " + CYAN + "K K  U   U A  A NN  N D  D  Y Y  K K" + WHITE
                    + "                                         |   | ");
            System.out.println(" |   |  " + YELLOW + "KK   U   U AAAA N N N D  D   Y   KK" + WHITE
                    + "                                          |   | ");
            System.out.println(" |   |  " + GREEN + "K K  U   U A  A N  NN D  D   Y   K K" + WHITE
                    + "                                         |   | ");
            System.out.println(" |   |  " + BLUE + "K  K  UUU  A  A N   N DDD    Y   K  K" + WHITE
                    + "                                        |   | ");
            System.out.println(
                    " |   |                                                                               |   | ");
            System.out.println(
                    " |   |                                                                               |   | ");
            System.out.println(" |   |  " + RED + "K  K Y   Y RRRR  Y   Y K  K BBBB   AA  Y   Y EEEE V     V" + WHITE
                    + "                    |   | ");
            System.out.println(" |   |  " + YELLOW + "K K   Y Y  R   R  Y Y  K K  B   B A  A  Y Y  E    V     V" + WHITE
                    + "                    |   | ");
            System.out.println(" |   |  " + GREEN + "KK     Y   RRRR    Y   KK   BBBB  AAAA   Y   EEE   V   V" + WHITE
                    + "                     |   | ");
            System.out.println(" |   |  " + CYAN + "K K    Y   R R     Y   K K  B   B A  A   Y   E      V V" + WHITE
                    + "                      |   | ");
            System.out.println(" |   |  " + BLUE + "K  K   Y   R  RR   Y   K  K BBBB  A  A   Y   EEEE    V" + WHITE
                    + "                       |   | ");
            System.out.println(
                    " |   |                                                                               |   | ");
            System.out.println(
                    " |   |                                                                               |   | ");
            System.out.println(" |   |  " + MAGENTA + " OOO  M   M III RRRR  BBBB  EEEE K  K" + WHITE
                    + "                                        |   | ");
            System.out.println(" |   |  " + CYAN + "O   O MM MM  I  R   R B   B E    K K" + WHITE
                    + "                                         |   | ");
            System.out.println(" |   |  " + YELLOW + "O   O M M M  I  RRRR  BBBB  EEE  KK" + WHITE
                    + "                                          |   | ");
            System.out.println(" |   |  " + GREEN + "O   O M   M  I  R R   B   B E    K K" + WHITE
                    + "                                         |   | ");
            System.out.println(" |   |  " + BLUE + " OOO  M   M III R  RR BBBB  EEEE K  K" + WHITE
                    + "                                        |   | ");
            System.out.println(
                    " |   |                                                                               |   | ");
            System.out.println(
                    " |   |                                                                               |   | ");
            System.out.println(" |   |  " + RED + "U   U BBBB   AA  III DDD   AA  Y   Y EEEE V     V" + WHITE
                    + "                            |   | ");
            System.out.println(" |   |  " + YELLOW + "U   U B   B A  A  I  D  D A  A  Y Y  E    V     V" + WHITE
                    + "                            |   | ");
            System.out.println(" |   |  " + GREEN + "U   U BBBB  AAAA  I  D  D AAAA   Y   EEE   V   V" + WHITE
                    + "                             |   | ");
            System.out.println(" |   |  " + CYAN + "U   U B   B A  A  I  D  D A  A   Y   E      V V" + WHITE
                    + "                              |   | ");
            System.out.println(" |   |  " + BLUE + " UUU  BBBB  A  A III DDD  A  A   Y   EEEE    V" + WHITE
                    + "                               |   | ");
            System.out.println(
                    " |   |                                                                               |   | ");
            System.out.println(
                    " |   |                                                                               |   | ");
            System.out.println(
                    " |   |  " + MAGENTA + "RRRR   AA  U   U L        III BBBB  RRRR   AA  H  H III M   M  OOO  V     V"
                            + WHITE + "  |   | ");
            System.out.println(
                    " |   |  " + CYAN + "R   R A  A U   U L         I  B   B R   R A  A H  H  I  MM MM O   O V     V"
                            + WHITE + "  |   | ");
            System.out.println(
                    " |   |  " + YELLOW + "RRRR  AAAA U   U L         I  BBBB  RRRR  AAAA HHHH  I  M M M O   O  V   V"
                            + WHITE + "   |   | ");
            System.out.println(
                    " |   |  " + GREEN + "R R   A  A U   U L         I  B   B R R   A  A H  H  I  M   M O   O   V V"
                            + WHITE + "    |   | ");
            System.out.println(
                    " |   |  " + BLUE + "R  RR A  A  UUU  LLLL     III BBBB  R  RR A  A H  H III M   M  OOO     V"
                            + WHITE + "     |   | ");
            System.out.println(
                    " |___|                                                                               |___| ");
            System.out.println(
                    "(_____)-----------------------------------------------------------------------------(_____)");

            System.out.println(RESET);
            System.out.println("Hello choose one of these: ");
            while (breaker) {
                breaker = selectionmenu(user);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
