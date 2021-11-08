import java.util.Scanner;

public class Input {
    public final static Scanner scanner = new Scanner(System.in);

    public static int integer(){
        String input;
        boolean correctInput;
        int number = 0;
        do {
            input = scanner.nextLine();
            correctInput = true;
            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Это не число!");
                correctInput = false;
            }
        } while(!correctInput);
        return number;
    }

    public static String[] condition(int mode){
        boolean correctInput = true;
        int number;
        String input;
        String[] inputWS;
        String condition;
        if (mode == 1) condition = "> 10";
        else condition = "<> 1";
        do{
            if (!correctInput) System.out.println("Неверный ввод!");
            System.out.println("Введите условие формата \"" + condition + "\".");
            input = scanner.nextLine();
            inputWS = input.split(" ");
            if (mode == 1){
                if (inputWS[0].equals(">") || inputWS[0].equals("<"))
                    correctInput = true;
                else {
                    correctInput = false;
                    continue;
                }
            }
            else{
                if (inputWS[0].equals("=") || inputWS[0].equals("<>"))
                    correctInput = true;
                else {
                    correctInput = false;
                    continue;
                }
            }
            try {
                number = Integer.parseInt(inputWS[1]);
            } catch (NumberFormatException e) {
                correctInput = false;
            }

        } while (!correctInput);
        return inputWS;
    }

    public static int[] stringWithNumbers() {
        boolean correctInput = false;
        String input;
        String[] numbers;
        int[] array = {0};

        while(!correctInput){
            correctInput = true;
            System.out.println("Введите строку с числами, разделенными пробелами.");
            input = scanner.nextLine();
            numbers = input.split(" ");
            array = new int[numbers.length];
            for(int i = 0; i < numbers.length; i++){
                try {
                    array[i] = Integer.parseInt(numbers[i]);
                }catch(NumberFormatException e){
                    System.out.println("Строка не соответсвует требованиям!");
                    correctInput = false;
                    break;
                }
            }
        }
        return array;
    }
}
