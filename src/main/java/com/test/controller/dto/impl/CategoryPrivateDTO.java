package com.test.controller.dto.impl;

import com.test.controller.domain.Category;
import com.test.controller.dto.CategoryPrivate;

public class CategoryPrivateDTO extends Category implements CategoryPrivate {
	public CategoryPrivateDTO() {
		super();
	}

	public CategoryPrivateDTO(Long id, String name) {
		super(id, name);
	}
}
