package com.uca.capas.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Mensaje;
import com.uca.capas.domain.Libro;
import com.uca.capas.service.CategoriaService;
import com.uca.capas.service.LibroService;

@Controller
public class MainController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	LibroService libroService;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("mensaje", new Mensaje(""));
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/ingresarCategoria")
	public ModelAndView ingresarCAtegoria() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoria", new Categoria());
		mav.setViewName("ingresarCategoria");
		return mav;
	}
	
	@PostMapping("/newCategoria")
	public ModelAndView newCategoria(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		
		ModelAndView mav = new ModelAndView(); 
		if(!result.hasErrors()) {
			try {
				categoriaService.insert(categoria);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			categoria = new Categoria();
			mav.addObject("categoria", categoria);
			
		}
		mav.addObject("mensaje", new Mensaje("Categoria Ingresada con EXITO"));
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/igresarLibro")
	public ModelAndView ingresarLibro() {
		ModelAndView mav = new ModelAndView();
		List<Categoria> categorias = null;
		try {
			categorias = categoriaService.findAll();
		}catch (Exception e){
			e.printStackTrace();
		}
		mav.addObject("ListCategoria", categorias);
		mav.addObject("libro", new Libro());
		mav.setViewName("ingresarLibro");
		return mav;
	}
	
	@PostMapping("/newLibro")
	public ModelAndView newLibro(@Valid @ModelAttribute Libro libro, BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
	    Date date = new Date();  
		
		if(!result.hasErrors()) {
			try {
				libro.setFecha(date);
				libroService.insert(libro);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			libro = new Libro();
			mav.addObject("libro", libro);
			
		}		
		mav.addObject("mensaje", new Mensaje("Libro ingresado con EXITO"));
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/deleteLibro")
	public String deleteLibro(@RequestParam Integer codigo) {
		Libro libro = libroService.findOne(codigo);
			try {
				
				libroService.delete(libro);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		return "redirect:/listado";
		
	}
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		
		List<Libro> libros = null;
		try {
			
			libros = libroService.findAll();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("libros", libros);
		mav.setViewName("listado");
		
		return mav;
	}
	
}