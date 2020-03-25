package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ProductDao;
import domain.Product;
import shared.FactoryManager;

public class ProductDaoImpl implements ProductDao {
	private EntityManager em = FactoryManager.getEntityManager();
	
	@Override
	public Product create(Product product) {
		try {
			em.getTransaction().begin();
			em.persist(product);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public Product read(Integer id) {
		Product product = null;
		try {
			product = em.find(Product.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public Product update(Integer id, Product t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> readAll() {
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM Product e");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

}
