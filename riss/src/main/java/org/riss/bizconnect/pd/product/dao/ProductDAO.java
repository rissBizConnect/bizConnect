package org.riss.bizconnect.pd.product.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.pd.product.dto.ProductDTO;
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

}
