package honestcalculator;

import java.util.HashSet;
import java.util.Set;

public class Logic {

    private final Set<String> operators = new HashSet<>();

    // messaggi lazy (IDENTICI)
    private final String msg_6 = " ... lazy";
    private final String msg_7 = " ... very lazy";
    private final String msg_8 = " ... very, very lazy";
    private final String msg_9 = "You are";

    public Logic() {
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
    }

    public boolean isValidOperator(String oper) {
        return operators.contains(oper);
    }

    public double parseValue(String token, double memory) {
        if (token.equals("M")) {
            return memory;
        }
        return Double.parseDouble(token);
    }

    public double calculate(double x, String oper, double y) {
        switch (oper) {
            case "+": return x + y;
            case "-": return x - y;
            case "*": return x * y;
            case "/": return x / y;
            default:  return 0.0;
        }
    }

    // is_one_digit: intero matematico tra -9 e 9
    public boolean is_one_digit(double v) {
        return v > -10 && v < 10 && v == Math.floor(v);
    }

    // check: stampa "You are ..." se almeno una regola scatta
    public void check(double v1, double v2, String oper) {
        String msg = "";

        // 1) entrambi one-digit -> lazy
        if (is_one_digit(v1) && is_one_digit(v2)) {
            msg += msg_6;
        }

        // 2) moltiplicazione per 1 -> very lazy
        if ((v1 == 1 || v2 == 1) && oper.equals("*")) {
            msg += msg_7;
        }

        // 3) uso inutile dello 0 -> very, very lazy
        if ((v1 == 0 || v2 == 0) &&
                (oper.equals("*") || oper.equals("+") || oper.equals("-"))) {
            msg += msg_8;
        }

        if (!msg.isEmpty()) {
            System.out.println(msg_9 + msg);
        }
    }
}
