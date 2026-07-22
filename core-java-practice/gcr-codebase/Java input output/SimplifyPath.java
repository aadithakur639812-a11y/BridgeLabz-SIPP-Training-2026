import java.util.Scanner;
import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            }
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder simplifiedPath = new StringBuilder();
        for (String directory : stack) {
            simplifiedPath.append("/").append(directory);
        }

        return simplifiedPath.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter path: ");
        String path = scanner.nextLine();

        System.out.println("Simplified path: " + simplifyPath(path));
        scanner.close();
    }
}
