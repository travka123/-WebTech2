package bsuir.webtech.lab2.persistence;

import bsuir.webtech.lab2.business.ProductRepository;
import bsuir.webtech.lab2.business.products.*;

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
                    118),

            new Kettle("Электрочайник Scarlett SC-EK27G73",
                    42.20,
                    2020,
                    "2000 Вт, объем 1.7 л, подсветка, цвет нержавеющая сталь/черный",
                    1.7,
                    0.5,
                    0.7),

            new Kettle("Электрочайник KitchenAid Artisan 5KEK1522EIB",
                    811.44,
                    2014,
                    "2400 Вт, объем 1.5 л, терморегулятор, цвет синий",
                    1.5,
                    0.25,
                    2),

            new TV("Телевизор Витязь 24LH1103",
                    299,
                    2019,
                    "24\" 1366x768 (HD), матрица VA, частота матрицы 60 Гц, Smart TV (Android), Wi-Fi",
                    24,
                    "1366x768 (HD)",
                    60),

            new TV("OLED телевизор LG OLED77G1RLA",
                    14669.00,
                    2021,
                    "LG OLED evo устанавливает новый стандарт. Мы усовершенствовали OLED-панель нового поколения,\n" +
                            "добавив дополнительный слой и улучшив светящиеся элементы. Эти новшества оптимизируют структуру панели,\n" +
                            "улучшая длину световых волн и повышая эффективность.",
                    77,
                    "3840x2160 (4K UHD)",
                    120)
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
