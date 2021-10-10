package com.cava.web.dto;

import java.util.List;

public class TableDTO {
	private Integer pages;
	private Long elements;
	private List<?> rows;
	
	public TableDTO() {}

	public TableDTO(Integer pages, Long elements, List<?> rows) {
		super();
		this.pages = pages;
		this.elements = elements;
		this.rows = rows;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Long getElements() {
		return elements;
	}

	public void setElements(Long elements) {
		this.elements = elements;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}