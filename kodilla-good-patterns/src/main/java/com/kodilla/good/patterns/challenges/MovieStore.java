package com.kodilla.good.patterns.challenges;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class MovieStore {
    public Map<String, List<String>> getMovies() {

        List<String> ironManTranslations = new ArrayList<>();
        ironManTranslations.add("Żelazny Człowiek");
        ironManTranslations.add("Iron Man");

        List<String> avengersTranslations = new ArrayList<>();
        avengersTranslations.add("Mściciele");
        avengersTranslations.add("Avengers");

        List<String> flashTranslations = new ArrayList<>();
        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");

        Map<String, List<String>> moviesTitlesWithTranslations = new HashMap<>();
        moviesTitlesWithTranslations.put("IM", ironManTranslations);
        moviesTitlesWithTranslations.put("AV", avengersTranslations);
        moviesTitlesWithTranslations.put("FL", flashTranslations);

        return moviesTitlesWithTranslations;
    }

    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        String stringOfMovies = movieStore.getMovies().entrySet().stream()
                .flatMap(stringListEntry -> stringListEntry.getValue().stream())
                .collect(Collectors.joining("!"));
        System.out.println(stringOfMovies);
    }
}
