import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Integer> Arr = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Input number of elements: ");
        int n = scan.nextInt();
        int num;
        for (int i = 0; i < n; i++) {
            System.out.print("Input number to add to the array: ");
            num = scan.nextInt();
            Arr.add(num);
        }
        Check(Arr,n);
    }
    // Не оптимизирано
    public static boolean Check(ArrayList<Integer> Arr, int n) {
        // За 0 елемента в масива
        if (n == 0) {
            System.out.println("The condition is not met with empty array");
            return false;
        }
        // За 1 елемент масива
        if (n == 1) {
            System.out.println("The condition is always met");
            return true;
        }
        // За нечетни
        for (int i = 1; i < n - 1; i += 2) {
            if (!((Arr.get(i - 1) < Arr.get(i)) && (Arr.get(i) > Arr.get(i + 1)))) {
                System.out.println("The condition is not met");
                return false;
            }
        }
        // За четни
        for (int i = 2; i < n - 1; i += 2) {
            if (!((Arr.get(i - 1) > Arr.get(i)) && (Arr.get(i) < Arr.get(i + 1)))) {
                System.out.println("The condition is not met");
                return false;
            }
        }
        System.out.println("The condition is met");
        return true;
    }
}
