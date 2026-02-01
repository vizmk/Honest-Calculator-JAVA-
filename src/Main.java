import java.util.Scanner;

public class Main {
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

        while (true) {
            System.out.println(msg_0);

            String input = scanner.nextLine().trim();
            String[] parts = input.split("\\s+");

            // struttura: x oper y
            if (parts.length != 3) {
                System.out.println(msg_1);
                continue;
            }

            String xStr = parts[0];
            String oper = parts[1];
            String yStr = parts[2];

            // operatore valido?
            if (!logic.isValidOperator(oper)) {
                System.out.println(msg_2);
                continue;
            }

            // parse di x e y (supporta M) + gestione virgola
            float x, y;
            try {
                x = logic.parseValue(xStr, memory);
                y = logic.parseValue(yStr, memory);
            } catch (NumberFormatException e) {
                System.out.println(msg_1);
                continue;
            }

            // divisione per zero
            if (oper.equals("/") && y == 0.0f) {
                System.out.println(msg_3);
                continue;
            }

            float result = logic.calculate(x, oper, y);
            System.out.println(logic.formatResult(result));

            // store result?
            while (true) {
                System.out.println(msg_4);
                String ansStore = scanner.nextLine().trim().toLowerCase();

                if (ansStore.equals("y")) {
                    memory = result;
                    break;
                } else if (ansStore.equals("n")) {
                    break;
                }
                // se input diverso da y/n, ripete la domanda
            }

            // continue?
            while (true) {
                System.out.println(msg_5);
                String ansCont = scanner.nextLine().trim().toLowerCase();

                if (ansCont.equals("y")) {
                    break; // esce da questo while e riparte con una nuova equazione
                } else if (ansCont.equals("n")) {
                    return; // fine programma
                }
                // se input diverso da y/n, ripete la domanda
            }
        }
    }
}
