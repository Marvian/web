package com.digitel.adminvas.webService.adomain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "A_LISTA_NEGRA")
public class BlackList implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_lista_negra")
	@Column(name = "lne_id")
	private int id;
	
	@Column(name = "lne_numero_bloqueado")
	private int shortCodeBlocked;
	
	@Column(name = "lne_motivo")
	private String reason;
	
	@Column(name = "lne_fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(name = "lne_administrador")
	private String Admin;
	
	
	public int getShortCodeBlocked() {
		return shortCodeBlocked;
	}
	
	public void setShortCodeBlocked(int shortCodeBlocked) {
		this.shortCodeBlocked = shortCodeBlocked;
	}
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getAdmin() {
		return Admin;
	}
	
	public void setAdmin(String admin) {
		Admin = admin;
	}
	
	private static final long serialVersionUID = 1L;
}
