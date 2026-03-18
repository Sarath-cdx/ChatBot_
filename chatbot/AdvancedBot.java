import java.util.*;
import java.time.LocalDateTime;


// =============================
// Intent Types
// =============================
enum Intent {
    GREETING,
    MATH,
    JOKE,
    TIME,
    NAME_SET,
    NAME_QUERY,
    LEARN,
    UNKNOWN
}


// =============================
// Context Memory
// =============================
class Context {
    String userName = "Human";
    Map<String,String> learned = new HashMap<>();
}


// =============================
// Intent Detector
// =============================
class IntentDetector {

    public Intent detect(String input) {

        input = input.toLowerCase();

        if(input.matches(".*\\d+.*[+\\-*/()].*"))
            return Intent.MATH;

        if(input.contains("hello") || input.contains("hi"))
            return Intent.GREETING;

        if(input.contains("joke"))
            return Intent.JOKE;

        if(input.contains("time"))
            return Intent.TIME;

        if(input.startsWith("my name is"))
            return Intent.NAME_SET;

        if(input.contains("who am i"))
            return Intent.NAME_QUERY;

        if(input.startsWith("learn "))
            return Intent.LEARN;

        return Intent.UNKNOWN;
    }
}


// =============================
// Math Solver (Stack Based)
// =============================
class MathSolver {

    public double eval(String expr) {
        return evaluatePostfix(infixToPostfix(expr));
    }

    private List<String> infixToPostfix(String expr) {

        List<String> output = new ArrayList<>();
        Stack<Character> ops = new Stack<>();

        expr = expr.replaceAll(" ", "");

        for(int i=0;i<expr.length();i++) {

            char c = expr.charAt(i);

            if(Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                while(i<expr.length() &&
                        (Character.isDigit(expr.charAt(i)) || expr.charAt(i)=='.')) {
                    num.append(expr.charAt(i++));
                }
                i--;
                output.add(num.toString());
            }

            else if(c=='(')
                ops.push(c);

            else if(c==')') {
                while(ops.peek()!='(')
                    output.add(String.valueOf(ops.pop()));
                ops.pop();
            }

            else {
                while(!ops.isEmpty() &&
                        precedence(ops.peek()) >= precedence(c))
                    output.add(String.valueOf(ops.pop()));
                ops.push(c);
            }
        }

        while(!ops.isEmpty())
            output.add(String.valueOf(ops.pop()));

        return output;
    }

    private int precedence(char op) {
        if(op=='+'||op=='-') return 1;
        if(op=='*'||op=='/') return 2;
        return 0;
    }

    private double evaluatePostfix(List<String> tokens) {

        Stack<Double> stack = new Stack<>();

        for(String t : tokens) {

            if(t.matches("[+\\-*/]")) {
                double b = stack.pop();
                double a = stack.pop();

                switch(t.charAt(0)) {
                    case '+': stack.push(a+b); break;
                    case '-': stack.push(a-b); break;
                    case '*': stack.push(a*b); break;
                    case '/': stack.push(a/b); break;
                }
            }
            else {
                stack.push(Double.parseDouble(t));
            }
        }

        return stack.pop();
    }
}


// =============================
// Response Generator
// =============================
class ResponseEngine {

    Random rand = new Random();
    MathSolver solver = new MathSolver();

    String[] jokes = {
        "Why do programmers prefer dark mode? Less light bugs.",
        "AI joke: I would tell you a joke, but I'm still training.",
        "There are 10 types of people: those who understand binary."
    };

    public String generate(Intent intent, String input, Context ctx) {

        switch(intent) {

            case GREETING:
                return "Hello " + ctx.userName;

            case NAME_SET:
                ctx.userName = input.substring(11).trim();
                return "Memory updated.";

            case NAME_QUERY:
                return "You are " + ctx.userName;

            case TIME:
                return LocalDateTime.now().toString();

            case JOKE:
                return jokes[rand.nextInt(jokes.length)];

            case LEARN:
                // format: learn question=response
                try{
                    String data = input.substring(6);
                    String[] parts = data.split("=");
                    ctx.learned.put(parts[0].trim(), parts[1].trim());
                    return "Learned new response.";
                } catch(Exception e){
                    return "Learning format invalid.";
                }

            case MATH:
                try {
                    double r = solver.eval(input);
                    return "Result = " + r;
                } catch(Exception e) {
                    return "Math error.";
                }

            case UNKNOWN:
                for(String key : ctx.learned.keySet())
                    if(input.contains(key))
                        return ctx.learned.get(key);

                return fallback();
        }

        return fallback();
    }

    private String fallback() {
        String[] responses = {
            "Interesting thought.",
            "Tell me more.",
            "Processing that idea...",
            "I am evolving my understanding."
        };
        return responses[new Random().nextInt(responses.length)];
    }
}


// =============================
// MAIN BOT
// =============================
public class AdvancedBot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Context context = new Context();
        IntentDetector detector = new IntentDetector();
        ResponseEngine engine = new ResponseEngine();

        System.out.println("🤖 AdvancedBot Online");

        while(true) {

            System.out.print("You: ");
            String input = sc.nextLine();

            if(input.equalsIgnoreCase("bye"))
                break;

            Intent intent = detector.detect(input);
            String reply = engine.generate(intent,input,context);

            System.out.println("🤖 Bot: " + reply);
        }
    }
}
