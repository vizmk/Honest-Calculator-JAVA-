import java.util.Set;
import java.util.HashSet;

public class Logic {
    public boolean check(String[] parts) {
        try {
            Double.parseDouble(parts[0]);
            Double.parseDouble(parts[2]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public boolean checkOperator(String[] parts) {
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        if (operators.contains(parts[1])) {
            return true;
        }
        return false;
    }

    //calcolo
    public float calculator(String[] parts){


        float x = Float.parseFloat(parts[0]);
        float y = Float.parseFloat(parts[2]);
        switch (parts[1]){
            case "+":
                return x+y;
            case "-":
                return x-y;
            case "*":
                return x*y;
            case"/":
                if(y!=0) {
                    return x / y;
                }else{
                    return 0;
                }
            default:
                return 0;
        }
    }


}
