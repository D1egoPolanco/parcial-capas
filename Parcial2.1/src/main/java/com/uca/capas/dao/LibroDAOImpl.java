package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO{

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Libro> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM cat_libro");
		Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
		List<Libro> resultset = query.getResultList();
		
		return resultset;
	}

	@Override
	public Libro findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return  entityManager.find(Libro.class, codigo);
	}

	@Override
	public void insert(Libro libro) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if(libro.getCodigo()==null)
				entityManager.persist(libro);
			else {
				entityManager.merge(libro);
				entityManager.flush();
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void delete(Libro libro) throws DataAccessException {
		// TODO Auto-generated method stub
		entityManager.remove(libro);
	}

}
