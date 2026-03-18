// // import java.util.Scanner;

// // class Chatbot {
// //     private final JokesModule jokes = new JokesModule();
// //     private final MathModule math = new MathModule();
// //     private final InfoModule info = new InfoModule();
    
// //     public static void main(String[] args) {
// //         new Chatbot().run();
// //     }
    
// //     void run() {
// //         Scanner scanner = new Scanner(System.in);
// //         System.out.println("🤖 Modular Bot: jokes|math|info|quit");
        
// //         while (true) {
// //             System.out.print("You: ");
// //             String input = scanner.nextLine().toLowerCase().trim();
// //             if (input.equals("quit")) break;
            
// //             String reply = route(input);
// //             System.out.println("Bot: " + reply + "\n");
// //         }
// //         scanner.close();
// //     }
    
// //     String route(String input) {
// //         if (math.handles(input)) return math.respond(input);
// //         if (jokes.handles(input)) return jokes.respond(input);
// //         if (info.handles(input)) return info.respond(input);
// //         return "Modules: math(2+2), jokes, info(about), time. Try 'help'!";
// //     }
// // }
// import java.util.Scanner;

// class Chatbot {
//     private final JokesModule jokes = new JokesModule();
//     private final MathModule math = new MathModule();
//     private final InfoModule info = new InfoModule();
    
//     public static void main(String[] args) {
//         new Chatbot().run();
//     }
    
//     void run() {
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("🤖 Modular Bot: math(2+2)|joke|about|time|quit");
        
//         while (true) {
//             System.out.print("You: ");
//             String input = scanner.nextLine().toLowerCase().trim();
//             if (input.equals("quit")) break;
            
//             String reply = route(input);
//             System.out.println("Bot: " + reply + "\n");
//         }
//         scanner.close();
//     }
    
//     String route(String input) {
//         if (math.handles(input)) return math.respond(input);
//         if (jokes.handles(input)) return jokes.respond(input);
//         if (info.handles(input)) return info.respond(input);
//         return "Try: 10+5, joke, about, time, help | 'quit'";
//     }
// }
