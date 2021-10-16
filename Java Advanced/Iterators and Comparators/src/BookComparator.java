import java.util.Comparator;

public class BookComparator implements Comparator<Book> {


    @Override
    public int compare(Book f, Book s) {
       int compered= f.getTitle().compareTo(s.getTitle());

       if (compered == 0){
           compered = Integer.compare(f.getYear(), s.getYear());
       }

       return compered;
    }
}
