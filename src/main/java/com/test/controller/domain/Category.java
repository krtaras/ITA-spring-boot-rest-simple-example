package com.test.controller.domain;

import java.util.ArrayList;
import java.util.List;

public class Category extends HATEOASSupport {
	private Long id;
	private String name;
	private String privateData;
	private List<Deck> decks;

	public Category() {
		super();
	}

	public Category(Long id, String name) {
		this(id, name, new ArrayList<Deck>());
	}
	
	public Category(Long id, String name, List<Deck> decks) {
		super();
		this.id = id;
		this.name = name;
		this.privateData = "Thi is PRIVATE";
		this.decks = decks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrivateData() {
		return privateData;
	}

	public void setPrivateData(String privateData) {
		this.privateData = privateData;
	}

	public List<Deck> getDecks() {
		return decks;
	}

	public void setDecks(List<Deck> decks) {
		this.decks = decks;
	}

}
