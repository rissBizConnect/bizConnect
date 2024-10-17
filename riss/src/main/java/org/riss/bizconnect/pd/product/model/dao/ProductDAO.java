package org.riss.bizconnect.pd.product.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.pd.product.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("productDAO")
public class ProductDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public ArrayList<ProductDTO> selectAllList() {
		List<ProductDTO> list = sqlSessionTemplate.selectList("productMapper.select");
		return (ArrayList<ProductDTO>)list;
	}

	public int insertproduct(ProductDTO prod) {
		return sqlSessionTemplate.insert("productMapper.insertproduct", prod);
	}

	public ArrayList<ProductDTO> selectAll(String myCom) {
		List<ProductDTO> list = sqlSessionTemplate.selectList("productMapper.selectAll", myCom);
		return (ArrayList<ProductDTO>)list;
	}

	public int insertProduct(ProductDTO productDTO) {
		return sqlSessionTemplate.insert("productMapper.insertProduct", productDTO);
	}

	public int deleteproduct(ProductDTO product) {
		return sqlSessionTemplate.delete("productMapper.deleteproduct", product);
	}

	public int update(ProductDTO product) {
		return sqlSessionTemplate.update("productMapper.update", product);
	}

	public ProductDTO selectProductOne(ProductDTO product) {
		return sqlSessionTemplate.selectOne("productMapper.selectProductOne", product);
	}
}
