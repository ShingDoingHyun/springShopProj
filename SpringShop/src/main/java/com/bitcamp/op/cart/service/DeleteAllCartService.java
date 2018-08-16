package com.bitcamp.op.cart.service;

import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.cart.dao.CartDaoInterface;

public class DeleteAllCartService {
	@Autowired
	SqlSessionTemplate template;
	private CartDaoInterface CartDao;

	public void deleteAllCart() {

		CartDao = template.getMapper(CartDaoInterface.class);

		CartDao.deleteAllCart();

	}
}
