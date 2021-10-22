package PokemonTrainer_06;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Trainer {
    private int numOfBadges;
    private List<Pokemon> pokes;

    public Trainer() {
        this.numOfBadges = 0;
        this.pokes = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokes.add(pokemon);
    }

    public void addBadge() {
        this.numOfBadges++;
    }

    public int pokeCollectionSize() {
        return this.pokes.size();
    }

    public List<Pokemon> getPokes() {
        return new ArrayList<>(this.pokes);
    }

    private UnaryOperator<Pokemon> dmgPokemon = pokemon ->
            new Pokemon(pokemon.getPokemon(), pokemon.getType(), pokemon.getHealthPoints() - 10);

    public void missingPokemonPenalty() {
        this.pokes = this.pokes.stream()
                .map(dmgPokemon)
                .filter(pokemon -> pokemon.getHealthPoints() > 0)
                .collect(Collectors.toList());
    }

    public int getNumOfBadges() {
        return numOfBadges;
    }

}
