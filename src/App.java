import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class App {
    final static HashMap<Integer, String> choices = new HashMap<>();

    public static void main(String[] args) {
        fillChoices();
        int computerChoice = generateRandomChoice();
        int userChoice = getUserChoice();
        String result = generateResult(computerChoice, userChoice);
        
        System.out.println("Computer: " + choices.get(computerChoice));
        System.out.println("You: " + choices.get(userChoice));
        System.out.println(result);
    }

    private static int generateRandomChoice() {
        Random random = new Random();
        return random.nextInt(3);
    }

    private static int getUserChoice() {

        Scanner scanner = new Scanner(System.in);

        String menu = """
                !!!--- Welcome to Stone Paper Scissors ---!!!
                [1] STONE\s
                [2] SCISSORS\s
                [3] PAPER\s
                Computer made a choice...\s
                Now its your turn (write down the code):\s""";

        System.out.println(menu);
        int choice = scanner.nextInt();
        while (!(choice >= 1 && choice <= 3)) {
            System.out.println("Invalid code, please write a valid code: ");
            choice = scanner.nextInt();
        }
        return choice-1;
    }

    private static String generateResult(int computerChoice, int userChoice) {
        if (computerChoice == userChoice) {
            return "Match Tied.";
        } else if (computerChoice != 2 && computerChoice == (userChoice - 1)) {
            return "Computer Won.";
        } else if (computerChoice == 2 && userChoice == 0){
            return "Computer Won.";
        } else {
            return "You Won.";
        }
    }

    private static void fillChoices() {
        choices.put(0, "STONE");
        choices.put(1, "SCISSORS");
        choices.put(2, "PAPER");
    }
}
