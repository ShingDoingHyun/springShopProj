package com.bitcamp.op.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.cart.model.CartDTO;
import com.bitcamp.op.cart.service.DeleteAllCartService;
import com.bitcamp.op.cart.service.GetAllCartService;
import com.bitcamp.op.cart.service.InsertCartService;

@Controller
public class CartController {

	@Autowired
	InsertCartService insertcartservice;

	@Autowired
	GetAllCartService getallcartservice;

	@Autowired
	DeleteAllCartService deleteallcartservice;

	@RequestMapping("/product/getAllCart")
	public String getAllCart(Model model) {

		model.addAttribute("Cartlist", getallcartservice.getAllCart());

		return "product/getAllCart";

	}

	@RequestMapping("/product/insertCart")
	public String addCart(Model model, @RequestParam(value = "img") String img,
			@RequestParam(value = "name") String name, @RequestParam(value = "price") String price,
			@RequestParam(value = "amount", defaultValue = "1") String amount,
			@RequestParam(value = "one") String one
			) {


		CartDTO cart = new CartDTO();
		cart.setImg_src(img);
		cart.setItem_name(name);
		cart.setItem_one(one);
		cart.setItem_price(price);
		cart.setItem_amount(amount);
		
		int cnt = 0;

		cnt = insertcartservice.insertCart(cart);

		model.addAttribute("Cartlist", getallcartservice.getAllCart());

		return "product/getAllCart";

	}

	@RequestMapping("/product/deleteCart")
	public String deleteCart(Model model) {

		deleteallcartservice.deleteAllCart();

		model.addAttribute("Cartlist", getallcartservice.getAllCart());

		return "product/getAllCart";

	}
}
