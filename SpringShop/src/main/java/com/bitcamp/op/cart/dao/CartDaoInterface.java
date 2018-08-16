package com.bitcamp.op.cart.dao;

import java.util.List;

import com.bitcamp.op.cart.model.CartDTO;

public interface CartDaoInterface {
	
	public List<CartDTO> getAllCart();
	
	public int insertCart(CartDTO cart);
	
	public void deleteAllCart();

}
