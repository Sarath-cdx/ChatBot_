// import java.util.Scanner;
// import java.util.Scanner;

// public class ChatbotTest {

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);
//         ChatbotTest bot = new ChatbotTest();

//         System.out.println("Chatbot ready! Type 'exit' to quit.");
//   while(true) {
//             System.out.print("You: ");
//             String input = sc.nextLine();

//             if(input.equalsIgnoreCase("exit"))
//                 break;

//             System.out.println("Bot: " + bot.respond(input));
//         }
//     }
//     }
// }

import java.util.Scanner;

public class ChatbotTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChatbotTest bot = new ChatbotTest();

        System.out.println("Chatbot ready! Type 'exit' to quit.");

        while(true) {
            System.out.print("You: ");
            String input = sc.nextLine();

            if(input.equalsIgnoreCase("exit"))
                break;

            System.out.println("Bot: " + bot.respond(input));
        }
    }

    // ✅ This method was missing
    public String respond(String input) {

        input = input.toLowerCase();

        if(input.contains("hello") || input.contains("hi"))
            return "Hey there!";

        else if(input.contains("how are you"))
            return "I'm just code, but I'm doing great 😄";

        else if(input.contains("name"))
            return "I'm your Java chatbot.";

        else
            return "I don't understand that yet.";
    }
}




