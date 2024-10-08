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

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	public ArrayList<ProductDTO> listAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ProductDTO> selectproductNo(int productNo) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateproduct(ProductDTO product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteproduct(int productNo) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int insertproduct(ProductDTO prod) {
		return productDAO.insertproduct(prod);
	}

	@Override
	public int insertProduct() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ProductDTO> selectAllList() {
		return productDAO.selectAllList();
	}
}
