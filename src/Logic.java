import java.util.Set;
import java.util.HashSet;

public class Logic {
    public boolean check(String[] parts){
        try {
            Double.parseDouble(parts[0]);
            Double.parseDouble(parts[2]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
    public boolean checkOperator(String[] parts){
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        if(operators.contains(parts[1])) {
            return true;
        }
        return false;
    }


}
