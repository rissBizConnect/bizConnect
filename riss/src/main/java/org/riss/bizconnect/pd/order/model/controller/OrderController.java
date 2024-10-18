package org.riss.bizconnect.pd.order.model.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.hr.attendance.controller.AttendanceController;
import org.riss.bizconnect.pd.odetail.model.dto.OrderDetail;
import org.riss.bizconnect.pd.odetail.model.service.OrderDetailService;
import org.riss.bizconnect.pd.order.model.dto.Order;
import org.riss.bizconnect.pd.order.model.service.OrderService;
import org.riss.bizconnect.pd.product.model.dto.ProductDTO;
import org.riss.bizconnect.pd.product.model.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderDetailService orderDetailService;

	@Autowired
	private ProductService productService;

	@RequestMapping("moveOrderInsert.do")
	public ModelAndView moveOrder(HttpSession session, @RequestParam(name = "count", required = false) String cnt,
			ModelAndView mv) {

		String myCom = ((Member) session.getAttribute("loginUser")).getComCode();
		logger.info("loginUser : " + (Member) session.getAttribute("loginUser"));
		logger.info("myCom : " + myCom);

		int count = 1;
		if (cnt != null) {
			count = Integer.parseInt(cnt);
		}
		ArrayList<ProductDTO> list = productService.selectAll(myCom);

		mv.addObject("list", list);
		mv.setViewName("pr/stock/order/orderInsert");
		mv.addObject("count", count);
		return mv;
	}

	@RequestMapping("moveprMenu_order.do")
	public ModelAndView moveOrder(HttpSession session, ModelAndView mv) {

		String myCom = ((Member) session.getAttribute("loginUser")).getComCode();
		mv.setViewName("pr/prMenubar/prMenu_order");
		ArrayList<Order> order = orderService.selectAll(myCom);
		ArrayList<Order> tOrder = new ArrayList<Order>();
		for (Order o : order) {
			boolean eq = false;
			for (Order to : tOrder) {
				if (o.getOrderDiv() == to.getOrderDiv()) {
					eq = true;
				}
			}
			if (!eq) {
				tOrder.add(o);
			}
		}

		mv.addObject("order", tOrder);

		return mv;
	}

	@RequestMapping("OrderInsert.do")
	public String orderInsert(HttpSession session, 
			@RequestParam("productNo") int[] productNo,
			@RequestParam("orderDetailDate") Date[] orderDetailDate,
			@RequestParam("orderDetailPayment") String[] orderDetailPayment,
			@RequestParam("orderDetailCancel") String[] orderDetailCancel,
			@RequestParam("orderDetailStatus") String[] orderDetailStatus,
			@RequestParam("orderDetailCnt") int[] orderDetailCnt, Order order) {

		logger.info("order : " + order);
		String myCom = ((Member) session.getAttribute("loginUser")).getComCode();

		OrderDetail orderDetail = new OrderDetail();
		int div = orderService.selectNxDiv(myCom);
		order.setOrderDiv(div);
		orderDetail.setOrderDiv(div);

		order.setComCode(myCom);
		orderDetail.setComCode(myCom);
		
		orderDetail.setOrderType(order.getOrderType());

		for (int i = 0; i < productNo.length; i++) {
			int orderNo = orderService.selectNxNo(myCom);
			int orderDNo = orderDetailService.selectNxNo(myCom);

			order.setOrderNo(orderNo);
			order.setOrderDetailNo(i);
			order.setProductNoA(productNo[i]);

			orderDetail.setOrderDetailNo(orderDNo);
			orderDetail.setDetailNo(i);

			orderDetail.setProductNo(productNo[i]);
			orderDetail.setOrderDetailDate(orderDetailDate[i]);
			orderDetail.setOrderDetailPayment(orderDetailPayment[i]);
			orderDetail.setOrderDetailCancel(orderDetailCancel[i]);
			orderDetail.setOrderDetailStatus(orderDetailStatus[i]);
			orderDetail.setOrderDetailCnt(orderDetailCnt[i]);

			if (orderService.insertOrder(order) != 1) {
				return "common/error";
			}
			if (orderDetailService.insertOrderDetail(orderDetail) != 1) {
				return "common/error";
			}
		}
		if(order.getOrderType().equals("P")) {
			return "redirect:moveprMenu_porder.do";
		}else {
			return "redirect:moveprMenu_order.do";
		}
		
	}

	@RequestMapping("orderDelete.do")
	public String orderDelete(
			HttpSession session, 
			@RequestParam("orderDiv") String orderDiv,
			@RequestParam("orderT") String orderT) {

		String myCom = ((Member) session.getAttribute("loginUser")).getComCode();
		Order order = new Order();
		OrderDetail orderDetail = new OrderDetail();

		order.setOrderDiv(Integer.parseInt(orderDiv));
		order.setComCode(myCom);
		order.setOrderType(orderT);
		orderDetail.setOrderDiv(Integer.parseInt(orderDiv));
		orderDetail.setComCode(myCom);
		orderDetail.setOrderType(orderT);
		if (orderService.deleteAll(order) <= 0 || orderDetailService.deleteAll(orderDetail) <= 0) {
			return "common/error";
		}
		if(order.getOrderType().equals("P")) {
			return "redirect:moveprMenu_porder.do";
		}else {
			return "redirect:moveprMenu_order.do";
		}
		
	}

	@RequestMapping("moveOrderUpdate.do")
	public ModelAndView moveOrderUpdate(HttpSession session, ModelAndView mv,
			@RequestParam("orderDiv") String orderDiv) {

		mv.setViewName("pr/stock/order/orderUpdate");

		String myCom = ((Member) session.getAttribute("loginUser")).getComCode();
		OrderDetail orderD = new OrderDetail();
		Order order = new Order();

		orderD.setComCode(myCom);
		orderD.setOrderDiv(Integer.parseInt(orderDiv));
		order.setComCode(myCom);
		order.setOrderDiv(Integer.parseInt(orderDiv));

		ArrayList<ProductDTO> list = productService.selectAll(myCom);
		mv.addObject("list", list);

		ArrayList<OrderDetail> lorderD = orderDetailService.selectDivList(orderD);
		mv.addObject("orderD", lorderD);

		ArrayList<Order> lorder = orderService.selectDivList(order);
		mv.addObject("order", lorder);

		return mv;
	}

	@RequestMapping("orderUpdate.do")
	public String orderUpdate(HttpSession session, 
			@RequestParam("productNo") int[] productNo,
			@RequestParam("orderDetailDate") Date[] orderDetailDate,
			@RequestParam("orderDetailPayment") String[] orderDetailPayment,
			@RequestParam("orderDetailCancel") String[] orderDetailCancel,
			@RequestParam("orderDetailStatus") String[] orderDetailStatus,
			@RequestParam("orderDetailCnt") int[] orderDetailCnt, 
			@RequestParam("detailNo") int[] detailNo, 
			@RequestParam("orderDiv") int orderDiv, 
			Order order) {

		String myCom = ((Member) session.getAttribute("loginUser")).getComCode();

		OrderDetail orderDetail = new OrderDetail();
		int div = orderService.selectNxDiv(myCom);
		order.setOrderDiv(orderDiv);
		orderDetail.setOrderDiv(orderDiv);

		order.setComCode(myCom);
		orderDetail.setComCode(myCom);

		for (int i = 0; i < productNo.length; i++) {
			int orderNo = orderService.selectNxNo(myCom);
			int orderDNo = orderDetailService.selectNxNo(myCom);

			order.setOrderNo(orderNo);
			order.setOrderDetailNo(detailNo[i]);
			order.setProductNoA(productNo[i]);

			orderDetail.setOrderDetailNo(orderDNo);
			orderDetail.setDetailNo(detailNo[i]);

			orderDetail.setProductNo(productNo[i]);
			orderDetail.setOrderDetailDate(orderDetailDate[i]);
			orderDetail.setOrderDetailPayment(orderDetailPayment[i]);
			orderDetail.setOrderDetailCancel(orderDetailCancel[i]);
			orderDetail.setOrderDetailStatus(orderDetailStatus[i]);
			orderDetail.setOrderDetailCnt(orderDetailCnt[i]);

			if (orderDetailService.updateOrderDetail(orderDetail) != 1) {
				return "common/error";
			}
		}
		if(orderService.updateOrder(order) <= 0) {
			return "common/error";
		}
		
		if(order.getOrderType().equals("P")) {
			return "redirect:moveprMenu_porder.do";
		}else {
			return "redirect:moveprMenu_order.do";
		}
		
	}
	@RequestMapping("moveprMenu_porder.do")
	public ModelAndView moveprMenu_porder(HttpSession session, ModelAndView mv) {


		String myCom = ((Member) session.getAttribute("loginUser")).getComCode();
		mv.setViewName("pr/prMenubar/prMenu_porder");
		ArrayList<Order> order = orderService.selectAllP(myCom);
		ArrayList<Order> tOrder = new ArrayList<Order>();
		for (Order o : order) {
			boolean eq = false;
			for (Order to : tOrder) {
				if (o.getOrderDiv() == to.getOrderDiv()) {
					eq = true;
				}
			}
			if (!eq) {
				tOrder.add(o);
			}
		}

		mv.addObject("order", tOrder);

		return mv;
	}
	

}
