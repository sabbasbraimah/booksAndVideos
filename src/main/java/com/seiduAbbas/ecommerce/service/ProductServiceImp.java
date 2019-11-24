package com.seiduAbbas.ecommerce.service;

import com.seiduAbbas.ecommerce.command.ProductCommand;
import com.seiduAbbas.ecommerce.converter.ProductCommandToProduct;
import com.seiduAbbas.ecommerce.converter.ProductToProductCommand;
import com.seiduAbbas.ecommerce.domain.Product;
import com.seiduAbbas.ecommerce.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class ProductServiceImp implements ProductService {

    private final ProductCommandToProduct productCommandToProduct;
    private final ProductToProductCommand producToProductCommand;
    private final ProductRepository productRepository;

    public ProductServiceImp(ProductCommandToProduct productCommandToProduct, ProductToProductCommand productProductCommand, ProductRepository productRepository) {
        this.productCommandToProduct = productCommandToProduct;
        this.producToProductCommand = productProductCommand;
        this.productRepository = productRepository;
    }
    @Override
    public Set<Product> getProducts() {
        log.debug("I'm in the service");
        Set<Product> productSet = new HashSet<>();
        productRepository.findAll().iterator().forEachRemaining(productSet::add);
        return productSet;
    }

    @Override
    public Product findById(Long id)  {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (! optionalProduct.isPresent()){
            throw  new RuntimeException("");
        }
        return    optionalProduct.get();
    }

    @Override
    @Transactional
    public ProductCommand findCommandById(Long l) {
        return producToProductCommand.convert(findById(l));
    }

    @Override
    public ProductCommand saveProductCommand(ProductCommand productCommand) {
        Product detachedProduct = productCommandToProduct.convert(productCommand);
        Product savedProduct = productRepository.save(detachedProduct);
        log.debug("Saved ProductId:" + savedProduct.getId());
        return producToProductCommand.convert(savedProduct);
    }
/**
    @Override
    public ProductCommand findProductCommandById(Long id) {
        return   productProductCommand.convert(getProductById(id));

    }

    @Override
    @Transactional
    public ProductCommand createNewProduct(ProductCommand productCommand) {
        Product product = productCommandToProduct.convert(productCommand);
        Product savedProduct = productRepository.save(product);
        ProductCommand returnCommand = productProductCommand.convert(savedProduct);
        return returnCommand;
    }
    **/
}
