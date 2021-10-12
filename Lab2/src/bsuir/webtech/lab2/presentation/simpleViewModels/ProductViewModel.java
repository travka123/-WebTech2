package bsuir.webtech.lab2.presentation.simpleViewModels;

import bsuir.webtech.lab2.business.products.Product;
import bsuir.webtech.lab2.presentation.ConsoleViewModel;

import java.util.Objects;

public class ProductViewModel extends ConsoleViewModel {

    private final ConsoleViewModel oldViewModel;
    private final Product product;

    public ProductViewModel(ConsoleViewModel oldViewModel, Product product) {
        this.oldViewModel = oldViewModel;
        this.product = product;
    }

    @Override
    public String getText() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s\n", product.getName()));
        stringBuilder.append(String.format("Цена: %s рублей\n", product.getPrice()));
        stringBuilder.append(String.format("\n%s\n\n", product.getDescription()));
        stringBuilder.append("Характеристики товара:\n");
        product.getPropertiesText().forEach(
                (String key, String val) -> stringBuilder.append(String.format("%50s%50s\n", key, val))
        );
        stringBuilder.append("0. Выход.\n");
        return stringBuilder.toString();
    }

    @Override
    public ConsoleViewModel processInput(String input) {
        if (Objects.equals(input, "0")) {
            return oldViewModel;
        }
        throw new IllegalArgumentException();
    }
}
