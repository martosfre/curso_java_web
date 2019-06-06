package com.matoosfe.ecommerce.modelo;
// Generated 05/06/2019 19:11:01 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TipoProducto generated by hbm2java
 */
@Entity
@Table(name = "tipo_producto")
public class TipoProducto implements java.io.Serializable {

	private int idTipPro;
	private String nombreTipPro;
	private String descripcionTipPro;
	private Set<Producto> productos = new HashSet<Producto>(0);

	public TipoProducto() {
	}

	public TipoProducto(int idTipPro, String nombreTipPro) {
		this.idTipPro = idTipPro;
		this.nombreTipPro = nombreTipPro;
	}

	public TipoProducto(int idTipPro, String nombreTipPro, String descripcionTipPro, Set<Producto> productos) {
		this.idTipPro = idTipPro;
		this.nombreTipPro = nombreTipPro;
		this.descripcionTipPro = descripcionTipPro;
		this.productos = productos;
	}

	@Id

	@Column(name = "id_tip_pro", unique = true, nullable = false)
	public int getIdTipPro() {
		return this.idTipPro;
	}

	public void setIdTipPro(int idTipPro) {
		this.idTipPro = idTipPro;
	}

	@Column(name = "nombre_tip_pro", nullable = false, length = 25)
	public String getNombreTipPro() {
		return this.nombreTipPro;
	}

	public void setNombreTipPro(String nombreTipPro) {
		this.nombreTipPro = nombreTipPro;
	}

	@Column(name = "descripcion_tip_pro", length = 200)
	public String getDescripcionTipPro() {
		return this.descripcionTipPro;
	}

	public void setDescripcionTipPro(String descripcionTipPro) {
		this.descripcionTipPro = descripcionTipPro;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoProducto")
	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

}
