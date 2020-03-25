package dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import dao.BucketDao;
import domain.Bucket;
import domain.User;
import shared.FactoryManager;

public class BucketDaoImpl implements BucketDao {
	
	private EntityManager em = FactoryManager.getEntityManager();
	@Override
	public Bucket create(Bucket bucket) {
		try {
			em.getTransaction().begin();
			em.persist(bucket);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} 

		return bucket;
	}

	@Override
	public Bucket read(Integer id) {
		Bucket bucket = null;
		try {
			bucket = em.find(Bucket.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bucket;
	}

	@Override
	public Bucket update(Integer id, Bucket t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Bucket> readAll() {
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM Bucket e");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Override
	public List<Bucket> getAllByUserId(Integer userId) {
		List<Bucket> listOfBuckets = new ArrayList<>();
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Bucket> criteria = builder.createQuery(Bucket.class);
			Root<Bucket> from = criteria.from(Bucket.class);
			criteria.select(from);
			criteria.where(builder.equal(from.get("user_id"), userId));
			TypedQuery<Bucket> typed = em.createQuery(criteria);
			listOfBuckets = typed.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listOfBuckets;
	}

}
