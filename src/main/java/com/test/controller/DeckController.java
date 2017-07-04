package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.controller.domain.Deck;
import com.test.controller.service.DeckService;

@RestController
public class DeckController {

	@Autowired
	private DeckService deckService;
	
	@RequestMapping("/category/{categoryId}/deck")
	@PreAuthorize("@accessChecker.hasAccessToCategory(#categoryId)")
	public List<Deck> getAllDecks(@PathVariable Long categoryId) {
		List<Deck> result = new ArrayList<Deck>();
		result.addAll(deckService.getAllDecks());
		return result;
	}
	
	@RequestMapping("/category/{categoryId}/deck/{deckId}")
	@PreAuthorize("@accessChecker.hasAccessToDeck(#categoryId, #deckId)")
	public String getDeck(@PathVariable Long categoryId, @PathVariable Long deckId) {
		return "You have access";
	}
}
