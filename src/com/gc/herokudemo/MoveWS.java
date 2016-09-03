/**
 * 
 */
package com.gc.herokudemo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.gc.herokudemo.dao.MovieDao;
import com.gc.herokudemo.dto.Category;
import com.gc.herokudemo.dto.Movies;

/**
 * @author Maurice
 *	Webservice for accessing Heroku clearDb MySQL movie database
 */
@Path("/movie") // service call mapping 
public class MoveWS {

	/*
	 * Get list of movie categories from the movie database
	 */
	@GET // Http verb 
	@Produces(MediaType.APPLICATION_JSON)// JSON media type
	@Path("/getcategories")
	public List<Category> getCategories(){		
		MovieDao movieDao = new MovieDao();
		List<Category> list = movieDao.getCategories();
		return list;	
	}
	/*
	 * Get list of film by category parameter from the movie database
	 * using multivalue map
	 * Ref: https://docs.oracle.com/cd/E19776-01/820-4867/6nga7f5np/index.html
	 */
	@POST // Http verb	
	@Path("/getfilmbycategory")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)// XML media type
	public List<Movies> getFilmsByCategory(MultivaluedMap<String, String> formParams){
		String category = formParams.getFirst("category");		
		MovieDao movieDao = new MovieDao();
		List<Movies> list = movieDao.getFilmsByCategory(category);		
		return list;		
	}
	
	/*
	 * Increment film likes or dislikes column base on user input
	 * using multivalue map
	 * Ref: https://docs.oracle.com/cd/E19776-01/820-4867/6nga7f5np/index.html
	 */	
	@POST // Http verb	
	@Path("/ratemovie")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_PLAIN)// XML media type
	public String setRateMovie(MultivaluedMap<String, String> formParams){
		boolean likeFlag = Boolean.parseBoolean(formParams.getFirst("like"));
		int id = Integer.parseInt(formParams.getFirst("id"));
		float rating = Float.parseFloat(formParams.getFirst("rating"));
		MovieDao movieDao = new MovieDao();		
		String result = String.valueOf(movieDao.setFilmRatingById(id, rating));
		return result;		
	}	
}
