/**
 * 
 */
package com.gc.herokudemo.dto;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Maurice
 * Data Transfer Object DTO for Film table 
 */
@XmlRootElement
public class Movies{
	
	private int filmid;
	
	private String title;
	
//	private String description;
	/*
	 * https://dev.mysql.com/doc/connector-j/en/connector-j-reference-type-conversions.html
	 * If yearIsDateType configuration property is set to false, 
	 * then the returned object type is java.sql.Short. 
	 * If set to true (the default), then the returned object is of type java.sql.Date with 
	 * the date set to January 1st, at midnight.
	 */
//	private Date release_year;
	
//	private int length;
	
//	private String name;
	
//	private int likes;
	
//	private int dislikes;
	
	private float rating;
	
//	private Set specialFeatures;


	/**
	 * @return the release_year
	 */
//	public Date getRelease_year() {
//		return release_year;
//	}

	/**
	 * @param release_year the release_year to set
	 */
//	public void setRelease_year(Date release_year) {
//		this.release_year = release_year;
//	}


	/**
	 * @return the filmid
	 */
	public int getFilmid() {
		return filmid;
	}

	/**
	 * @param filmid the filmid to set
	 */
	public void setFilmid(int filmid) {
		this.filmid = filmid;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
/*	public String getDescription() {
		return description;
	}*/

	/**
	 * @param description the description to set
	 */
	/*public void setDescription(String description) {
		this.description = description;
	}*/


	/**
	 * @return the length
	 */
	/*public int getLength() {
		return length;
	}*/

	/**
	 * @param length the length to set
	 */
	/*public void setLength(int length) {
		this.length = length;
	}*/

	/**
	 * @return the name
	 */
	/*public String getName() {
		return name;
	}*/

	/**
	 * @param name the name to set
	 */
	/*public void setName(String name) {
		this.name = name;
	}*/

	/**
	 * @return the likes
	 */
	/*public int getLikes() {
		return likes;
	}*/

	/**
	 * @param likes the likes to set
	 */
	/*public void setLikes(int likes) {
		this.likes = likes;
	}*/

	/**
	 * @return the dislikes
	 */
	/*public int getDislikes() {
		return dislikes;
	}*/

	/**
	 * @param dislikes the dislikes to set
	 */
	/*public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}*/

	

	/**
	 * @return the idKey
	 */
//	public int getIdKey() {
//		return idKey;
//	}

	/**
	 * @param idKey the idKey to set
	 */
//	public void setIdKey(int idKey) {
//		this.idKey = idKey;
//	}

	

	/**
	 * @return the specialFeatures
	 */
//	public Set getSpecialFeatures() {
//		return specialFeatures;
//	}

	

	/**
	 * @param specialFeatures the specialFeatures to set
	 */
//	public void setSpecialFeatures(Set specialFeatures) {
//		this.specialFeatures = specialFeatures;
//	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Movies [filmid=" + filmid + ", title=" + title + ", rating=" + rating + "]";
	}

	/**
	 * @return the rating
	 */
	public float getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(float rating) {
		this.rating = rating;
	}	
}
