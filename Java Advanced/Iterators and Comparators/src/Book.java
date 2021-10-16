import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;


    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.setAuthors(authors);
    }

    private void setAuthors(String... authors) {
        this.authors = Arrays.stream(authors).collect(Collectors.toList());
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }


    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Book other) {
        int compered = this.title.compareTo(other.title);

        if (compered == 0){
            compered = Integer.compare(this.year,other.year);
        }

        return compered;
    }
}
