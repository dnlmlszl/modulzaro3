package OOProgram.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MusicRecommendation {

    private final Random random = new Random();
    private static final Map<String, String[]> musicDatabase = new HashMap<>();

    static {
        musicDatabase.put("happy", new String[]{
                "Happy - Pharrell Williams",
                "Walking on Sunshine - Katrina and the Waves",
                "Good Vibrations - The Beach Boys",
                "Uptown Funk - Mark Ronson ft. Bruno Mars",
                "Best Day of My Life - American Authors"
        });
        musicDatabase.put("sad", new String[]{
                "Someone Like You - Adele",
                "Fix You - Coldplay",
                "The Night We Met - Lord Huron",
                "Hurt - Johnny Cash",
                "Tears in Heaven - Eric Clapton"
        });
        musicDatabase.put("energetic", new String[]{
                "Eye of the Tiger - Survivor",
                "Can't Stop the Feeling - Justin Timberlake",
                "We Will Rock You - Queen",
                "Thunderstruck - AC/DC",
                "Lose Yourself - Eminem"
        });
        musicDatabase.put("relaxed", new String[]{
                "Weightless - Marconi Union",
                "Sunset Lover - Petit Biscuit",
                "Clair de Lune - Claude Debussy",
                "Breathe Me - Sia",
                "Imagine - John Lennon"
        });
    }

    public String getRecommendation(String mood) {
        String[] recommendations = musicDatabase.getOrDefault(mood.toLowerCase(), new String[] {"Ehhez a hangulathoz nem tudunk zenét ajánlani."});

        return recommendations[random.nextInt(recommendations.length)];
    }
}
