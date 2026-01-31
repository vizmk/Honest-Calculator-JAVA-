import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Logic logic=new Logic();
        //stampa messaggi
        String msg_0="Enter an equation";
        String msg_1="Do you even know what numbers are? Stay focused!";
        String msg_2="Yes ... an interesting math operation. You've slept through all classes, haven't you?";

        //inizio ciclo infinito
        while(true){
            System.out.println(msg_0);
            String input=scanner.nextLine();
            String [] parts=input.split(" ");
            if(parts.length!=3) {
                System.out.println(msg_1);
                continue;
            }
            if(!logic.check(parts)){
                System.out.println(msg_1);
                continue;
            }
            if(!logic.checkOperator(parts)){
                System.out.println(msg_2);
                continue;
            }else{
                break;
            }


        }
    }
}
