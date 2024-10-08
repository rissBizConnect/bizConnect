package org.riss.bizconnect.pd.order.model.service;

import org.riss.bizconnect.pd.order.model.dto.OrderDTO;
import org.riss.bizconnect.pd.product.model.dto.ProductDTO;

import java.util.ArrayList;
import java.util.Optional;

public interface OrderService {
	ArrayList<OrderDTO> listAllOrders();
	Optional<OrderDTO> selectorderNo(String orderNo);
	void addorder(OrderDTO order);
	void modifyorder(OrderDTO order);
	void removeorder(String orderNo);
	OrderDTO getorder(String orderNo);
    
}