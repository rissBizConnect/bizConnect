package org.riss.bizconnect.pd.odetail.model.service;

import java.util.ArrayList;

import org.riss.bizconnect.pd.odetail.model.dao.OrderDetailDao;
import org.riss.bizconnect.pd.odetail.model.dto.OrderDetail;
import org.riss.bizconnect.pd.order.model.dao.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailDao orderDetailDao;

	@Override
	public int selectNxNo(String myCom) {
		return orderDetailDao.selectNxDiv(myCom);
	}

	@Override
	public int insertOrderDetail(OrderDetail orderDetail) {
		return orderDetailDao.insertOrderDetail(orderDetail);
	}

	@Override
	public int deleteAll(OrderDetail orderDetail) {
		return orderDetailDao.deleteAll(orderDetail);
	}

	@Override
	public ArrayList<OrderDetail> selectDivList(OrderDetail orderD) {
		return orderDetailDao.selectDivList(orderD);
	}

	@Override
	public int updateOrderDetail(OrderDetail orderDetail) {
		return orderDetailDao.updateOrderDetail(orderDetail);
	}


}
