package com.ethoca.sp.comm.target;

import com.ethoca.sp.comm.dto.Product;

import java.net.URI;
import java.util.List;

/**
 * Rest client class for a product.
 */
public class ProductRestClient extends AbstractRestClient<Product> {
    public ProductRestClient(String resouceUrl) {
        super(resouceUrl);
    }

    public List<Product> fetchAll() {
        URI uri = composeTargetUri(getResouceUrl());
        return getAll(uri);
    }

    public Product fetch(String productId) {
        String resouceUrl = getResouceUrl() + "/" + productId;
        URI uri = composeTargetUri(resouceUrl);
        return get(uri, Product.class);
    }
}
