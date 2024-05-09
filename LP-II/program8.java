import java.util.Scanner;

public class program8 {
    // Function to encrypt the message
    public static String encrypt(String message, int key) {
        // Calculate the number of rows required
        int numRows = (int) Math.ceil((double) message.length() / key);
        char[][] matrix = new char[numRows][key];
        int index = 0;

        // Fill the matrix with the message characters
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < key; j++) {
                if (index < message.length())
                    matrix[i][j] = message.charAt(index++);
                else
                    matrix[i][j] = ' ';
            }
        }

        // Construct the encrypted message
        StringBuilder encryptedMessage = new StringBuilder();
        for (int j = 0; j < key; j++) {
            for (int i = 0; i < numRows; i++) {
                encryptedMessage.append(matrix[i][j]);
            }
        }
        return encryptedMessage.toString();
    }

    // Function to decrypt the message
    public static String decrypt(String encryptedMessage, int key) {
        // Calculate the number of rows required
        int numRows = (int) Math.ceil((double) encryptedMessage.length() / key);
        char[][] matrix = new char[numRows][key];
        int index = 0;

        // Fill the matrix with the encrypted message characters
        for (int j = 0; j < key; j++) {
            for (int i = 0; i < numRows; i++) {
                if (index < encryptedMessage.length())
                    matrix[i][j] = encryptedMessage.charAt(index++);
                else
                    matrix[i][j] = ' ';
            }
        }

        // Construct the decrypted message
        StringBuilder decryptedMessage = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < key; j++) {
                decryptedMessage.append(matrix[i][j]);
            }
        }
        return decryptedMessage.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the message and key from the user
        System.out.print("Enter the message to encrypt: ");
        String message = scanner.nextLine();
        System.out.print("Enter the key (number of columns): ");
        int key = scanner.nextInt();

        // Encrypt the message
        String encryptedMessage = encrypt(message, key);
        System.out.println("Encrypted message: " + encryptedMessage);

        // Decrypt the message
        String decryptedMessage = decrypt(encryptedMessage, key);
        System.out.println("Decrypted message: " + decryptedMessage);

        scanner.close();
    }
}
