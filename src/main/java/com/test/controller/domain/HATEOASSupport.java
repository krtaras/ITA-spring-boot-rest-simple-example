package com.test.controller.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HATEOASSupport {
	private final List<Link> links;
	
	public HATEOASSupport() {
		links = new ArrayList<Link>();
	}
	
	public void add(Link link) {
		this.links.add(link);
	}

	@JsonProperty("_links")
	public List<Link> getLinks() {
		return links;
	}
}
