package PokemonTrainer_06;

public class Trainer {
    private String name;
    private static int badges = 0;


    public Trainer(String name) {
        this.name = name;
    }

    public int addBadge(int badgesAdd) {
        badgesAdd = 0;
        badges += badgesAdd;
        return badges;
    }
}
