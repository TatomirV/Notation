import java.util.Scanner;
import java.util.Stack;

class Operations {
    public static int Operation(String op, int a, int b){
        int sum = 0;
        switch(op){
            case "+": sum = a + b; return sum;
            case "-": sum = a - b; return sum;
            case "/": sum = a / b; return sum;
            case "*": sum = a * b; return sum;
        }
        return sum;
    }
}

class Stacking {
    public static int Stacked(int i, String[] arr, Stack<Integer> stack, int a, int b, int sum){
            if (arr[i].matches("-?[0-9]+")) {
                stack.push(Integer.parseInt(arr[i]));
            } else if (arr[i].matches("\\+|\\-|\\*|\\/")) {
                a = stack.pop();
                b = stack.pop();
                sum = Operations.Operation(arr[i], a, b);
                stack.push(sum);
            } else {
                Exit.Err();
            }
        return sum;
    }
}

class Exit {
    public static void Err() {
        System.out.println("Проверьте правильность ввода!");
        System.exit(0);
    }
}

public class Main {
    public static void main(String[] args) {
        int sum=0, firstOperand=0, secondOperand=0;
        Stack<Integer> stack = new Stack<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();
        scanner.close();

        String[] arr = new String[input.length()];
        arr = input.split(" ");

        if (arr[0].matches("-?[0-9]+")) {
            for (int i = 0; i < arr.length; i++)
                sum = Stacking.Stacked(i, arr, stack, firstOperand, secondOperand, sum);
        } else if (arr[0].matches("\\+|\\-|\\*|\\/")) {
            for (int i = arr.length - 1; i >= 0; i--)
                sum = Stacking.Stacked(i, arr, stack, firstOperand, secondOperand, sum);

        } else { Exit.Err(); }

        System.out.println(sum);
    }
}
