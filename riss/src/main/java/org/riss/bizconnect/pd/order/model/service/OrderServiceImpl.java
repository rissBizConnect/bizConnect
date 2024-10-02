package org.riss.bizconnect.pd.order.model.service;

import org.riss.bizconnect.pd.order.model.dao.OrderDAO;
import org.riss.bizconnect.pd.order.model.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public void createOrder(OrderDTO order) {
        // 주문 생성 로직
        orderDAO.createOrder(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        // 모든 주문 조회 로직
        return orderDAO.getAllOrders();
    }

    @Override
    public OrderDTO getOrderById(Long orderCd) {
        // 주문 ID로 주문 조회 로직
        return orderDAO.getOrderById(orderCd);
    }

    @Override
    public void updateOrder(OrderDTO order) {
        // 주문 수정 로직
        orderDAO.updateOrder(order);
    }

    @Override
    public void deleteOrder(Long orderCd) {
        // 주문 삭제 로직
        orderDAO.deleteOrder(orderCd);
    }
}