package com.sv.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes", catalog="clientes", schema="")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cliente_ID") 
    private Integer Cliente_ID;
	@Column
	private String Nombre_Usuario;
	@Column
	private String Contraseña;
	@Column
	private String Nombre;
	@Column
	private String Apellidos;
	@Column
	private String Correo_Electronico;
	@Column
	private Integer Edad;
	@Column
	private Float Estatura;
	@Column
	private Float Peso;
	@Column
	private Float IMC;
	@Column
	private Float GEB;
	@Column
	private Float ETA;
	@Column
	private String Fecha_Creacion;
	@Column
	private String Fecha_Actualizacion;
	
	public String getFecha_Creacion() {
		return Fecha_Creacion;
	}
	public void setFecha_Creacion(String fecha_Creacion) {
		Fecha_Creacion = fecha_Creacion;
	}
	public String getFecha_Actualizacion() {
		return Fecha_Actualizacion;
	}
	public void setFecha_Actualizacion(String fecha_Actualizacion) {
		Fecha_Actualizacion = fecha_Actualizacion;
	}
	public Integer getCliente_ID() {
		return Cliente_ID;
	}
	public void setCliente_ID(Integer cliente_ID) {
		Cliente_ID = cliente_ID;
	}
	public String getNombre_Usuario() {
		return Nombre_Usuario;
	}
	public void setNombre_Usuario(String nombre_Usuario) {
		Nombre_Usuario = nombre_Usuario;
	}
	public String getContraseña() {
		return Contraseña;
	}
	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getCorreo_Electronico() {
		return Correo_Electronico;
	}
	public void setCorreo_Electronico(String correo_Electronico) {
		Correo_Electronico = correo_Electronico;
	}
	public Integer getEdad() {
		return Edad;
	}
	public void setEdad(Integer edad) {
		Edad = edad;
	}
	public Float getEstatura() {
		return Estatura;
	}
	public void setEstatura(Float estatura) {
		Estatura = estatura;
	}
	public Float getPeso() {
		return Peso;
	}
	public void setPeso(Float peso) {
		Peso = peso;
	}
	public Float getIMC() {
		return IMC;
	}
	public void setIMC(Float iMC) {
		IMC = iMC;
	}
	public Float getGEB() {
		return GEB;
	}
	public void setGEB(Float gEB) {
		GEB = gEB;
	}
	public Float getETA() {
		return ETA;
	}
	public void setETA(Float eTA) {
		ETA = eTA;
	}
}
