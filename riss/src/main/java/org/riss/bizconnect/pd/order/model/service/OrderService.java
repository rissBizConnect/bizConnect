package org.riss.bizconnect.pd.order.model.service;

import java.util.ArrayList;

import org.riss.bizconnect.pd.odetail.model.dto.OrderDetail;
import org.riss.bizconnect.pd.order.model.dto.Order;

public interface OrderService {

	int selectNxDiv(String myCom);

	int selectNxNo(String myCom);

	int insertOrder(Order order);

	ArrayList<Order> selectAll(String myCom);

	int deleteAll(Order order);

	ArrayList<Order> selectDivList(Order order);

	ArrayList<Order> selectAllP(String myCom);

	int updateOrder(Order order);


    
}