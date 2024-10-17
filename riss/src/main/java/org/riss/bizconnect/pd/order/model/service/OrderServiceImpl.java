package org.riss.bizconnect.pd.order.model.service;

import java.util.ArrayList;

import org.riss.bizconnect.pd.order.model.dao.OrderDAO;
import org.riss.bizconnect.pd.order.model.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDao;

	@Override
	public int selectNxDiv(String myCom) {
		return orderDao.selectNxDiv(myCom);
	}

	@Override
	public int selectNxNo(String myCom) {
		return orderDao.selectNxNo(myCom);
	}

	@Override
	public int insertOrder(Order order) {
		return orderDao.insertOrder(order);
	}

	@Override
	public ArrayList<Order> selectAll(String myCom) {
		return orderDao.selectAll(myCom);
	}

	@Override
	public int deleteAll(Order order) {
		return orderDao.deleteAll(order);
	}

	@Override
	public ArrayList<Order> selectDivList(Order order) {
		return orderDao.selectDivList(order);
	}

	@Override
	public ArrayList<Order> selectAllP(String myCom) {
		return orderDao.selectAllP(myCom);
	}

	@Override
	public int updateOrder(Order order) {
		return orderDao.updateOrder(order);
	}
}