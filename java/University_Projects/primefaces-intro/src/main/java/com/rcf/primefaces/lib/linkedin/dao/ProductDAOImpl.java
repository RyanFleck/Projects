package com.rcf.primefaces.lib.linkedin.dao;

import com.rcf.primefaces.lib.linkedin.dto.Product;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * From the LinkedIn Learning course 'Learning PrimeFaces'
 * 
 * @author Eyitayo Koleoso
 */
@Singleton
@Named("productDao")
public class ProductDAOImpl implements ProductDAO<Product> {

    private List<Product> products;

    @PostConstruct
    public void init() {
        productPrep();
    }

    @Override
    public Product getProduct(long productId) {
        Product result = null;
        for (Product product : products) {
            if (product.getProductId() == productId) {
                result = product;
            }
        }
        return result;
    }

    @Override

    public Product getProduct(Object productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    private void productPrep() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        products = new LinkedList<>();
        InputStream input = classLoader.getResourceAsStream("products.csv");
        InputStreamReader reader = new InputStreamReader(input, Charset.forName("utf-8"));
        BufferedReader bReader = new BufferedReader(reader);
        bReader.lines().forEach(line -> {
            String[] fields = line.split("\\|"); 
            Product aNewProduct = new Product();
            aNewProduct.setSKU(fields[0]);
            aNewProduct.setProductId(Long.parseLong(fields[1]));
            aNewProduct.setImages(Arrays.asList(fields[2].split("\\,")));
            aNewProduct.setProductDesc(fields[3]);
            aNewProduct.setProductTitle(fields[4]);
            aNewProduct.setPricePer(new BigDecimal(fields[5]));
            products.add(aNewProduct);
        });
    }
}
