/**
 * 
 */
package com.gc.herokudemo.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Maurice
 * Data Transfer Object DTO for Catagory table 
 */
@XmlRootElement
public class Category{
	private int categoryId;
	private String name;
	/**
	 * @return the catagoryID
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param catagoryID the catagoryID to set
	 */
	public void setCategoryId(int catagoryID) {
		this.categoryId = catagoryID;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
