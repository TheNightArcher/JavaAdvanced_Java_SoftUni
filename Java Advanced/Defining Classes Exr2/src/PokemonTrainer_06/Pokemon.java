package PokemonTrainer_06;

public class Pokemon {
    private String pokemon;
    private String type;
    private int healthPoints;

    public Pokemon(String pokemon, String type, int healthPoints) {
        this.pokemon = pokemon;
        this.type = type;
        this.healthPoints = healthPoints;
    }

    public String getType() {
        return type;
    }
}
