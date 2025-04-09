
import java.util.HashSet;
import java.util.Scanner;

public class Remove_Duplicates {
    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to remove duplicates: ");
        String input = scanner.nextLine();
        String result = removeDuplicates(input);
        System.out.println("String without duplicates: " + result);
        scanner.close();
    }
}



