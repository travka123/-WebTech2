package bsuir.webtech.lab2.persistence;

import bsuir.webtech.lab2.business.ProductRepository;
import bsuir.webtech.lab2.business.products.Product;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class XMLProductDao extends ProductRepository {

    private final String filePath;

    public XMLProductDao(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        try {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filePath)));
            while (true) {
                try {
                    Product product = (Product) decoder.readObject();
                    products.add(product);
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }
        } catch (FileNotFoundException ignored) {

        }
        return products;
    }

    @Override
    public List<Product> getProducts(Predicate<Product> predicate) {
        List<Product> products = new ArrayList<>();
        try {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filePath)));
            while (true) {
                try {
                    Product product = (Product) decoder.readObject();
                    if (predicate.test(product)) {
                        products.add(product);
                    }
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }
        } catch (FileNotFoundException ignored) {

        }
        return products;
    }

    @Override
    public void saveProducts(List<Product> products) {
        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filePath)));
            for (Product product : products) {
                encoder.writeObject(product);
            }
            encoder.close();
        } catch (FileNotFoundException ignored) {

        }
    }
}
