package bsuir.webtech.lab2.business;

import bsuir.webtech.lab2.business.products.Product;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository productRepository) {
        repository = productRepository;
    }

    public List<Product> getProducts() {
        return repository.getProducts();
    }

    public List<Product> getProducts(Predicate<Product> predicate) {
        return repository.getProducts(predicate);
    }
}
