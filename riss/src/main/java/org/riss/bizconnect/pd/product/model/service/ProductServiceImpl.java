package org.riss.bizconnect.pd.product.model.service;

import java.util.ArrayList;
import java.util.Optional;

import org.riss.bizconnect.pd.product.model.dao.ProductDAO;
import org.riss.bizconnect.pd.product.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public ArrayList<ProductDTO> selectAll(String myCom) {
		return productDAO.selectAll(myCom);
	}

	@Override
	public int insertProduct(ProductDTO productDTO) {
		return productDAO.insertProduct(productDTO);
	}

	@Override
	public int deleteproduct(ProductDTO product) {
		return productDAO.deleteproduct(product);
	}

	@Override
	public int update(ProductDTO product) {
		return productDAO.update(product);
	}

	@Override
	public ProductDTO selectProductOne(ProductDTO product) {
		return productDAO.selectProductOne(product);
	}
}
