package com.test.controller.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as=CategoryPublic.class)
public interface CategoryPublic {
	public String getName();
}
