package com.uca.capas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.CategoriaDAO;
import com.uca.capas.domain.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	CategoriaDAO categoriaDAO;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return categoriaDAO.findAll();
	}

	@Override
	@Transactional
	public void insert(Categoria categoria) throws DataAccessException {
		// TODO Auto-generated method stub
		categoriaDAO.insert(categoria);
	}

	@Override
	@Transactional
	public void delete(Categoria categoria) throws DataAccessException {
		// TODO Auto-generated method stub
		categoriaDAO.delete(categoria);
	}

	@Override
	public Categoria findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return categoriaDAO.findOne(codigo);
	}

}
