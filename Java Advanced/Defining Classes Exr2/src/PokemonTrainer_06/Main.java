package PokemonTrainer_06;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String numberOfTrainers = scanner.nextLine();

        Map<String, List<Pokemon>> trainers = new LinkedHashMap<>();
        while (!numberOfTrainers.equals("Tournament")) {

            String[] input = numberOfTrainers.split("\\s+");
            String trainerName = input[0];
            String pokemonName = input[1];
            String type = input[2];
            int hp = Integer.parseInt(input[3]);

            Pokemon pokemon = new Pokemon(pokemonName,type,hp);
            trainers.putIfAbsent(trainerName,new ArrayList<>());
            List<Pokemon> pokes = trainers.get(trainerName);
            pokes.add(pokemon);
            numberOfTrainers = scanner.nextLine();
        }

        String tournaments = scanner.nextLine();
        while (!tournaments.equals("End")){
            Trainer trainer = new Trainer(trainers.toString());
            if (tournaments.equals("Fire")) {
                trainers.forEach((trainerName, pokemons) -> {
                    for (var poke: pokemons ) {
                        if (poke.getType().equals("Fire")){
                            trainer.addBadge(1);

                        }
                    }
                });
            }

            tournaments = scanner.nextLine();
        }
        System.out.println();
    }
}
