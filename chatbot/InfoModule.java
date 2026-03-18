// import java.time.LocalDateTime;

// class InfoModule {
//     boolean handles(String input) {
//         return input.contains("about") || input.contains("name") || input.contains("help") || input.contains("time");
//     }
    
//     String respond(String input) {
//         if (input.contains("time")) return "Time: " + LocalDateTime.now();
//         if (input.contains("name")) return "ModularBot! ☕";
//         if (input.contains("help")) return "Modules: math(10+5), joke, about, time";
//         return "Modular Java bot. Add WeatherModule next!";
//     }
// }
class InfoModule {

    boolean handles(String input) {
        return input.contains("world war")
                || input.contains("news")
                || input.contains("about");
    }

    String respond(String input) {

        if (input.contains("world war 1"))
            return "WW1 (1914–1918) involved major powers and started after Archduke Ferdinand's assassination.";

        if (input.contains("world war 2"))
            return "WW2 (1939–1945) involved Axis vs Allies. Ended after atomic bombs on Japan.";

        if (input.contains("world war"))
            return "Two major world wars shaped modern geopolitics.";

        if (input.contains("news"))
            return "I don't fetch live news yet 🙂 — but you can add API integration later!";

        return "Ask about world wars or general info.";
    }
}
