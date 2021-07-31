import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

class Scratch {
    public static void main(String[] args) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        int data = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fis = new FileInputStream("B:/test.txt");
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            br = new BufferedReader(isr);
            int menu = Integer.parseInt(reader.readLine());
            switch (menu) {
                case (1) -> {
                    while (fis.available() > 0) {
                        System.out.print((char) fis.read());
                    }
                }
                case (2) -> {
                    while ((data = isr.read()) != -1) {
                        System.out.print((char) data);
                    }
                }
                case (3) -> {
                    while (br.ready()) {
                        System.out.println(br.readLine());
                    }
                }
                default -> System.exit(0);
            }
            reader.close();
            fis.close();
            isr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.exit(0);
        }
    }
}