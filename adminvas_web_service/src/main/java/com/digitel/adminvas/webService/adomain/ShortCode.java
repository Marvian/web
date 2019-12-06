package com.digitel.adminvas.webService.adomain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name= "A_NUMERO_CORTO")
public class ShortCode implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_NUMERO_CORTO")
	@SequenceGenerator(name = "SEQ_NUMERO_CORTO", allocationSize = 1)
	@Column(name = "nco_id")
	private int id;
	
	@Column(name = "nco_numero")
	private String shortCode;
	
	@Column(name = "nco_tipo_servicio")
	private String typeService;
	
	@Column(name = "nco_esme")
	private String ESME;
	
	@Column(name = "nco_fecha_apertura")
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_date;
	
	@Column(name = "nco_fecha_cierre")
	@Temporal(TemporalType.TIMESTAMP)
	private Date close_date;
	
	@Column(name = "nco_nombre_producto")
	private String productname;
	
	@Column(name = "nco_descripcion")
	private String description;
	
	@Column(name = "nco_trafico_estimado")
	private int approxtraffic;
	
	@Column(name = "nco_observaciones")
	private String observation;
	
	@Column(name = "nco_fk_add")
	private int addendum;
	
	@Column(name = "nco_fk_con")
	private int contrato;
	
	@Column(name = "nco_fk_umo")
	private int monetary;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getTypeService() {
		return typeService;
	}
	
	public void setTypeService(String typeService) {
		this.typeService = typeService;
	}
	
	public String getESME() {
		return ESME;
	}
	
	public void setESME(String eSME) {
		ESME = eSME;
	}
		
	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getClose_date() {
		return close_date;
	}

	public void setClose_date(Date close_date) {
		this.close_date = close_date;
	}

	public String getProductname() {
		return productname;
	}
	
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getApproxtraffic() {
		return approxtraffic;
	}
	
	public void setApproxtraffic(int approxtraffic) {
		this.approxtraffic = approxtraffic;
	}
	
	public String getObservation() {
		return observation;
	}
	
	public void setObservation(String observation) {
		this.observation = observation;
	}
	
	private static final long serialVersionUID = 1L;
	
	
	

}
