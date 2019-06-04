package com.matoosfe.ecommerce.modelo;
// Generated 03/06/2019 20:42:35 by Hibernate Tools 5.2.12.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Factura generated by hbm2java
 */
@Entity
@Table(name = "factura")
public class Factura implements java.io.Serializable {

	private int idFac;
	private Cliente cliente;
	private String facNumero;
	private Date fechaFac;
	private BigDecimal subtotalFac;
	private BigDecimal ivaFac;
	private BigDecimal totalFac;
	private Set<DetalleFactura> detalleFacturas = new HashSet<DetalleFactura>(0);

	public Factura() {
	}

	public Factura(int idFac, Cliente cliente, String facNumero, Date fechaFac, BigDecimal subtotalFac,
			BigDecimal ivaFac, BigDecimal totalFac) {
		this.idFac = idFac;
		this.cliente = cliente;
		this.facNumero = facNumero;
		this.fechaFac = fechaFac;
		this.subtotalFac = subtotalFac;
		this.ivaFac = ivaFac;
		this.totalFac = totalFac;
	}

	public Factura(int idFac, Cliente cliente, String facNumero, Date fechaFac, BigDecimal subtotalFac,
			BigDecimal ivaFac, BigDecimal totalFac, Set<DetalleFactura> detalleFacturas) {
		this.idFac = idFac;
		this.cliente = cliente;
		this.facNumero = facNumero;
		this.fechaFac = fechaFac;
		this.subtotalFac = subtotalFac;
		this.ivaFac = ivaFac;
		this.totalFac = totalFac;
		this.detalleFacturas = detalleFacturas;
	}

	@Id

	@Column(name = "id_fac", unique = true, nullable = false)
	public int getIdFac() {
		return this.idFac;
	}

	public void setIdFac(int idFac) {
		this.idFac = idFac;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cli", nullable = false)
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Column(name = "fac_numero", nullable = false, length = 16)
	public String getFacNumero() {
		return this.facNumero;
	}

	public void setFacNumero(String facNumero) {
		this.facNumero = facNumero;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fac", nullable = false, length = 10)
	public Date getFechaFac() {
		return this.fechaFac;
	}

	public void setFechaFac(Date fechaFac) {
		this.fechaFac = fechaFac;
	}

	@Column(name = "subtotal_fac", nullable = false, precision = 10)
	public BigDecimal getSubtotalFac() {
		return this.subtotalFac;
	}

	public void setSubtotalFac(BigDecimal subtotalFac) {
		this.subtotalFac = subtotalFac;
	}

	@Column(name = "iva_fac", nullable = false, precision = 10)
	public BigDecimal getIvaFac() {
		return this.ivaFac;
	}

	public void setIvaFac(BigDecimal ivaFac) {
		this.ivaFac = ivaFac;
	}

	@Column(name = "total_fac", nullable = false, precision = 10)
	public BigDecimal getTotalFac() {
		return this.totalFac;
	}

	public void setTotalFac(BigDecimal totalFac) {
		this.totalFac = totalFac;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "factura")
	public Set<DetalleFactura> getDetalleFacturas() {
		return this.detalleFacturas;
	}

	public void setDetalleFacturas(Set<DetalleFactura> detalleFacturas) {
		this.detalleFacturas = detalleFacturas;
	}

}