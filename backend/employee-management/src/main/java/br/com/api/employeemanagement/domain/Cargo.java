/**
 * 
 */
package br.com.api.employeemanagement.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Delano Jr
 *
 */
@Document(collection = "cargo")
public class Cargo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String idCargo;

	@Field
	private String dscCargo;

	@Field
	private boolean cargoAtivo;

	@DBRef(lazy = true)
	private Setor cargoSetor;

	@DBRef(lazy = true)
	private List<IncidenciaSalario> cargoIncidenciasSalario;

	public String getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(String idCargo) {
		this.idCargo = idCargo;
	}

	public String getDscCargo() {
		return dscCargo;
	}

	public void setDscCargo(String dscCargo) {
		this.dscCargo = dscCargo;
	}

	public boolean isCargoAtivo() {
		return cargoAtivo;
	}

	public void setCargoAtivo(boolean cargoAtivo) {
		this.cargoAtivo = cargoAtivo;
	}

	public List<IncidenciaSalario> getCargoIncidenciasSalario() {
		return cargoIncidenciasSalario;
	}

	public void setCargoIncidenciasSalario(List<IncidenciaSalario> cargoIncidenciasSalario) {
		this.cargoIncidenciasSalario = cargoIncidenciasSalario;
	}

	public Setor getCargoSetor() {
		return cargoSetor;
	}

	public void setCargoSetor(Setor cargoSetor) {
		this.cargoSetor = cargoSetor;
	}

}
