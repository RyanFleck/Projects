package com.rcf.primefaces.lib.linkedin.dao;

import java.util.Collection;

/**
 * From the LinkedIn Learning course 'Learning PrimeFaces'
 * @author Eyitayo Koleoso
 */
public interface ProductDAO<M> {

    M getProduct(long productId);

    <I> M getProduct(I productId);
    
    Collection<M> getProducts();

}
