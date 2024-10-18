package org.riss.bizconnect.pd.client.model.controller;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.pd.client.model.dto.ClientDTO;
import org.riss.bizconnect.pd.client.model.service.ClientService;
import org.riss.bizconnect.pd.odetail.model.dto.OrderDetail;
import org.riss.bizconnect.pd.order.model.dto.Order;
import org.riss.bizconnect.pd.product.model.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping("moveClientInsert.do")
	public ModelAndView moveClientInsert(ModelAndView mv) {

		mv.setViewName("pr/stock/client/clientInsert");

		return mv;
	}
	
	@RequestMapping("clientInsert.do")
	public String clientInsert(
			HttpSession session, 
			ModelAndView mv,
			ClientDTO ClientDTO) {
		String myCom = ((Member) session.getAttribute("loginUser")).getComCode();
		ClientDTO.setLicenseCode(myCom);
		
		if(clientService.insertclient(ClientDTO) <= 0) {
			return "common/error";
		}

		return "redirect:moveprMenu_client.do";
		
	}
	
	@RequestMapping("moveprMenu_client.do")
	public ModelAndView moveprMenu_client(HttpSession session, ModelAndView mv) {

		String myCom = ((Member) session.getAttribute("loginUser")).getComCode();
		mv.setViewName("pr/prMenubar/prMenu_client");
		ArrayList<ClientDTO> client = clientService.selectAll(myCom);

		mv.addObject("client", client);

		return mv;
	}
	
	@RequestMapping("clientDelete.do")
	public String clientDelete(
			HttpSession session, 
			@RequestParam("ClientCode") String clientCode) {

		ClientDTO client = new ClientDTO();
		String myCom = ((Member) session.getAttribute("loginUser")).getComCode();
		client.setLicenseCode(myCom);
		client.setClientCode(Integer.parseInt(clientCode));

		if (clientService.deleteClient(client) <= 0) {
			return "common/error";
		}

		return "redirect:moveprMenu_client.do";
	}
	
	@RequestMapping("moveClientUpdate.do")
	public ModelAndView moveClientUpdate(HttpSession session, ModelAndView mv,
			@RequestParam("ClientCode") String clientCode) {

		mv.setViewName("pr/stock/client/clientUpdate");

		String myCom = ((Member) session.getAttribute("loginUser")).getComCode();
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setLicenseCode(myCom);
		clientDTO.setClientCode(Integer.parseInt(clientCode));

		clientDTO = clientService.selectClientOne(clientDTO);
		mv.addObject("client", clientDTO);

		return mv;
	}
	
	@RequestMapping("clientUpdate.do")
	public String clientUpdate(
			HttpSession session, 
			ClientDTO client) {

		String myCom = ((Member) session.getAttribute("loginUser")).getComCode();

		client.setLicenseCode(myCom);
		if(clientService.update(client) <= 0) {
			return "common/error";
		}
		
		return "redirect:moveprMenu_order.do";
	}

}
