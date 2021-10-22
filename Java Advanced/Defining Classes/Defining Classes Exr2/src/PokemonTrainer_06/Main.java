package PokemonTrainer_06;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String numberOfTrainers = scanner.nextLine();

        Map<String, Trainer> trainers = new LinkedHashMap<>();
        while (!numberOfTrainers.equals("Tournament")) {

            String[] input = numberOfTrainers.split("\\s+");
            String trainerName = input[0];
            String pokemonName = input[1];
            String type = input[2];
            int hp = Integer.parseInt(input[3]);

            // We add here ours Classes.
            Pokemon pokemon = new Pokemon(pokemonName, type, hp);

            trainers.putIfAbsent(trainerName, new Trainer());
            trainers.get(trainerName).addPokemon(pokemon);

            numberOfTrainers = scanner.nextLine();
        }

        String tournaments = scanner.nextLine();
        while (!tournaments.equals("End")) {

            String currentElement = tournaments;

            for (Map.Entry<String, Trainer> trainer : trainers.entrySet()) {
                if (trainer.getValue().pokeCollectionSize() > 0) {
                    boolean havePokemon = false;

                    for (Pokemon pokemon : trainer.getValue().getPokes()) {
                        if (pokemon.getType().equals(currentElement)) {
                            havePokemon = true;
                            trainer.getValue().addBadge();
                            break;
                        }
                    }
                    if (!havePokemon) {
                        trainer.getValue().missingPokemonPenalty();
                    }
                }
            }
            tournaments = scanner.nextLine();
        }
        trainers.entrySet().stream()
                .sorted((p1, p2) -> Integer.compare(p2.getValue().getNumOfBadges(), p1.getValue().getNumOfBadges()))
                .forEach(t -> System.out.printf("%s %s %s%n",
                        t.getKey(), t.getValue().getNumOfBadges(), t.getValue().pokeCollectionSize()));
    }
}
