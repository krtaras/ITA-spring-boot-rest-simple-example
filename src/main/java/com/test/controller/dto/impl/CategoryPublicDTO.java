package com.test.controller.dto.impl;

import com.test.controller.domain.Category;
import com.test.controller.dto.CategoryPublic;

public class CategoryPublicDTO extends Category implements CategoryPublic {
	public CategoryPublicDTO() {
		super();
	}

	public CategoryPublicDTO(Long id, String name) {
		super(id, name);
	}
}
