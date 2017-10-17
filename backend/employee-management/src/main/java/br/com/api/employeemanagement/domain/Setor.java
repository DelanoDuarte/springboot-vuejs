/**
 * 
 */
package br.com.api.employeemanagement.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Delano Jr
 *
 */
@Document
public class Setor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String setorId;

	@Field
	private String dscSetor;

	@Field
	private boolean setorAtivo;

	@Field
	private Integer numFuncionarios;

	public String getSetorId() {
		return setorId;
	}

	public void setSetorId(String setorId) {
		this.setorId = setorId;
	}

	public String getDscSetor() {
		return dscSetor;
	}

	public void setDscSetor(String dscSetor) {
		this.dscSetor = dscSetor;
	}

	public boolean isSetorAtivo() {
		return setorAtivo;
	}

	public void setSetorAtivo(boolean setorAtivo) {
		this.setorAtivo = setorAtivo;
	}

	public Integer getNumFuncionarios() {
		return numFuncionarios;
	}

	public void setNumFuncionarios(Integer numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}

}
