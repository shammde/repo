package com.sham.cmt.cart.service;

import org.springframework.data.repository.CrudRepository;

import com.sham.cmt.cart.ent.ItemLine;

public interface ItemRepository extends CrudRepository<ItemLine, String>{

}
