
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Compare_StringBufferAndStringBuilder_filereaderandinputstreamreader {
    public static void main(String[] args) {
        int iterations = 1000000;
        String str = "hello";

        long startStringBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(str);
        }
        long endStringBuilder = System.nanoTime();
        long timeStringBuilder = endStringBuilder - startStringBuilder;

        long startStringBuffer = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sf.append(str);
        }
        long endStringBuffer = System.nanoTime();
        long timeStringBuffer = endStringBuffer - startStringBuffer;

        System.out.println("Time taken by StringBuilder: " + timeStringBuilder + " nanoseconds");
        System.out.println("Time taken by StringBuffer: " + timeStringBuffer + " nanoseconds");

        String filePath = "large_file.txt";
        
        long startFileReader = System.nanoTime();
        int wordCountFileReader = countWordsUsingFileReader(filePath);
        long endFileReader = System.nanoTime();
        long timeFileReader = endFileReader - startFileReader;

        long startInputStreamReader = System.nanoTime();
        int wordCountInputStreamReader = countWordsUsingInputStreamReader(filePath);
        long endInputStreamReader = System.nanoTime();
        long timeInputStreamReader = endInputStreamReader - startInputStreamReader;

        System.out.println("FileReader time: " + timeFileReader + " nanoseconds, Word count: " + wordCountFileReader);
        System.out.println("InputStreamReader time: " + timeInputStreamReader + " nanoseconds, Word count: " + wordCountInputStreamReader);
    }

    public static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return wordCount;
    }

    public static int countWordsUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return wordCount;
    }
}



