package org.riss.bizconnect.pd.product.model.service;

import java.util.ArrayList;
import java.util.Optional;

import org.riss.bizconnect.pd.product.model.dto.ProductDTO;


public interface ProductService {
	ArrayList<ProductDTO> listAllProducts();
	Optional<ProductDTO> selectproductNo(int productNo);
	void updateproduct(ProductDTO product);
	void deleteproduct(int productNo);
	int insertProduct();
	int insertproduct(ProductDTO prod);
	
	ArrayList<ProductDTO> selectAllList();
}
