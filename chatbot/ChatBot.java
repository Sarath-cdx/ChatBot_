// // import java.util.Scanner;

// // public class ChatBot {

// //     public static void main(String[] args) {

// //         Scanner sc = new Scanner(System.in);
// //         MathModule math = new MathModule();

// //         System.out.println("🤖 Chatbot Ready! (type 'exit' to quit)");

// //         while (true) {

// //             System.out.print("You: ");
// //             String input = sc.nextLine();

// //             // Exit condition
// //             if (input.equalsIgnoreCase("exit")) {
// //                 System.out.println("Bot: Goodbye!");
// //                 break;
// //             }

// //             // Send to math module
// //             if (math.handles(input)) {
// //                 System.out.println("Bot: " + math.respond(input));
// //             } else {
// //                 System.out.println("Bot: I only handle math right now 🙂");
// //             }
// //         }

// //         sc.close();
// //     }
// // }
// import java.util.Scanner;

// public class Chatbot {

//     private final MathModule math = new MathModule();
//     private final JokesModule jokes = new JokesModule();
//     private final InfoModule info = new InfoModule();

//     public static void main(String[] args) {
//         new Chatbot().run();
//     }

//     void run() {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("🤖 Chatbot Ready!");
//         System.out.println("Try: 5+3 | joke | time | war | quit");

//         while(true){
//             System.out.print("You: ");
//             String input = sc.nextLine().toLowerCase();

//             if(input.equals("quit"))
//                 break;

//             System.out.println("Bot: " + route(input));
//         }

//         sc.close();
//     }

//     String route(String input) {
//         if(math.handles(input)) return math.respond(input);
//         if(jokes.handles(input)) return jokes.respond(input);
//         if(info.handles(input)) return info.respond(input);

//         return "I don't understand yet 🙂";
//     }
// }
