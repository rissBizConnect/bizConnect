package org.riss.bizconnect.pd.order.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.pd.order.model.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("orderDAO")
public class OrderDAO {
    
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public ArrayList<OrderDTO> listAllOrders() {
		List<OrderDTO> list = sqlSessionTemplate.selectList("orderMapper.select");
		return (ArrayList<OrderDTO>)list;
	}
	
	 // 특정 주문 가져오기 (orderNo로 조회)
    public Optional<OrderDTO> selectorderNo(String orderNo) {
        OrderDTO order = sqlSessionTemplate.selectOne("orderMapper.selectByOrderNo", orderNo);
        return Optional.ofNullable(order);
    }

    // 주문 추가
    public void addorder(OrderDTO order) {
        sqlSessionTemplate.insert("orderMapper.addOrder", order);
    }

    // 주문 수정
    public void modifyorder(OrderDTO order) {
        sqlSessionTemplate.update("orderMapper.updateOrder", order);
    }

    // 주문 삭제 (orderNo로 삭제)
    public void removeorder(String orderNo) {
        sqlSessionTemplate.delete("orderMapper.deleteOrder", orderNo);
    }

    // 특정 주문 정보 가져오기
    public OrderDTO getorder(String orderNo) {
        return sqlSessionTemplate.selectOne("orderMapper.selectByOrderNo", orderNo);
    }
	
}