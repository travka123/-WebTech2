package bsuir.webtech.lab2.presentation.simpleViewModels;

import bsuir.webtech.lab2.business.products.Product;
import bsuir.webtech.lab2.presentation.ConsoleViewModel;

import java.util.Comparator;
import java.util.List;

public class SortSelectViewModel extends ConsoleViewModel {

    private final ConsoleViewModel oldViewModel;
    private final List<Product> listForSort;

    public SortSelectViewModel(ConsoleViewModel oldViewModel, List<Product> listForSort) {
        this.listForSort = listForSort;
        this.oldViewModel = oldViewModel;
    }

    @Override
    public String getText() {
        return "Упорядочить по:\n1. Возрастанию цены.\n2. Убыванию цены.\n0. Назад.\n";
    }

    @Override
    public ConsoleViewModel processInput(String input) {
        switch (input) {
            case "1":
                listForSort.sort(Comparator.comparing(Product::getPrice));
                break;

            case "2":
                listForSort.sort(Comparator.comparing(Product::getPrice).reversed());
                break;

            case "0":
                break;

            default:
                throw new IllegalArgumentException();
        }
        return oldViewModel;
    }
}
