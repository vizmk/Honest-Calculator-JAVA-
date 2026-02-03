import java.util.Scanner;

public class Main {

    private static String readYesNo(Scanner scanner, String prompt) {
        while (true) {
            System.out.println(prompt);
            String ans = scanner.nextLine().trim().toLowerCase();
            if (ans.equals("y") || ans.equals("n")) {
                return ans;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logic logic = new Logic();

        float memory = 0.0f;

        String msg_0 = "Enter an equation";
        String msg_1 = "Do you even know what numbers are? Stay focused!";
        String msg_2 = "Yes ... an interesting math operation. You've slept through all classes, haven't you?";
        String msg_3 = "Yeah... division by zero. Smart move...";
        String msg_4 = "Do you want to store the result? (y / n):";
        String msg_5 = "Do you want to continue calculations? (y / n):";

        String msg_6 = " ... lazy";
        String msg_7 = " ... very lazy";
        String msg_8 = " ... very, very lazy";
        String msg_9 = "You are";

        String msg_10 = "Are you sure? It is only one digit! (y / n)";
        String msg_11 = "Don't be silly! It's just one number! Add to the memory? (y / n)";
        String msg_12 = "Last chance! Do you really want to embarrass yourself? (y / n)";

        String[] oneDigitMsgs = {msg_10, msg_11, msg_12};

        while (true) {
            System.out.println(msg_0);
            String input = scanner.nextLine().trim();
            String[] parts = input.split("\\s+");

            if (parts.length != 3) {
                System.out.println(msg_1);
                continue;
            }

            String xStr = parts[0];
            String oper = parts[1];
            String yStr = parts[2];

            if (!logic.isValidOperator(oper)) {
                System.out.println(msg_2);
                continue;
            }

            float x, y;
            try {
                x = logic.parseValue(xStr, memory);
                y = logic.parseValue(yStr, memory);
            } catch (NumberFormatException e) {
                System.out.println(msg_1);
                continue;
            }

            if (oper.equals("/") && y == 0.0f) {
                System.out.println(msg_3);
                continue;
            }

            // laziness message (print only if not empty)
            String lazySuffix = logic.checkLaziness(x, y, oper, msg_6, msg_7, msg_8);
            if (!lazySuffix.isEmpty()) {
                System.out.println(msg_9 + lazySuffix);
            }

            float result = logic.calculate(x, oper, y);
            System.out.println(logic.formatResult(result));

            // store result?
            String storeAns = readYesNo(scanner, msg_4);
            if (storeAns.equals("y")) {

                if (logic.isOneDigit(result)) {
                    boolean store = true;

                    for (String m : oneDigitMsgs) {
                        String ans = readYesNo(scanner, m);
                        if (ans.equals("n")) {
                            store = false;
                            break;
                        }
                    }

                    if (store) {
                        memory = result;
                    }
                } else {
                    memory = result;
                }
            }

            // continue?
            String contAns = readYesNo(scanner, msg_5);
            if (contAns.equals("n")) {
                break;
            }
        }
    }
}
