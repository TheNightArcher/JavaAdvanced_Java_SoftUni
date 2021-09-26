import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String,Map<String,Double>> shopProducts = new TreeMap<>();

        while (!input.equals("Revision")){
            String [] commandDate = input.split(", ");
            String markets = commandDate[0];
            String products = commandDate[1];
            double prices = Double.parseDouble(commandDate[2]);

            shopProducts.putIfAbsent(markets,new LinkedHashMap<>());
            Map<String,Double> product = shopProducts.get(markets);
            product.putIfAbsent(products,prices);

            input = scanner.nextLine();
        }

        shopProducts.forEach((k,v) ->{
            System.out.printf("%s->%n",k);
            //Product: apple, Price: 1.2
            for (var product: v.entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n",product.getKey(),product.getValue());
            }
        });
    }
}
