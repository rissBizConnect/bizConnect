package org.riss.bizconnect.pd.order.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.pd.order.model.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("orderDAO")
public class OrderDAO {
    
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public ArrayList<OrderDTO> listAllOrders() {
		List<OrderDTO> list = sqlSessionTemplate.selectList("orderMapper.select");
		return (ArrayList<OrderDTO>)list;
	}
}