public class program7 {
    public static void main(String[] args) {
        // Define the string
        String inputString = "\\Hello World";

        // Perform AND and XOR operations on each character
        System.out.println("Original String: " + inputString);
        System.out.println("String after AND with 127:");
        for (char c : inputString.toCharArray()) {
            char result = (char) (c & 127);
            System.out.print(result);
        }
        System.out.println("\nString after XOR with 127:");
        for (char c : inputString.toCharArray()) {
            char result = (char) (c ^ 127);
            System.out.print(result);
        }
    }
}
