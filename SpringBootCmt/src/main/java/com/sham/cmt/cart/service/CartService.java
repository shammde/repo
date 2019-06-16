package com.sham.cmt.cart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sham.cmt.cart.ent.Cart;
import com.sham.cmt.cart.ent.ItemLine;

/**
 * 
 * @author mehtesham
 *
 */
@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ItemRepository itemReposatory;
	
	private static final Logger logger = LoggerFactory.getLogger(CartService.class);

	public CartService(CartRepository cartRepository,ItemRepository itemReposatory) {
		this.cartRepository = cartRepository;
		this.itemReposatory = itemReposatory;
	}
	
	public List<Cart> getCarts(){
		List<Cart> cartList = new ArrayList<Cart>();
		cartRepository.findAll().forEach(cartList::add);
		return cartList;
	}
	
	public Cart addCart(Cart cart) {
		cart.setID(String.valueOf(cartRepository.count() + 1));
		cartRepository.save(cart);
		logger.debug("Saving cart " + cart.toString());
		return cart;
	}
	
	public void deleteCart(String cartId) {
		cartRepository.deleteById(cartId);
	}
	
	public Cart updateCart(Cart cart, String cartId) {
		Optional<Cart> oCart = getCart(cartId);
		if(oCart.isPresent()) {
			Cart tempCart = oCart.get();
			tempCart.setName(cart.getName());
			cartRepository.save(tempCart);
			cart = tempCart;
		}
		return cart;
	}
	
	public Optional<Cart> getCart(String cartId) {
		return cartRepository.findById(cartId);
	}

	public void addItemToCart(String cartId, ItemLine itemLine) {
		Optional<Cart> optionalCart = cartRepository.findById(cartId);
		if(optionalCart.isPresent()) {
			System.out.println(itemLine);
			itemReposatory.save(itemLine);
			Cart cart = optionalCart.get();
			cart.addItemLine(itemLine);
			cartRepository.save(cart);
		}
	}
}
