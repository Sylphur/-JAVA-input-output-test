
import java.io.*;
import java.util.*;


public class scratch {
    public static class MyException extends Exception {
        public MyException(String message) {
            super(message);
        }
    }
    private ArrayList<Integer> list;

    public scratch(ArrayList<Integer> list) {
        this.list = list;
    }

    public void write (int data){
        list.add(data);
    }
    public int read() {
        int first = list.get(0);
        list.remove(0);
        return first;
    }
    public int available() {
        return list.size();
    }

    public void print() {
        System.out.println("Current list is:");
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) throws IOException {
        scratch scr = new scratch(new ArrayList<>());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello!");
        int menu = 0;
        do {
            System.out.println("Press 1 to add integers to collection");
            System.out.println("Press 2 to cut collection into file");
            System.out.println("Press 3 to view collection");
            System.out.println("Press 4 to load collection from file");
            System.out.println("Press 5 to exit");
            try {
                menu = Integer.parseInt(reader.readLine());
                if (menu > 5 || menu < 0) throw new MyException("Enter numbers from 1 to 5");
            }
            catch (MyException e){
                System.out.println("Wrong number!");
            }
            catch (NumberFormatException e) {
                System.out.println("It is not a number!");
            }
            switch (menu){
                case 1 -> {
                    System.out.println("Enter number:");
                    try {
                        scr.write(Integer.parseInt(reader.readLine()));
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Enter number!");
                    }
                }
                case  2 -> {
                    OutputStream ouStream = new FileOutputStream("B:/test.txt");
                    while (scr.available() > 0) {
                        int data = scr.read();
                        ouStream.write(data);
                    }
                    ouStream.close();
                }
                case 3 -> {
                    scr.print();
                }
                case 4 -> {
                    InputStream inStream = new FileInputStream("B:/test.txt");
                    while (inStream.available() > 0){
                        int data = inStream.read();
                        scr.write(data);
                    }
                    inStream.close();
                }
            }
        }
        while (menu != 5);


    }
}
