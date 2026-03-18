
class mathModule {

    // Detect if input is math related
    boolean handles(String input) {
        input = input.toLowerCase();
        return input.matches(".*\\d+[\\+\\-*/]\\d+.*")
                || input.contains("sqrt")
                || input.contains("pow")
                || input.contains("sin")
                || input.contains("cos");
    }

    // Respond with answer
    String respond(String input) {

        input = input.toLowerCase();

        try {

            // ---- SQRT ----
            if (input.contains("sqrt")) {
                double num = extractNum(input);
                return "√" + num + " = " + Math.sqrt(num);
            }

            // ---- POWER ----
            if (input.contains("pow")) {
                double[] nums = extractTwo(input);
                return nums[0] + "^" + nums[1] + " = " +
                        Math.pow(nums[0], nums[1]);
            }

            // ---- SIN ----
            if (input.contains("sin")) {
                double num = extractNum(input);
                return "sin(" + num + ") = " +
                        Math.sin(Math.toRadians(num));
            }

            // ---- COS ----
            if (input.contains("cos")) {
                double num = extractNum(input);
                return "cos(" + num + ") = " +
                        Math.cos(Math.toRadians(num));
            }

            // ---- BASIC OPERATIONS ----
            String cleaned = input.replaceAll("[^0-9+\\-*/.]", "");
            String[] tokens =
                    cleaned.split("(?=[+\\-*/])|(?<=[+\\-*/])");

            if (tokens.length >= 3) {

                double a = Double.parseDouble(tokens[0]);
                char op = tokens[1].charAt(0);
                double b = Double.parseDouble(tokens[2]);

                switch (op) {
                    case '+':
                        return a + " + " + b + " = " + (a + b);

                    case '-':
                        return a + " - " + b + " = " + (a - b);

                    case '*':
                        return a + " × " + b + " = " + (a * b);

                    case '/':
                        if (b == 0)
                            return "Cannot divide by zero";
                        return a + " ÷ " + b + " = " + (a / b);

                    default:
                        return "Unknown operation";
                }
            }

        } catch (Exception e) {
            return "Math error 🤖 Try: 10+5, sqrt(16)";
        }

        return "Ask math like: 12*3";
    }

    // Extract single number
    double extractNum(String s) {
        return Double.parseDouble(
                s.replaceAll("[^0-9.-]", "")
        );
    }

    // Extract two numbers
    double[] extractTwo(String s) {
        String[] parts =
                s.replaceAll("[^0-9.,-]", "")
                        .split(",");

        return new double[]{
                Double.parseDouble(parts[0]),
                Double.parseDouble(parts[1])
        };
    }
}

