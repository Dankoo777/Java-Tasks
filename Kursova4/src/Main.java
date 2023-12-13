import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> Arr = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Input number of elements: ");
        int n = scan.nextInt();
        if (n < 3) {
            System.out.println("Number of elements cannot be less than 3!");
            throw new RuntimeException();
        }
        int num;
        for (int i = 0; i < n; i++) {
            System.out.print("Input number to add to the array: ");
            num = scan.nextInt();
            Arr.add(num);
        }
        Check(Arr,n);

    }
    // Оптимизирано
    public static boolean Check(ArrayList<Integer> Arr, int n) {
        for (int i = 1; i < n - 1; i++) {
            if (i % 2 == 1) {
                // Нечетен индекс - проверка за строго намаляваща двойка
                if (!(Arr.get(i - 1) < Arr.get(i) && Arr.get(i) > Arr.get(i + 1))) {
                    System.out.println("The condition is not met");
                    return false;
                }
            } else {
                // Четен индекс - проверка за строго нарастваща двойка
                if (!(Arr.get(i - 1) > Arr.get(i) && Arr.get(i) < Arr.get(i + 1))) {
                    System.out.println("The condition is not met");
                    return false;
                }
            }
        }
        System.out.println("The condition is met");
        return true;
    }
}