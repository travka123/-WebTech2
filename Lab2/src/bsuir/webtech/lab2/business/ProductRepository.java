package bsuir.webtech.lab2.business;

import bsuir.webtech.lab2.business.products.Product;

import java.util.List;
import java.util.function.Predicate;

public abstract class ProductRepository {
    public abstract List<Product> getProducts();

    public abstract List<Product> getProducts(Predicate<Product> predicate);
}
