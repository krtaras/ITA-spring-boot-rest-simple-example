package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.controller.domain.Category;
import com.test.controller.dto.CategoryPrivate;
import com.test.controller.dto.CategoryPublic;
import com.test.controller.dto.impl.CategoryPrivateDTO;
import com.test.controller.dto.impl.CategoryPublicDTO;
import com.test.controller.service.CategoryService;
import com.test.controller.service.DeckService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private DeckService deckService;
	
	@RequestMapping("/me")
	public String me() {
		return "Hello World";
	}
	
	@RequestMapping("/categoryPublic")
	public CategoryPublic getPublicCategory() {
		CategoryPublicDTO category = new CategoryPublicDTO(1L, "Category_A");
		category.setDecks(deckService.getAllDecks());
		CategoryPublic categoryPublic = category;
		return categoryPublic;
	}
	
	@RequestMapping("/categoryPrivate")
	public CategoryPrivate getPrivateCategory() {
		CategoryPrivateDTO category = new CategoryPrivateDTO(1L, "Category_A");
		category.setDecks(deckService.getAllDecks());
		CategoryPrivate categoryPrivate = category;
		return categoryPrivate;
	}
	
	@RequestMapping("/category")
	public HttpEntity<List<Category>> getAllCategories() {
		List<Category> result = new ArrayList<Category>();
		result.addAll(categoryService.getAllCategoruies());
		for (Category category: result) 
			category.add(linkTo(methodOn(CategoryController.class).getCategory(category.getId())).withSelfRel());
		return new ResponseEntity<List<Category>>(result, HttpStatus.OK);
	}
	
	@RequestMapping("/category/{categoryId}")
	@PreAuthorize("@accessChecker.hasAccessToCategory(#categoryId)")
	public HttpEntity<Category> getCategory(@PathVariable Long categoryId) {
		Category category = new Category(2L, "You Have access");
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
	
	@RequestMapping("/category/{categoryId}/cource/{courceId}")
	@PreAuthorize("@accessChecker.hasAccessToCource(#categoryId, #courceId)")
	public String getCource(@PathVariable Long categoryId, @PathVariable Long courceId) {
		return "You have access!";
	}
}
