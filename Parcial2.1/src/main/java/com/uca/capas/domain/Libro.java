package com.uca.capas.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="cat_libro")
public class Libro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_libro")
	private Integer codigo;
	
	@Column(name="s_titulo")
	@Size(message = "El titulo no debe tener mas de 500 caracteres", max = 500)
	@NotEmpty(message = "Este campo no puede estar vacio")
	private String titulo;
	
	@Column(name="s_autor")
	@Size(message = "El autor no debe tener mas de 150 caracteres", max = 150)
	@NotEmpty(message = "Este campo no puede estar vacio")
	private String autor;
	
	@Column(name="s_isbn")
	@Size(message = "El autor no debe tener mas de 10 caracteres", max = 10)
	@NotEmpty(message = "Este campo no puede estar vacio")
	private String isbn;
	
	@Column(name="f_ingreso")
	private Date fecha;
	
	@Column(name="b_estado")
	private Boolean estado;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="c_categoria")
	private Categoria categoria;

	public Libro() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getEstadoDelegate() {
		if (this.estado == null) {
			return "";
		}else {
			if (this.estado) return "ACTIVO";
			return "INACTIVO";
		}
	}
}
