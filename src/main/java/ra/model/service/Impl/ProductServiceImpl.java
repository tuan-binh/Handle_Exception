package ra.model.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Product;
import ra.model.repository.IProductRepository;
import ra.model.service.IProductService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Product getProductById(Integer productId) {

        return productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Not exist"+productId));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Integer productId, Product product) {
        productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Not exist"+productId));
        product.setProductId(productId);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Not exist"+productId));
        productRepository.deleteById(productId);
    }
}
