import java.io.*;

public class LargeFileReading {

    public static void main(String[] args) {
        String filePath = "D:/java codes/day18/largefile.txt"; // Replace with your file path

        System.out.println("FileReader Time: " + measureFileReaderTime(filePath) + "ms");
        System.out.println("InputStreamReader Time: " + measureInputStreamReaderTime(filePath) + "ms");
    }

    private static long measureFileReaderTime(String filePath) {
        long startTime = System.currentTimeMillis();
        try (FileReader fileReader = new FileReader(filePath)) {
            while (fileReader.read() != -1) {
                // Reading character by character
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - startTime;
    }

    private static long measureInputStreamReaderTime(String filePath) {
        long startTime = System.currentTimeMillis();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            while (inputStreamReader.read() != -1) {
                // Reading byte by byte and converting to characters
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - startTime;
    }
}
