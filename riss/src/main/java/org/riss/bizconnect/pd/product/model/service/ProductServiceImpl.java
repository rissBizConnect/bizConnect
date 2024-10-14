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
	
	// 재고 상태 (경고 임계치)
	@Override
	public ArrayList<ProductDTO> filterProductStockStatus(String status) {
		ArrayList<ProductDTO> allProducts = productDAO.selectAllList(); // 모든 제품 조회
		ArrayList<ProductDTO> filteredProducts = new ArrayList<>(); // 필터링된 제품 리스트
		
		// 각 제품의 재고 상태 확인 -> 필터링
		for (ProductDTO product : allProducts) {
			String stockStatus = getProductStockStatus(product); // 재고 상태 계산
			
			if (stockStatus.equals(status)) {
				filteredProducts.add(product);
			}
		}
		return filteredProducts; // 필터링된 제품 반환
	}

	// 재고 상태 계산 메서드
	private String getProductStockStatus(ProductDTO product) {
		if (product.getProductcStock() <= product.getProductStockWarn()) {
			return "부족";
		} else {
			return "안전";
		}
	}
	
	@Override
	public int getNextProductNum(String orderType) {
		return productDAO.getMaxProductNum(orderType) + 1;
	}
	
	public String generProductNo(String orderType) {
		if (orderType == null) {
			throw new IllegalArgumentException("OrderType is required");
		}
	    String prefix = orderType.equals("P") ? "P" : "O";
	    int nextNumber = getNextProductNum(orderType);
	    return prefix + String.format("%03d", nextNumber); 
	}
}
