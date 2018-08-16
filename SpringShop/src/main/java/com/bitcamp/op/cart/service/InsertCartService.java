package com.bitcamp.op.cart.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.cart.dao.CartDaoInterface;
import com.bitcamp.op.cart.model.CartDTO;

public class InsertCartService {
	@Autowired
	SqlSessionTemplate template;
	private CartDaoInterface CartDao;

	public int insertCart(CartDTO cart) {

		int result = 0;
		CartDao = template.getMapper(CartDaoInterface.class);

		result = CartDao.insertCart(cart);

		return result;
	}
}
