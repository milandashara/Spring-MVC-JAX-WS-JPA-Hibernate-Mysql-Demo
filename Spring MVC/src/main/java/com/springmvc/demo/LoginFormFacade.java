package com.springmvc.demo;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class LoginFormFacade extends AbstractFacade<LoginForm> {

	public LoginFormFacade() {
		super(LoginForm.class);
	}

	public  boolean validateUser(String userName, String password) {
		CriteriaBuilder criteriaBuilder = getEntityManager()
				.getCriteriaBuilder();
		CriteriaQuery<LoginForm> criteriaQuery = criteriaBuilder
				.createQuery(LoginForm.class);
		Root<LoginForm> from = criteriaQuery.from(LoginForm.class);
		Predicate p1 = criteriaBuilder.equal(from.get("userName"), userName);
		Predicate p2 = criteriaBuilder.equal(from.get("password"), password);
		criteriaQuery.where(criteriaBuilder.and(p1, p2));
		TypedQuery<LoginForm> query = getEntityManager().createQuery(
				criteriaQuery);
		if (query.getResultList().size() > 0)
			return true;
		else
			return false;

	}
}
