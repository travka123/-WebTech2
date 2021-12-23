package bsuir.webtech.lab2.business;

import bsuir.webtech.lab2.business.products.Product;

import java.util.List;
import java.util.function.Predicate;

public abstract class ProductRepository {

    /**
     * Get all products from data storage
     * @return
     */
    public abstract List<Product> getProducts();

    /**
     * Get all products from data storage which satisfy predicate
     * @param predicate
     * @return
     */
    public abstract List<Product> getProducts(Predicate<Product> predicate);

    /**
     * Save products to data storage
     * @param products
     */
    public abstract void saveProducts(List<Product> products);
}
