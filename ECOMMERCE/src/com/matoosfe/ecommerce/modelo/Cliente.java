package com.matoosfe.ecommerce.modelo;
// Generated 05/06/2019 19:11:01 by Hibernate Tools 5.2.12.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GeneratorType;

/**
 * Cliente generated by hbm2java
 */
@Entity //Anotación para representar una entidad que manipula información - obligatorio
/*
 * Anotación para denotar a cual tabla representa la clase, es opcional y se coloca cuando el nombre
 * de la clase es diferente al de tabla.
 */
@Table(name = "cliente") 
public class Cliente implements java.io.Serializable {

	private int idCli;
	private String nombrePer;
	private String apellidoPer;
	private String identificacionPer;
	private Date fechaNacPer;
	private String direccionPer;
	private String telefonoPer;
	private String correoPer;
	private BigDecimal cuotaVenCli;
	private Set<Factura> facturas = new HashSet<Factura>(0);

	public Cliente() {
	}

	public Cliente(int idCli, String nombrePer, String apellidoPer, String identificacionPer, String direccionPer,
			String telefonoPer, String correoPer) {
		this.idCli = idCli;
		this.nombrePer = nombrePer;
		this.apellidoPer = apellidoPer;
		this.identificacionPer = identificacionPer;
		this.direccionPer = direccionPer;
		this.telefonoPer = telefonoPer;
		this.correoPer = correoPer;
	}

	public Cliente(int idCli, String nombrePer, String apellidoPer, String identificacionPer, Date fechaNacPer,
			String direccionPer, String telefonoPer, String correoPer, BigDecimal cuotaVenCli, Set<Factura> facturas) {
		this.idCli = idCli;
		this.nombrePer = nombrePer;
		this.apellidoPer = apellidoPer;
		this.identificacionPer = identificacionPer;
		this.fechaNacPer = fechaNacPer;
		this.direccionPer = direccionPer;
		this.telefonoPer = telefonoPer;
		this.correoPer = correoPer;
		this.cuotaVenCli = cuotaVenCli;
		this.facturas = facturas;
	}

	@Id //Anotación que representa la PK y es obligatorio
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Como se genera esa clave, IDENTITY es automático
	/*
	 * Anotación para denotar a cual columna de la tabla representa el atributo de la clase, 
	 * es opcional y se coloca cuando el nombre del atributo es diferente al de columna.
	 */
	@Column(name = "id_cli", unique = true, nullable = false)
	public int getIdCli() {
		return this.idCli;
	}

	public void setIdCli(int idCli) {
		this.idCli = idCli;
	}

	@Column(name = "nombre_per", nullable = false, length = 25)
	public String getNombrePer() {
		return this.nombrePer;
	}

	public void setNombrePer(String nombrePer) {
		this.nombrePer = nombrePer;
	}

	@Column(name = "apellido_per", nullable = false, length = 25)
	public String getApellidoPer() {
		return this.apellidoPer;
	}

	public void setApellidoPer(String apellidoPer) {
		this.apellidoPer = apellidoPer;
	}

	@Column(name = "identificacion_per", nullable = false, length = 13)
	public String getIdentificacionPer() {
		return this.identificacionPer;
	}

	public void setIdentificacionPer(String identificacionPer) {
		this.identificacionPer = identificacionPer;
	}

	@Temporal(TemporalType.DATE)//Anotación para manipular fechas
	@Column(name = "fecha_nac_per", length = 10)
	public Date getFechaNacPer() {
		return this.fechaNacPer;
	}

	public void setFechaNacPer(Date fechaNacPer) {
		this.fechaNacPer = fechaNacPer;
	}

	@Column(name = "direccion_per", nullable = false, length = 45)
	public String getDireccionPer() {
		return this.direccionPer;
	}

	public void setDireccionPer(String direccionPer) {
		this.direccionPer = direccionPer;
	}

	@Column(name = "telefono_per", nullable = false, length = 10)
	public String getTelefonoPer() {
		return this.telefonoPer;
	}

	public void setTelefonoPer(String telefonoPer) {
		this.telefonoPer = telefonoPer;
	}

	@Column(name = "correo_per", nullable = false, length = 45)
	public String getCorreoPer() {
		return this.correoPer;
	}

	public void setCorreoPer(String correoPer) {
		this.correoPer = correoPer;
	}

	@Column(name = "cuota_ven_cli", precision = 10)
	public BigDecimal getCuotaVenCli() {
		return this.cuotaVenCli;
	}

	public void setCuotaVenCli(BigDecimal cuotaVenCli) {
		this.cuotaVenCli = cuotaVenCli;
	}

	//Anotación para mapear una relación de uno a muchos
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	public Set<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(Set<Factura> facturas) {
		this.facturas = facturas;
	}

}
