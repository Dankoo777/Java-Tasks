import java.util.Scanner;
import java.util.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Node root = null;
        System.out.println("Въвеждане на стойности");
        System.out.println("За приключване на операциата въведете -1");
        while(true) {
            System.out.println("Въведете стойност: ");
            int input = scan.nextInt();
            if (input == -1) {
                break;
            }
            root = insert(root,input);
        }
        int[] result = sumOddEvenValues(root);
        System.out.println("Сумата на четните стойности е: " + result[0]);
        System.out.println("Сумата на нечетните стойности е: " + result[1]);
    }
    public static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }
        return root;
    }
    public static int[] sumOddEvenValues(Node root) {
        int[] result = new int[2];
        // Връщаме [0][0] ако дървото е празно
        if (root == null) {
            return result;
        }
        int evenSum = 0;
        int oddSum = 0;
        Node tmpNode;
        Stack<Node> stack= new Stack<>();
        // Добавяне на върха в стека
        stack.push(root);
        while (!stack.isEmpty()) {
            tmpNode = stack.pop();
            if (tmpNode.value % 2 == 0) {
                evenSum += tmpNode.value;
            } else {
                oddSum += tmpNode.value;
            }
            // Добавяне на всяко поддърво в стека
            if (tmpNode.right != null) {
                stack.push(tmpNode.right);
            }
            if (tmpNode.left != null) {
                stack.push(tmpNode.left);
            }
        }
        result[0] = evenSum;
        result[1] = oddSum;
        return result;
    }
}