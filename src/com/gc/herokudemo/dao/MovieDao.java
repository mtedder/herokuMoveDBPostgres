/**
 * 
 */
package com.gc.herokudemo.dao;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;

import com.gc.herokudemo.dto.Category;
import com.gc.herokudemo.dto.Movies;
import com.gc.herokudemo.util.HibernateUtil;

/**
 * @author Maurice Data access object for Heroku Movie database
 */
public class MovieDao {

	private static SessionFactory factory;

	/**
	 * Constructor with hibernate configurations initializations
	 */
	public MovieDao() {				
		factory = HibernateUtil.getSessionFactory();
	}

	/*
	 * Return list of categories from the Category Table
	 */
	public List<Category> getCategories() {
		/*
		 * Hibernate stuff
		 */
		Session session = factory.openSession();
		Transaction tx = null;
		Category categoryItem = null;
		List<Category> categoryItemList = new ArrayList<Category>();
		List<?> categoryListItems = null;
		try {
			tx = session.beginTransaction();
			categoryListItems = session.createQuery("FROM Category").list();
			for (Iterator<?> iterator = categoryListItems.iterator(); iterator.hasNext();) {
				categoryItem = (Category) iterator.next();
				categoryItemList.add(categoryItem);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			// TODO replace with write errors to log file
			e.printStackTrace();
		} finally {
			session.close();
		}
		return categoryItemList;
	}

	/*
	 * Return list of categories from the Category Table //SELECT f.title,
	 * f.description, f.release_year, f.length, f.rating, f.special_features,
	 * cat.name FROM film as f, category as cat, film_category as fcat where
	 * f.film_id = fcat.film_id and cat.category_id = fcat.category_id and
	 * cat.name ='Comedy';
	 */
	public List<Movies> getFilmsByCategory(String categoryParam) {
		/*
		 * Hibernate stuff
		 */
		Session session = factory.openSession();
		Transaction tx = null;
		List<Movies> filmListItems = new ArrayList<Movies>();
		try {
			tx = session.beginTransaction();
			// This is required because the resultset is the result of a join
			// and has no entity mapping - Figure out how to convert this to criteria queries later
			Query query = session
					.createSQLQuery(
							"SELECT f.idmovies as filmid, f.title, f.rating FROM Movies as f, Category as cat, MovieCategory as fcat where f.idmovies = fcat.idmovies and cat.idcategory = fcat.idcategory and cat.name =:film_category")						
					.setResultTransformer(Transformers.aliasToBean(Movies.class));

			query.setString("film_category", categoryParam);
			filmListItems = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			// TODO replace with write errors to log file
			e.printStackTrace();
		} finally {
			session.close();
		}		
		return filmListItems;
	}

	/*
	 * Handle like and dislike for films by Id
	 */
	public boolean setFilmLikeDislikeById(boolean like, int id) {
		/*
		 * Hibernate stuff
		 */
		Session session = factory.openSession();
		Transaction tx = null;
		Movies film = null;
		try {
			tx = session.beginTransaction();
			film = (Movies) session.get(Movies.class, id);
			session.update(film);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			// TODO replace with write errors to log file
			e.printStackTrace();
		} finally {
			session.close();
		}
		return true;
	}

	/*
	 * Set the user rating for this film. Average this rating with current rating
	 */
	public boolean setFilmRatingById(int id, float rating) {
		Session session = factory.openSession();
		Transaction tx = null;
		Movies film = null;
		try {
			tx = session.beginTransaction();
			film = (Movies) session.get(Movies.class, id);
			float currentRating = film.getRating();
			if(currentRating == 0.0f){//no average
				film.setRating(rating);
			}else{
				film.setRating((rating + currentRating)/2.0f);//average this rating with current rating
			}		
			session.update(film);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			// TODO replace with write errors to log file
			e.printStackTrace();
		} finally {
			session.close();
		}
		return true;
	}
}
