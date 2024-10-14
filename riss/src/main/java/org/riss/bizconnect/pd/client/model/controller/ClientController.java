package org.riss.bizconnect.pd.client.model.controller;

import java.util.ArrayList;

import org.riss.bizconnect.pd.client.model.dto.ClientDTO;
import org.riss.bizconnect.pd.client.model.service.ClientService;
import org.riss.bizconnect.pd.product.model.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping("prMenu_client.do")
	public ModelAndView clienthome(ModelAndView mv) {
		
		mv.setViewName("pr/prMenubar/prMenu_client");
		ArrayList<ClientDTO> client = clientService.listAllClients();
		
		mv.addObject("all", client);
		
		return mv;
	}
	
	@RequestMapping("client.do")
	public ModelAndView clienttest(ModelAndView mv) {
		
		mv.setViewName("pr/client/client");
		ArrayList<ClientDTO> client = clientService.listAllClients();
		return mv;
	}
}
