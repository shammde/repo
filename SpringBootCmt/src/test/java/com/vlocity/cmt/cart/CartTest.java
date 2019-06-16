package com.vlocity.cmt.cart;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sham.cmt.cart.service.CartRepository;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CartTest {

	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	CartRepository cartRespository;
	
	@Test
	public void addCartTest() throws Exception {
		
		Mockito.when(cartRespository.findAll()).thenReturn(Collections.emptyList());
		
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/cart")
				.accept(MediaType.APPLICATION_JSON)
				).andReturn();
		
		System.out.println(mvcResult.getResponse());
		
		Mockito.verify(cartRespository).findAll();
	}
}
