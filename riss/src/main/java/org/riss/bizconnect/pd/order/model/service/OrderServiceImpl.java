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
        // �ֹ� ���� ����
        orderDAO.createOrder(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        // ��� �ֹ� ��ȸ ����
        return orderDAO.getAllOrders();
    }

    @Override
    public OrderDTO getOrderById(Long orderCd) {
        // �ֹ� ID�� �ֹ� ��ȸ ����
        return orderDAO.getOrderById(orderCd);
    }

    @Override
    public void updateOrder(OrderDTO order) {
        // �ֹ� ���� ����
        orderDAO.updateOrder(order);
    }

    @Override
    public void deleteOrder(Long orderCd) {
        // �ֹ� ���� ����
        orderDAO.deleteOrder(orderCd);
    }
}