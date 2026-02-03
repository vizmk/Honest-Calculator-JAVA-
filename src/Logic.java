import java.util.HashSet;
import java.util.Set;

public class Logic {

    private final Set<String> operators = new HashSet<>();

    public Logic() {
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
    }

    public boolean isValidOperator(String oper) {
        return operators.contains(oper);
    }

    // supports M and comma-decimals if they appear
    public float parseValue(String token, float memory) {
        if (token.equals("M")) {
            return memory;
        }
        token = token.replace(',', '.');
        return Float.parseFloat(token);
    }

    public float calculate(float x, String oper, float y) {
        switch (oper) {
            case "+": return x + y;
            case "-": return x - y;
            case "*": return x * y;
            case "/": return x / y;
            default:  return 0.0f;
        }
    }

    // one digit = integer between -10 and 10 (exclusive)
    public boolean isOneDigit(float value) {
        return value > -10.0f && value < 10.0f && value == (int) value;
    }

    // laziness rules -> return suffix (or "")
    public String checkLaziness(float x, float y, String oper, String msg_6, String msg_7, String msg_8) {
        StringBuilder out = new StringBuilder();

        if (isOneDigit(x) && isOneDigit(y)) {
            out.append(msg_6);
        }
        if (oper.equals("*") && (x == 1.0f || y == 1.0f)) {
            out.append(msg_7);
        }
        if ((oper.equals("+") || oper.equals("-") || oper.equals("*")) && (x == 0.0f || y == 0.0f)) {
            out.append(msg_8);
        }
        return out.toString();
    }

    // print like examples: 200.0, 3.1, 5.0, 20.8
    public String formatResult(float value) {
        // if integer -> always show one decimal
        if (value == (int) value) {
            return String.format("%.1f", value);
        }
        // otherwise default float string is fine (keeps 3.1, 20.8, etc.)
        return Float.toString(value);
    }
}
