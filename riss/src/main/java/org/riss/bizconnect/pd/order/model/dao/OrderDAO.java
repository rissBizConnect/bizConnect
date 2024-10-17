package org.riss.bizconnect.pd.order.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.pd.order.model.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("orderDao")
public class OrderDAO {
    
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public int selectNxDiv(String myCom) {
		return sqlSessionTemplate.selectOne("orderMapper.selectNxDiv", myCom);
	}

	public int selectNxNo(String myCom) {
		return sqlSessionTemplate.selectOne("orderMapper.selectNxNo", myCom);
	}

	public int insertOrder(Order order) {
		return sqlSessionTemplate.insert("orderMapper.insertOrder", order);
	}

	public ArrayList<Order> selectAll(String myCom) {
		List<Order> list = sqlSessionTemplate.selectList("orderMapper.selectAll", myCom);
		return (ArrayList<Order>)list;
	}

	public int deleteAll(Order order) {
		return sqlSessionTemplate.delete("orderMapper.deleteAll", order);
	}

	public ArrayList<Order> selectDivList(Order order) {
		List<Order> list = sqlSessionTemplate.selectList("orderMapper.selectDivList", order);
		return (ArrayList<Order>)list;
	}

	public ArrayList<Order> selectAllP(String myCom) {
		List<Order> list = sqlSessionTemplate.selectList("orderMapper.selectAllP", myCom);
		return (ArrayList<Order>)list;
	}

	public int updateOrder(Order order) {
		return sqlSessionTemplate.update("orderMapper.updateOrder", order);
	}
}