package com.sham.cmt.cart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sham.cmt.cart.ent.Cart;
import com.sham.cmt.cart.ent.ItemLine;
import com.sham.cmt.cart.service.CartService;

/**
 * 
 * @author mehtesham
 *
 */

@RestController
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public List<Cart> getRoot() {
		return cartService.getCarts();
	}
	
	@RequestMapping("/cart")
	public List<Cart> getCart() {
		return cartService.getCarts();
	}
	
	@RequestMapping("/cart/{cartId}")
	public Optional<Cart> getCartByID(@PathVariable String cartId) {
		return cartService.getCart(cartId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/cart")
	public Cart addCart(@RequestBody Cart cart) {
		return cartService.addCart(cart);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/cart/{cartId}")
	public Cart updateCart(@RequestBody Cart cart, @PathVariable(value = "userId") String cartId) {
		return cartService.updateCart(cart, cartId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/cart/{cartId}")
	public void deleteCart(@PathVariable String cartId) {
		cartService.deleteCart(cartId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/cart/{cartId}")
	public void addItemToCart(@RequestBody ItemLine itemLine, @PathVariable String cartId) {
		cartService.addItemToCart(cartId, itemLine);
	}
}
