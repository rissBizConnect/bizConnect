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
	
	 // Ư�� �ֹ� �������� (orderNo�� ��ȸ)
    public Optional<OrderDTO> selectorderNo(String orderNo) {
        OrderDTO order = sqlSessionTemplate.selectOne("orderMapper.selectByOrderNo", orderNo);
        return Optional.ofNullable(order);
    }

    // �ֹ� �߰�
    public void addorder(OrderDTO order) {
        sqlSessionTemplate.insert("orderMapper.insertOrder", order);
    }

    // �ֹ� ����
    public void modifyorder(OrderDTO order) {
        sqlSessionTemplate.update("orderMapper.updateOrder", order);
    }

    // �ֹ� ���� (orderNo�� ����)
    public void removeorder(String orderNo) {
        sqlSessionTemplate.delete("orderMapper.deleteOrder", orderNo);
    }

    // Ư�� �ֹ� ���� ��������
    public OrderDTO getorder(String orderNo) {
        return sqlSessionTemplate.selectOne("orderMapper.selectByOrderNo", orderNo);
    }
	
}