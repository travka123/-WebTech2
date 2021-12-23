package bsuir.webtech.lab2.presentation.simpleViewModels;

import bsuir.webtech.lab2.business.ProductService;
import bsuir.webtech.lab2.business.products.CoffeeMachine;
import bsuir.webtech.lab2.business.products.Fridge;
import bsuir.webtech.lab2.business.products.Kettle;
import bsuir.webtech.lab2.business.products.TV;
import bsuir.webtech.lab2.presentation.ConsoleViewModel;

public class StartViewModel extends ConsoleViewModel {

    private final ProductService productService;

    public StartViewModel(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String getText() {
        return "1. Все товары.\n2. Холодильники.\n3. Чайники.\n4. Кофемашины.\n5. Телевизоры.\n0. Выход.\n";
    }

    @Override
    public ConsoleViewModel processInput(String input) {
        int selected = Integer.parseInt(input);
        return switch (selected) {
            case 1 -> new ProductListViewModel(this, productService);
            case 2 -> new ProductListViewModel(this, productService, Fridge.class);
            case 3 -> new ProductListViewModel(this, productService, Kettle.class);
            case 4 -> new ProductListViewModel(this, productService, CoffeeMachine.class);
            case 5 -> new ProductListViewModel(this, productService, TV.class);
            case 0 -> null;
            default -> throw new IllegalArgumentException();
        };
    }
}
