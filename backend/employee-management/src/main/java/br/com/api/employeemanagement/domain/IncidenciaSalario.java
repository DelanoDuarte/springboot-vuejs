/**
 * 
 */
package br.com.api.employeemanagement.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Delano Jr
 *
 */
@Document(collection = "incidencia_salario")
public class IncidenciaSalario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String idIncidenciaSalario;

	@Field
	private String nomeIncidenciaSalario;

	@Field
	private BigDecimal valorIncidenciaSalario;

	@Field
	private TipoIncidenciaSalario tipoIncidenciaSalario;

	public String getIdIncidenciaSalario() {
		return idIncidenciaSalario;
	}

	public void setIdIncidenciaSalario(String idIncidenciaSalario) {
		this.idIncidenciaSalario = idIncidenciaSalario;
	}

	public String getNomeIncidenciaSalario() {
		return nomeIncidenciaSalario;
	}

	public void setNomeIncidenciaSalario(String nomeIncidenciaSalario) {
		this.nomeIncidenciaSalario = nomeIncidenciaSalario;
	}

	public BigDecimal getValorIncidenciaSalario() {
		return valorIncidenciaSalario;
	}

	public void setValorIncidenciaSalario(BigDecimal valorIncidenciaSalario) {
		this.valorIncidenciaSalario = valorIncidenciaSalario;
	}

	public TipoIncidenciaSalario getTipoIncidenciaSalario() {
		return tipoIncidenciaSalario;
	}

	public void setTipoIncidenciaSalario(TipoIncidenciaSalario tipoIncidenciaSalario) {
		this.tipoIncidenciaSalario = tipoIncidenciaSalario;
	}

}
