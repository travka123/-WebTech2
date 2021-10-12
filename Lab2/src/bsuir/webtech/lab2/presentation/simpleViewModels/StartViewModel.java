package bsuir.webtech.lab2.presentation.simpleViewModels;

import bsuir.webtech.lab2.business.ProductService;
import bsuir.webtech.lab2.business.products.CoffeeMachine;
import bsuir.webtech.lab2.business.products.Fridge;
import bsuir.webtech.lab2.presentation.ConsoleViewModel;

public class StartViewModel extends ConsoleViewModel {

    private final ProductService productService;

    public StartViewModel(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String getText() {
        return "1. Все товары.\n2. Холодильники.\n3. Чайники.\n4. Кофемашины.\n5. Телевизоры.\n6. Утюги.\n0. Выход.\n";
    }

    @Override
    public ConsoleViewModel processInput(String input) {
        int selected = Integer.parseInt(input);
        return switch (selected) {
            case 1 -> new ProductListViewModel(this, productService);
            case 2 -> new ProductListViewModel(this, productService, Fridge.class);
            case 3 -> null;
            case 4 -> new ProductListViewModel(this, productService, CoffeeMachine.class);
            case 5 -> null;
            case 6 -> null;
            case 0 -> null;
            default -> throw new IllegalArgumentException();
        };
    }
}
