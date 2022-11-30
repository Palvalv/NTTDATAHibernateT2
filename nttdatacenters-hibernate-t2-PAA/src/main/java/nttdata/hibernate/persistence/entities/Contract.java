package nttdata.hibernate.persistence.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entity Class Contract
 */
@Entity
@Table(name = "TABLA_CONTRATO")
public class Contract extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long contractID;
	private String fechaValida;
	private String fechaExpiracion;
	private Double precioMes;
	private Client client;

	/**
	 * @return contractID
	 */
	@Transient
	@Override
	public Long getId() {
		return getIdContract();
	}

	/**
	 * @return contractID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTRACT_ID", unique = true)
	public Long getIdContract() {
		return this.contractID;
	}

	/**
	 * @param establecer contractID
	 */
	public void setIdContract(Long contractID) {
		this.contractID = contractID;
	}

	/**
	 * @return fechaValida
	 */
	@Column(name = "FECHA_VALIDA")
	public String getValidatyDate() {
		return this.fechaValida;
	}

	/**
	 * @param establecer fechaValida
	 */
	public void setValidatyDate(String fechaValida) {
		this.fechaValida = fechaValida;
	}

	/**
	 * @return fechaExpiracion
	 */
	@Column(name = "FECHA_EXPIRACION")
	public String getExpirationDate() {
		return this.fechaExpiracion;
	}

	/**
	 * @param establecer fechaExpiracion
	 */
	public void setExpirationDate(String fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	/**
	 * @return precioMes
	 */
	@Column(name = "PRECIO_MES")
	public Double getPriceMonth() {
		return this.precioMes;
	}

	/**
	 * @param establecer precioMes
	 */
	public void setPriceMonth(Double precioMes) {
		this.precioMes = precioMes;
	}
	
	/**
	 * @return
	 */
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CLIENT_ID_FK")
	public Client getClient() {
		return this.client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
}

