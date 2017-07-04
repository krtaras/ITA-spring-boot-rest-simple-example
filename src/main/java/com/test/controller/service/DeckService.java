package com.test.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.controller.domain.Deck;

@Service
public class DeckService {

	@SuppressWarnings("serial")
	public List<Deck> getAllDecks() {
		return new ArrayList<Deck>(){{
			add(new Deck("Deck_1"));
			add(new Deck("Deck_2"));
			add(new Deck("Deck_3"));
		}};
	}
}
