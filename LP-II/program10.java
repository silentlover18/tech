import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class program10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the message to encrypt: ");
        String message = scanner.nextLine();

        System.out.println("Enter the AES secret key (16, 24, or 32 bytes): ");
        String secretKey = scanner.nextLine();

        try {
            // Encrypt the message
            String encryptedMessage = encrypt(message, secretKey);
            System.out.println("Encrypted message: " + encryptedMessage);

            // Decrypt the message
            String decryptedMessage = decrypt(encryptedMessage, secretKey);
            System.out.println("Decrypted message: " + decryptedMessage);

        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String encrypt(String message, String secretKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        // Create AES cipher
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        // Generate secret key
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");

        // Initialize cipher for encryption
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        // Perform encryption
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());

        // Convert encrypted bytes to Base64 for easier display
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedMessage, String secretKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        // Create AES cipher
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        // Generate secret key
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");

        // Initialize cipher for decryption
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        // Decode Base64 and perform decryption
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));

        // Convert decrypted bytes to string
        return new String(decryptedBytes);
    }
}
