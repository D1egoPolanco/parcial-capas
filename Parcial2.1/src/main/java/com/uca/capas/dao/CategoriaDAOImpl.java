package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Categoria;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO{
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM cat_categoria");
		Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);
		List<Categoria> resultset = query.getResultList();
		
		return resultset;
	}

	@Override
	@Transactional
	public Categoria findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return  entityManager.find(Categoria.class, codigo);
	}

	@Override
	@Transactional
	public void insert(Categoria categoria) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if(categoria.getCodigo()==null)
				entityManager.persist(categoria);
			else {
				entityManager.merge(categoria);
				entityManager.flush();
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	@Transactional
	public void delete(Categoria categoria) throws DataAccessException {
		// TODO Auto-generated method stub
		entityManager.remove(categoria);
	}

}
