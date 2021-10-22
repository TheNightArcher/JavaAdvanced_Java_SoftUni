package SecondTest.groomingSalon;
import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {

        int sizeBefore = data.size();
        data.removeIf(e -> e.getName().equals(name));
        return sizeBefore != data.size();
    }

    public Pet getPet(String name, String owner) {

        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }


    public String getStatistics() {
        StringBuilder builder = new StringBuilder("The grooming salon has the following clients:" + System.lineSeparator());
        for (Pet pet : data) {
            builder.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
