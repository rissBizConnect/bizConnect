package org.riss.bizconnect.pd.order.model.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;

import org.riss.bizconnect.pd.order.model.dto.OrderDTO;
import org.riss.bizconnect.pd.order.model.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
    @Autowired
    private OrderService orderService;

    @RequestMapping("order.do")
    public ModelAndView orderTest(ModelAndView mv) {
        mv.setViewName("pr/stock/order/order");
        List<OrderDTO> order = orderService.listAllOrders();
        mv.addObject("all", order);
        return mv;
    }
    
    
    @RequestMapping("addorder.do")
    public ModelAndView addorder(@ModelAttribute OrderDTO order, ModelAndView mv) {
        // ��û�� `GET` ����� ��, ���� �����ֱ�
        if (order.getOrderCd() == null) {
            mv.setViewName("pr/stock/order/addorder");
            return mv;
        }

        // �ʼ� �� ����
        if (order.getOrderType() == null || order.getOrderType().isEmpty()) {
            mv.addObject("error", "�ֹ� Ÿ���� �ʼ� �׸��Դϴ�.");
            mv.setViewName("stock/order/addorder");
            return mv;
        }

        // �ֹ� ��� ó��
        orderService.addorder(order);

        // ���� �� �ֹ� ��ȸ �������� �����̷�Ʈ
        mv.setViewName("redirect:/bizconnect/order.do");
        return mv;
    }
    
}
/*@RestController
@RequestMapping("/orders")
public class OrderController {
	
	
    
    @Autowired
    private OrderService orderService;

    @PostMapping
    public void createOrder(@RequestBody OrderDTO order) {
        orderService.addOrder(order);
    }

    @PutMapping("/{orderCd}")
    public void updateOrder(@PathVariable Long orderCd, @RequestBody OrderDTO order) {
        order.setOrderCd(orderCd); // ��û�� orderCd�� DTO�� ����
        orderService.modifyOrder(order);
    }

    @DeleteMapping("/{orderCd}")
    public void deleteOrder(@PathVariable Long orderCd) {
        orderService.removeOrder(orderCd);
    }

    @GetMapping("/{orderCd}")
    public OrderDTO getOrder(@PathVariable Long orderCd) {
        return orderService.getOrder(orderCd);
    }

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }
}*/