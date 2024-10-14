package org.riss.bizconnect.pd.order.model.service;

import java.util.ArrayList;
import java.util.Optional;

import org.riss.bizconnect.pd.order.model.dao.OrderDAO;
import org.riss.bizconnect.pd.order.model.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public void addorder(OrderDTO order) {
    };

    @Override
    public void modifyorder(OrderDTO order) {
    };

    @Override
    public void removeorder(String orderNo) {
    };


    @Override
    public OrderDTO getorder(String orderNo) {
        return null;
    }

	@Override
	public ArrayList<OrderDTO> listAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<OrderDTO> selectorderNo(String orderNo) {
		// TODO Auto-generated method stub
		return null;
	}
}