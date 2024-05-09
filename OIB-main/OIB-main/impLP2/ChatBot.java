import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi there! I'm ChatBot. What's your name?");
        String name = scanner.nextLine();
        System.out.println("Nice to meet you, " + name + "! How can I assist you today?");

        // Chat loop
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().toLowerCase();

            // Check for exit command
            if (input.equals("exit")) {
                System.out.println("Goodbye, " + name + "! Have a great day!");
                break;
            }

            // Process user input and generate response
            String response = generateResponse(input);
            System.out.println(response);
        }

        scanner.close();
    }
public static String generateResponse(String input) {
    // Define responses based on user input
    switch (input) {
        case "how are you?":
            return "I'm just a program, so I don't have feelings, but thanks for asking!";
        case "what's your favorite color?":
            return "I don't have a favorite color, but I do like all colors!";
        case "tell me a joke":
            return "Why don't scientists trust atoms? Because they make up everything!";
        case "what is your purpose?":
            return "My purpose is to assist you and engage in conversation!";
        case "who created you?":
            return "I was created by a Pradip.";
        case "what can you do?":
            return "I can answer questions, tell jokes, or engage in conversation with you!";
        case "how old are you?":
            return "I don't have an age, but I was created recently.";
        case "where are you from?":
            return "I exist in the digital realm, so I don't have a physical location.";
        case "do you dream?":
            return "No, I don't dream, but I'm here to help you achieve your goals!";
        case "what is the meaning of life?":
            return "The meaning of life is subjective and can vary from person to person.";
        default:
            return "I'm sorry, I didn't understand that. Can you please rephrase?";
    }
}
}

