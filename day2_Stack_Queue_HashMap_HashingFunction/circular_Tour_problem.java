
import java.util.Scanner;

public class circular_Tour_problem {
    static int circularTour(int[] petrol, int[] distance, int n) {
        int start = 0;
        int surplus = 0;
        int deficit = 0;

        for (int i = 0; i < n; i++) {
            surplus += petrol[i] - distance[i];
            if (surplus < 0) {
                deficit += surplus;
                surplus = 0;
                start = i + 1;
            }
        }

        if (surplus + deficit >= 0) {
            return start;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] petrol = new int[n];
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            petrol[i] = sc.nextInt();
            distance[i] = sc.nextInt();
        }
        System.out.println(circularTour(petrol, distance, n));
        sc.close();
    }
}



