package honestcalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logic logic = new Logic();

        double memory = 0.0;

        String msg_0 = "Enter an equation";
        String msg_1 = "Do you even know what numbers are? Stay focused!";
        String msg_2 = "Yes ... an interesting math operation. You've slept through all classes, haven't you?";
        String msg_3 = "Yeah... division by zero. Smart move...";
        String msg_4 = "Do you want to store the result? (y / n):";
        String msg_5 = "Do you want to continue calculations? (y / n):";

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

            double x, y;
            try {
                x = logic.parseValue(xStr, memory);
                y = logic.parseValue(yStr, memory);
            } catch (NumberFormatException e) {
                System.out.println(msg_1);
                continue;
            }

            // ✅ FLOWCHART: prima stampa i messaggi lazy, poi controlla divisione per zero
            logic.check(x, y, oper);

            if (oper.equals("/") && y == 0.0) {
                System.out.println(msg_3);
                continue;
            }

            double result = logic.calculate(x, oper, y);
            System.out.println(result);

            // store result?
            while (true) {
                System.out.println(msg_4);
                String answer = scanner.nextLine().trim();

                if (answer.equals("y")) {
                    memory = result;
                    break;
                } else if (answer.equals("n")) {
                    break;
                }
            }

            // continue?
            while (true) {
                System.out.println(msg_5);
                String answer = scanner.nextLine().trim();

                if (answer.equals("y")) {
                    break;
                } else if (answer.equals("n")) {
                    return;
                }
            }
        }
    }
}
