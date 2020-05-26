package com.uca.capas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.CategoriaDAO;
import com.uca.capas.dao.LibroDAO;
import com.uca.capas.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	LibroDAO libroDAO;

	@Override
	public List<Libro> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return libroDAO.findAll();
	}

	@Override
	@Transactional
	public void insert(Libro libro) throws DataAccessException {
		// TODO Auto-generated method stub
		libroDAO.insert(libro);
	}

	@Override
	@Transactional
	public void delete(Libro libro) throws DataAccessException {
		// TODO Auto-generated method stub
		libroDAO.delete(libro);
	}

	@Override
	public Libro findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return libroDAO.findOne(codigo);
	}

}
