import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Primary_School {

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
            System.out.println("Invalid format! Please type in: (yyyy-month-day)");
        }
    }

    static String reverse_the_word(String word) {
        char[] chars = word.toCharArray();
        int left = 0;
        int right = word.length() - 1;

        String turkishLetters = "abcçdefgğhıijklmnoöprsştuüvyzABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ";

        while (left < right) {
            if (turkishLetters.indexOf(chars[left]) == -1) {
                left++;
            }
            else if (turkishLetters.indexOf(chars[right]) == -1) {
                right--;
            }
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

    static void optianA(Scanner user) {
        boolean breaker = true;
        while (breaker) {
            System.out.println("[A]Age and Zodiac Sign Detector");
            System.out.println("[B]Reverse the Words");
            System.out.println("[C]Return to Main Menu");
            String input = user.nextLine();
            if (input.length() != 1) {
                System.out.println("Invalid input! Please enter only a single character: A, B, C, D, or E.");
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
                    System.err.println("Invalid input! Please choose again.");
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
                optianA(user);
                break;
            case 'B':

                break;
            case 'C':

                break;
            case 'D':

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
            while (breaker) {
                breaker = selectionmenu(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

