import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class program11 {
    public static void main(String[] args) throws Exception {
        // Generate RSA key pair
        KeyPair keyPair = generateRSAKeyPair();

        // Original message
        String originalMessage = "Hello, RSA!";

        // Encrypt the message using RSA public key
        String encryptedMessage = encrypt(originalMessage, keyPair.getPublic());

        // Decrypt the message using RSA private key
        String decryptedMessage = decrypt(encryptedMessage, keyPair.getPrivate());

        // Print results
        System.out.println("Original message: " + originalMessage);
        System.out.println("Encrypted message: " + encryptedMessage);
        System.out.println("Decrypted message: " + decryptedMessage);
    }

    // Function to generate RSA key pair
    public static KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // RSA key size
        return keyPairGenerator.generateKeyPair();
    }

    // Function to encrypt message using RSA public key
    public static String encrypt(String message, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Function to decrypt message using RSA private key
    public static String decrypt(String encryptedMessage, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        return new String(decryptedBytes);
    }
}
