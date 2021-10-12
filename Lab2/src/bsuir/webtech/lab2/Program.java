package bsuir.webtech.lab2;

import bsuir.webtech.lab2.business.ProductService;
import bsuir.webtech.lab2.persistence.TestProductDao;
import bsuir.webtech.lab2.presentation.ConsoleView;
import bsuir.webtech.lab2.presentation.simpleViewModels.StartViewModel;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        new ConsoleView(new StartViewModel(new ProductService(new TestProductDao()))).show();
    }
}
