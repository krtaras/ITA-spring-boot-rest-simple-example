package com.test.controller;

import org.springframework.stereotype.Component;

@Component("accessChecker")
public class AccessChecker {
	
	public boolean hasAccessToCategory(Long categoryId) {
		return categoryId == 2L;
	}
	
	public boolean hasAccessToCource(Long categoryId, Long courceId) {
		return hasAccessToCategory(categoryId) && courceId == 1L;
	}
	
	public boolean hasAccessToDeck(Long categoryId, Long deckId) {
		return hasAccessToCategory(categoryId) && deckId == 1L;
	}
	
	public boolean hasAccessToDeck(Long categoryId, Long courceId, Long deckId) {
		return hasAccessToCource(categoryId, courceId) && deckId == 3L;
	}
	
	public boolean hasAccessToCard(Long categoryId, Long deckId, Long cardId) {
		return hasAccessToDeck(categoryId, deckId) && cardId == 5;
	}
	
	public boolean hasAccessToCard(Long categoryId, Long courceId, Long deckId, Long cardId) {
		return hasAccessToDeck(categoryId, courceId, deckId) && cardId == 6;
	}
}
