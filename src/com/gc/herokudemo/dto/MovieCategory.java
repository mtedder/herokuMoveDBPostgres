/**
 * 
 */
package com.gc.herokudemo.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Maurice
 * Data Transfer Object DTO for Film Category table 
 */
@XmlRootElement
public class MovieCategory {
	private int filmId;
	private int categoryId;
	/**
	 * @return the filmId
	 */
	public int getFilmId() {
		return filmId;
	}
	/**
	 * @param filmId the filmId to set
	 */
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	/**
	 * @return the catagoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param catagoryId the catagoryId to set
	 */
	public void setCategoryId(int catagoryId) {
		this.categoryId = catagoryId;
	}
}
