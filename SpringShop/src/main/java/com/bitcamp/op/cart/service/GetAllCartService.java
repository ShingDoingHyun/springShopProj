package com.bitcamp.op.cart.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.cart.dao.CartDaoInterface;
import com.bitcamp.op.cart.model.CartDTO;

public class GetAllCartService {
	@Autowired
	SqlSessionTemplate template;
	private CartDaoInterface CartDao;

	public List<CartDTO> getAllCart() {

		List<CartDTO> cartlist = null;

		CartDao = template.getMapper(CartDaoInterface.class);

		cartlist = CartDao.getAllCart();

		return cartlist;
	}
}
