package bsuir.webtech.lab2.presentation.simpleViewModels;

import bsuir.webtech.lab2.business.ProductService;
import bsuir.webtech.lab2.business.products.Product;
import bsuir.webtech.lab2.presentation.ConsoleViewModel;

import java.util.List;

public class ProductListViewModel extends ConsoleViewModel {

    private final ConsoleViewModel oldViewModel;
    private final List<Product> productList;

    public ProductListViewModel(ConsoleViewModel oldViewModel, ProductService productService) {
        this.oldViewModel = oldViewModel;
        productList = productService.getProducts();
    }

    public ProductListViewModel(ConsoleViewModel oldViewModel, ProductService productService,
                                Class<? extends Product> productClass) {
        this.oldViewModel = oldViewModel;
        productList = productService.getProducts((p) -> p.getClass() == productClass);
    }

    @Override
    public String getText() {
        int index = 2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1. Сортировать по ...\n");
        stringBuilder.append(String.format("  №%62s %25s\n", "Название", "Цена"));
        for (Product product : productList) {
            stringBuilder.append(String.format("%3d. %60s %20.2f руб.\n", index, product.getName(), product.getPrice()));
            index++;
        }
        stringBuilder.append("0. Выход.\n");
        return stringBuilder.toString();
    }

    @Override
    public ConsoleViewModel processInput(String input) {
        int selected = Integer.parseInt(input);

        if (selected == 0) {
            return oldViewModel;
        }

        if (selected == 1) {
            return new SortSelectViewModel(this, productList);
        }

        selected -= 2;
        if (selected < productList.size()) {
            return new ProductViewModel(this, productList.get(selected));
        }

        throw new IllegalArgumentException();
    }
}
