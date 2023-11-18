
import java.util.*;

class Product {
    String name;
    double unitPrice;
    double gst;
    int quantity;

    public Product(String name, double unitPrice, double gst, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.gst = gst;
        this.quantity = quantity;
    }

    public double calDiscountPrice() {
        double discountPrice = unitPrice * quantity;
        if (unitPrice >= 500) {
            discountPrice *= 0.95;
        }
        return discountPrice;
    }

    public double calGSTAmount() {
        return (unitPrice * gst / 100) * quantity;
    }
}

public class Shopkeeper {
    public static void main(String[] args) {
        List<Product> basket = new ArrayList<>();
        basket.add(new Product("Leather Wallet", 1100, 18, 1));
        basket.add(new Product("Umbrella", 900, 12, 4));
        basket.add(new Product("Cigarette", 200, 28, 3));
        basket.add(new Product("Honey", 100, 0, 2));

        Product maxGstPro = productWithMaxGst(basket);
        System.out.println("GST Amount is maximum for the product: " + maxGstPro.name);

        double totalAmountToPay = calAmountToPay(basket);
        System.out.println("Amount suppossed to be paid to the shopkeeper: Rs" + totalAmountToPay);
    }

    private static Product productWithMaxGst(List<Product> basket) {
        double maxGSTAmount = 0;
        Product maxGstPro = null;

        for (Product product : basket) {
            double gstAmt = product.calGSTAmount();
            if (gstAmt > maxGSTAmount) {
                maxGSTAmount = gstAmt;
                maxGstPro = product;
            }
        }

        return maxGstPro;
    }

    private static double calAmountToPay(List<Product> basket) {
        double totalAmt = 0;

        for (Product product : basket) {
            totalAmt += product.calDiscountPrice() + product.calGSTAmount();
        }

        return totalAmt;
    }
}
