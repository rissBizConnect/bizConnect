package org.riss.bizconnect.pd.product.model.service;

import java.util.ArrayList;
import java.util.Optional;

import org.riss.bizconnect.pd.product.model.dto.ProductDTO;


public interface ProductService {
	ArrayList<ProductDTO> selectAll(String myCom);

	int insertProduct(ProductDTO productDTO);

	int deleteproduct(ProductDTO product);

	int update(ProductDTO product);

	ProductDTO selectProductOne(ProductDTO product);

}
