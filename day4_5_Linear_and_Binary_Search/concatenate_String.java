
import java.util.Scanner;

public class concatenate_String {
    public static String concatenateStrings(String[] arr) {
        StringBuffer sb = new StringBuffer();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            arr[i] = scanner.nextLine();
        }
        String result = concatenateStrings(arr);
        System.out.println("Concatenated String: " + result);
        scanner.close();
    }
}

