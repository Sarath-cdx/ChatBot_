import java.util.Random;

class JokesModule {

    String[] jokes = {
        "Why do programmers hate nature? Too many bugs.",
        "I told my computer I needed a break — it froze.",
        "Why Java developers wear glasses? Because they don't C#.",
        "Debugging: Removing bugs you created yesterday."
    };

    boolean handles(String input) {
        return input.contains("joke");
    }

    String respond(String input) {
        return jokes[new Random().nextInt(jokes.length)];
    }
}
