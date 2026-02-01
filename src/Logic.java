import java.util.Set;
import java.util.HashSet;

public class Logic {

    private final Set<String> operators;

    public Logic() {
        operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
    }

    public boolean isValidOperator(String oper) {
        return operators.contains(oper);
    }

    // Converte "M" -> memory, altrimenti parse float (supporta anche virgola "1,1")
    public float parseValue(String token, float memory) {
        if (token.equals("M")) {
            return memory;
        }
        token = token.replace(',', '.'); // se nei test capita la virgola
        return Float.parseFloat(token);
    }

    public float calculate(float x, String oper, float y) {
        switch (oper) {
            case "+": return x + y;
            case "-": return x - y;
            case "*": return x * y;
            case "/": return x / y;
            default:  return 0.0f; // non dovrebbe mai succedere se validi prima
        }
    }

    // Stampa stile "200.0" quando intero, e "20.8" quando decimale
    public String formatResult(float value) {
        if (value == (int) value) {
            return String.format("%d.0", (int) value);
        }
        // Float.toString non aggiunge zeri inutili (20.8 resta 20.8)
        return Float.toString(value);
    }
}
