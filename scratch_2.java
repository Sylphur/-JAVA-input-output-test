import java.io.*;
import java.util.*;

// Took destination of .txt file from console. Then sort it into ascending order and print even of all numbers

public class scratch {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        BufferedReader fileReader = null;
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))){
            String source = consoleReader.readLine();
            fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(source), "UTF-8"));
            while (fileReader.ready()){
                numbers.add(Integer.parseInt(fileReader.readLine()));
            }
            fileReader.close();
        }
        catch (IOException | NumberFormatException e){
            e.printStackTrace();
        }
        Collections.sort(numbers);
        for (Integer i : numbers) {
            if ((i % 2) == 0) System.out.println(i);
        }
    }
}
