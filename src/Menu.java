
public class Menu{
    private static CustomArray taskArray;
    private static int choice = 0;

    public static void howToFillArray(){
        choice = 0;
        System.out.println("Как заполнить массив?");
        System.out.println("1 - самостоятельно, 2 - использовать существующий");

        while (choice < 1 || choice > 2){
            choice = Input.integer();
            if (choice < 1 || choice > 2){
                System.out.println("Вы ввели число неверно!");
            }
        }

        if (choice == 1){
            taskArray = new CustomArray(Input.stringWithNumbers());
        }
        else arrayMenu();
        taskArray.writeArray();
    }

    public static void task4Menu(String task4){
        choice = 0;
        System.out.println(task4);
        System.out.println("Хотите сохранить ответ в файл? (1 - да)");
        choice = Input.integer();
        if (choice == 1){
            Files.writeToTxt(task4);
        }
    }

    public static void arrayMenu(){
        choice = 0;
        do{
            System.out.println("1:\tВзять массив из кода программы");
            System.out.println("2:\tПрочитать массив из файла");
            choice = Input.integer();
            switch (choice){
                case 1: {
                    taskArray = new CustomArray();
                    break;
                }
                case 2:{
                    taskArray = new CustomArray();
                    int[] temp = Files.readBin();
                    taskArray.setMyArray(temp);
                    break;
                }
            }
            if (taskArray == null){
                System.out.println("Вы ввели число неверно!");
            }
        }while(taskArray == null);
    }
    public static void mainMenu(){
        String[] condition;
        choice = 0;
        int exit = 0;
        while (exit != 100) {
            System.out.println("1\tПервое задание");
            System.out.println("2\tВторое задание");
            System.out.println("3\tТретье задание");
            System.out.println("4\tЧетвертое задание");
            System.out.println("5\tСохранить массив в файл");
            System.out.println("100\tВыйти из программы");
            choice = Input.integer();
            switch (choice) {
                case 1: {
                    condition = Input.condition(1);
                    taskArray.moreOrLessThan(condition);
                    break;
                }
                case 2: {
                    condition = Input.condition(2);
                    taskArray.isEqual(condition);
                    break;
                }
                case 3: {
                    taskArray.deleteDublicates();
                    taskArray.writeArray();
                    break;
                }
                case 4: {
                    String answer="";
                    answer = taskArray.isSorted();
                    task4Menu(answer);
                    break;
                }
                case 5:{
                    Files.writeToBin(taskArray.getMyArray());
                    break;
                }
                case 100:{
                    exit = 100;
                    break;
                }
                default:
                    System.out.println("Таких условий нет");
            }
        }
    }
}
