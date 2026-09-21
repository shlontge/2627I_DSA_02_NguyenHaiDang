import java.util.Scanner;
import java.util.Stack;

public class w3_tailop_25020116 {

    // Hàm trả về độ ưu tiên của toán tử
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    // Hàm chuyển đổi từ Trung tố (Infix) sang Hậu tố (Postfix)
    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Bỏ qua khoảng trắng nếu có
            if (Character.isWhitespace(c)) {
                continue;
            }

            // 1. Nếu ký tự là toán hạng (chữ cái hoặc chữ số), thêm vào kết quả
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            // 2. Nếu ký tự là '(', đẩy vào Stack
            else if (c == '(') {
                stack.push(c);
            }
            // 3. Nếu ký tự là ')', lấy toán tử ra khỏi Stack cho tới khi gặp '('
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Loại bỏ '(' ra khỏi Stack
                }
            }
            // 4. Nếu ký tự là toán tử (+, -, *, /)
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Lấy tất cả các toán tử còn lại trong Stack ra kết quả
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Biểu thức không hợp lệ!";
            }
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập biểu thức trung tố: ");
        String infix = scanner.nextLine();

        String postfix = infixToPostfix(infix);
        System.out.println("Biểu thức hậu tố (Ba Lan ngược): " + postfix);

        scanner.close();
    }
}