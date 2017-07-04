package com.test.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.controller.domain.Category;

@Service
public class CategoryService {

	@Autowired
	private DeckService deckService;
	
	@SuppressWarnings("serial")
	public List<Category> getAllCategoruies() {
		return new ArrayList<Category>(){{
			add(new Category(1L, "Category_A", deckService.getAllDecks()));
			add(new Category(2L, "Category_B", deckService.getAllDecks()));
			add(new Category(3L, "Category_C", deckService.getAllDecks()));
			add(new Category(4L, "Category_D", deckService.getAllDecks()));
		}};
	}
}
