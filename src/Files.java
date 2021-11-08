import java.io.*;

public class Files {
    public static void writeToBin(int[] array){
        String path;
            System.out.println("Введите путь к файлу");
            path = Input.scanner.nextLine();
            try(DataOutputStream writer = new DataOutputStream(new FileOutputStream(path))){
                writer.writeInt(array.length);
                for(int i = 0; i < array.length; i++){
                    writer.writeInt(array[i]);
                }
                System.out.println("Успешно сохранено в " + path);
            } catch (FileNotFoundException e){
                System.out.println("Неверное имя файла");
            } catch (IOException e){
                System.out.println("Ошибка записи");
            }
    }

    public static int[] readBin() {
        int[] array = null;
        String path;
        do {
            System.out.println("Введите путь к файлу");
            path = Input.scanner.nextLine();
            try (DataInputStream reader = new DataInputStream(new FileInputStream(path))) {
                int size = reader.readInt();
                array = new int[size];
                for (int i = 0; i < size; i++) {
                    array[i] = reader.readInt();
                }
            } catch (FileNotFoundException e) {
                System.out.println("Неверное имя файла");
            } catch (IOException e) {
                System.out.println("Ошибка чтения");
            }
        }while(array == null);
        return array;
    }

    public static void writeToTxt(String line) {
        String path;
        System.out.println("Введите путь к файлу");
        path = Input.scanner.nextLine();
        try(FileWriter writer = new FileWriter(path)){
            writer.write(line);
            System.out.println("Успешно сохранено в " + path);
        } catch (FileNotFoundException e){
            System.out.println("Неверное имя файла");
        } catch (IOException e){
            System.out.println("Ошибка записи");
        }
    }
}
