package ra.model.service;

import ra.model.entity.Product;

import java.util.List;

public interface IProductService {
    Product getProductById(Integer productId);
    List<Product> getAllProducts();
    Product insertProduct(Product product);
    Product updateProduct(Integer productId,Product product);
    void deleteProduct(Integer productId);
}
