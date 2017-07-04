package com.test.controller.dto;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.test.controller.domain.Deck;

@JsonSerialize(as=CategoryPrivate.class)
public interface CategoryPrivate {
	public String getPrivateData();
	@JsonSerialize(contentAs=Deck.class)
	public List<Deck> getDecks();
}
