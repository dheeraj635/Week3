
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadUserInput_WriteToFile {
    public static void writeUserInputToFile(String filePath) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fw = new FileWriter(filePath, true); 
            String line;

            System.out.println("Enter text to write to file (type 'exit' to stop):");

            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(line + System.lineSeparator()); 
            }

            br.close();
            fw.close();
            System.out.println("Input written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "user_input.txt"; 
        writeUserInputToFile(filePath);
    }
}



