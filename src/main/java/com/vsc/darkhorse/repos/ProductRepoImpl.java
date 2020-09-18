package com.vsc.darkhorse.repos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vsc.darkhorse.models.Product;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class ProductRepoImpl implements ProductRepo {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Product> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Product> query = currentSession.createQuery("from Product", Product.class);
		List<Product> listOfProducts = query.getResultList();
		return listOfProducts;
	}

	@Override
	public Product get(String unique_id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Product productObj = currentSession.get(Product.class, unique_id);
		return productObj;
	}

	@Override
	public String save(Product product) {
		Session currentSession = entityManager.unwrap(Session.class);
		try {
			currentSession.saveOrUpdate(product);
			return "Congratulations Product Details SAVED Successfully" + product.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "OOOOPPPPSSS !!! Sorry , Your Products Details Can't Save, Please Check and Save again, Thanks !! ";
		}
	}

	@Override
	public String delete(String unique_id) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			Product product = currentSession.get(Product.class, unique_id);
			currentSession.delete(product);
			return "Congratulations Product Details DELETED Successfully" + product.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return "OOOOPPPPSSS !!! Sorry , Your Products Details Can't Deleted, Please Check and Delete again, Thanks !! ";
		}

	}

	@Override
	public String update(Product productObj, String unique_id) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			Product product = currentSession.get(Product.class, unique_id);
			product.setProductUrl(productObj.getProductUrl());
			product.setProductName(productObj.getProductName());
			product.setPid(productObj.getPid());
			product.setProductCategoryTree(productObj.getProductCategoryTree());
			product.setRetailPrice(productObj.getRetailPrice());
			product.setDiscountedPrice(productObj.getDiscountedPrice());
			product.setImage(productObj.getImage());
			product.setIsFKAdvantageProduct(productObj.getIsFKAdvantageProduct());
			product.setDescription(productObj.getDescription());
			product.setProductRating(productObj.getProductRating());
			product.setOverallRating(productObj.getOverallRating());
			product.setBrand(productObj.getBrand());
			currentSession.saveOrUpdate(product);
			return "Congratulations !! Given Product has been Updated Successfully : " + productObj.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return "OOOOPPPPSSS !!! Sorry , Your Products Details Can't Save, Please Check and Save again, Thanks !! ";
		}

	}

	@Override
	public String loadDatabase(List<Product> listOfProducts) {
		Session currentSession = entityManager.unwrap(Session.class);
		try {
			for (Product product : listOfProducts) {
				currentSession.save(product);
			}
			return "Congratulations All Products has been  SAVED Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "OOOOPPPPSSS !!! Sorry , Your Products Details Can't Save, Please Check and Save again, Thanks !! ";
		}
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public List<Product> getByRating(String rating) {
		Session currentSession = entityManager.unwrap(Session.class);
		Criteria crit = currentSession.createCriteria(Product.class);
		crit.add(Restrictions.eq("overallRating",rating));
		return crit.list();
	}
}
