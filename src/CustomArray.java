import java.util.ArrayList;
import java.util.Arrays;

class CustomArray {
    private int[] myArray;

    public CustomArray(){
        int[] array = {10, -7, 100, 15, -4, 0, 11};
        myArray = array;
    }

    public CustomArray(int[] array){
        myArray = array;
    }

    public CustomArray(CustomArray array){
        this.myArray = new int[array.myArray.length];
        for(int i=0; i < this.myArray.length; i++)
        {
            this.myArray[i] = array.myArray[i];
        }
    }

    public int[] getMyArray(){
        return myArray;
    }

    public void setMyArray(int[] myArray) {
        this.myArray = new int[myArray.length];
        for(int i = 0; i < myArray.length; i++){
            this.myArray[i] = myArray[i];
        }
    }

    public void moreOrLessThan(String[] condition) {
        boolean lessThan = condition[0].equals("<");
        ArrayList newList = new ArrayList<Integer>();
        int number = Integer.parseInt(condition[1]);
        if (lessThan) {
            for (int i = 0; i < myArray.length; i++) {
                if (myArray[i] < number) {
                    newList.add(myArray[i]);
                }
            }
        } else {
            for (int i = 0; i < myArray.length; i++) {
                if (myArray[i] > number) {
                    newList.add(myArray[i]);
                }
            }
        }
        if (newList.isEmpty()) System.out.println("Таких чисел в массиве нет");
        else{
            myArray = new int[newList.size()];
            for(int i = 0; i < myArray.length; i++){
                myArray[i] = (int)newList.get(i);
            }
            writeArray();
        }
    }

    public void isEqual(String[] condition) {
        boolean isEqual = condition[0].equals("=");
        ArrayList newList = new ArrayList<Integer>();
        int number = Integer.parseInt(condition[1]);
        if (isEqual) {
            for (int i = 0; i < myArray.length; i++) {
                if (myArray[i] == number) {
                    newList.add(myArray[i]);
                }
            }
        } else {
            for (int i = 0; i < myArray.length; i++) {
                if (myArray[i] != number) {
                    newList.add(myArray[i]);
                }
            }
        }
        if (newList.isEmpty()) System.out.println("Таких чисел в массиве нет");
        else{
            myArray = new int[newList.size()];
            for(int i = 0; i < myArray.length; i++){
                myArray[i] = (int)newList.get(i);
            }
            writeArray();
        }
    }

    public void deleteDublicates(){
        Arrays.sort(myArray);
        int unique = 1;
        for(int i = 1; i < myArray.length; i++){
            if(myArray[i] != myArray[i - 1]){
                unique++;
            }
        }
        int[] newArray = new int[unique];
        int k = 0;
        if (newArray.length > 0){
            newArray[k++] = myArray[0];
        }
        for(int i = 1; i < myArray.length; i++){
            if(myArray[i] != myArray[i - 1]){ newArray[k++] = myArray[i];
            }
        }
        myArray = newArray;
    }

    public String isSorted(){
        byte mode = 0;
        if (myArray. length > 1){
            for(int i = 0; i < (myArray.length - 1); i++){
                if(myArray[i] < myArray[i+1])
                    mode = 1;
                else{
                    mode = 0;
                    break;
                }
            }
            if (mode == 0){
                for(int i = 0; i < (myArray.length - 1); i++){
                    if(myArray[i] > myArray[i+1])
                        mode = 2;
                    else{
                        mode = 0;
                        break;
                    }
                }
            }
        }
        else mode = 3;
        return writeMode(mode);
    }

    private String writeMode(int mode){
        String answer = "";
        switch (mode){
            case 0: {
                answer = "Данный массив не упорядочен.";
                break;
            }
            case 1: {
                answer = "Данный массив упорядочен по возрастанию.";
                break;
            }
            case 2: {
                answer = "Данный массив упорядочен по убыванию.";
                break;
            }
            case 3: {
                answer = "Данный массив состоит из одного элемента.";
                break;
            }
        }
        return answer;
    }

    public void writeArray(){
        System.out.print("[ ");
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println("]");
    }
}
