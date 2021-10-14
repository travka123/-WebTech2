package bsuir.webtech.lab2;

import bsuir.webtech.lab2.business.ProductService;
import bsuir.webtech.lab2.persistence.StubProductDao;
import bsuir.webtech.lab2.persistence.XMLProductDao;
import bsuir.webtech.lab2.presentation.ConsoleView;
import bsuir.webtech.lab2.presentation.simpleViewModels.StartViewModel;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {

        //Create Products.xml with all test products
        new XMLProductDao("Products.xml").saveProducts(new StubProductDao().getProducts());

        //Composition Root
        new ConsoleView(new StartViewModel(new ProductService(new XMLProductDao("Products.xml")))).show();
    }
}
