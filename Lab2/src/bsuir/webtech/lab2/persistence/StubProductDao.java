package bsuir.webtech.lab2.persistence;

import bsuir.webtech.lab2.business.ProductRepository;
import bsuir.webtech.lab2.business.products.CoffeeMachine;
import bsuir.webtech.lab2.business.products.Fridge;
import bsuir.webtech.lab2.business.products.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StubProductDao extends ProductRepository {

    private List<Product> products = Arrays.asList(
            new Fridge("Холодильник side by side Samsung RS62R5031B4/WT",
                    2999.00,
                    2019,
                    "полный No Frost, электронное управление, класс A+, полезный объём: 647 л (405 + 229 л),\n" +
                            "инверторный компрессор, 91.2x71.6x178 см, черный",
                    420,
                    260),

            new CoffeeMachine("Эспрессо кофемашина JURA Z10 Signature Line Dark Inox 15368",
                    10499,
                    2021,
                    "кофемашина, 1450 Вт, корпус металл, капучинатор ручной/автоматический,\nиспользуемый кофе: молотый/зерновой, цвет черный",
                    2.4,
                    280,
                    true
            ),

            new Fridge("Холодильник Samsung RB30A32N0SA/WT",
                    1272,
                    2021,
                    "полный No Frost, электронное управление, класс A+, полезный объём: 311 л (213 + 98 л),\n" +
                            "инверторный компрессор, 59.5x67.5x178 см, серебристый",
                    214,
                    118)
    );

    @Override
    public List<Product> getProducts() {
        return new ArrayList<Product>(products);
    }

    @Override
    public List<Product> getProducts(Predicate<Product> predicate) {
        List<Product> selectedProducts = new ArrayList<>();
        for (Product product : products) {
            if (predicate.test(product)) {
                selectedProducts.add(product);
            }
        }
        return selectedProducts;
    }

    @Override
    public void saveProducts(List<Product> products) {
        this.products = products;
    }
}
