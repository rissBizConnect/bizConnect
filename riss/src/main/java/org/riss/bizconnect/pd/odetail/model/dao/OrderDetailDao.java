package org.riss.bizconnect.pd.odetail.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.pd.odetail.model.dto.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("orderDetailDao")
public class OrderDetailDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public int selectNxDiv(String myCom) {
		return sqlSessionTemplate.selectOne("orderDetailMapper.selectNxDiv", myCom);
	}

	public int insertOrderDetail(OrderDetail orderDetail) {
		return sqlSessionTemplate.insert("orderDetailMapper.insertOrderDetail", orderDetail);
	}

	public int deleteAll(OrderDetail orderDetail) {
		return sqlSessionTemplate.delete("orderDetailMapper.deleteAll", orderDetail);
	}

	public ArrayList<OrderDetail> selectDivList(OrderDetail orderD) {
		List<OrderDetail> list = sqlSessionTemplate.selectList("orderDetailMapper.selectDivList", orderD);
		return (ArrayList<OrderDetail>)list;
	}

	public int updateOrderDetail(OrderDetail orderDetail) {
		return sqlSessionTemplate.update("orderDetailMapper.updateOrderDetail", orderDetail);
	}

}
