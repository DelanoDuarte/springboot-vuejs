/**
 * 
 */
package br.com.api.employeemanagement.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Delano Jr
 *
 */
@Document(collection = "funcionario")
public class Funcionario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String idFuncinario;

	@Field
	private String nomeFuncionario;

	@Field
	private BigDecimal salarioFuncionario;

	@Field
	private boolean funciarioAtivo;

	@Field
	private LocalDate dataCadastro;

	@Field
	private LocalDate dataNascimento;

	@Field
	private String flagSexo;

	@Field
	@DBRef
	private Cargo funcionarioCargo;

	@Field
	@DBRef
	private Set<IncidenciaSalario> funcionarioInncidenciasSalario;

	public String getIdFuncinario() {
		return idFuncinario;
	}

	public void setIdFuncinario(String idFuncinario) {
		this.idFuncinario = idFuncinario;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public BigDecimal getSalarioFuncionario() {
		return salarioFuncionario;
	}

	public void setSalarioFuncionario(BigDecimal salarioFuncionario) {
		this.salarioFuncionario = salarioFuncionario;
	}

	public boolean isFunciarioAtivo() {
		return funciarioAtivo;
	}

	public void setFunciarioAtivo(boolean funciarioAtivo) {
		this.funciarioAtivo = funciarioAtivo;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getFlagSexo() {
		return flagSexo;
	}

	public void setFlagSexo(String flagSexo) {
		this.flagSexo = flagSexo;
	}

	public Cargo getFuncionarioCargo() {
		return funcionarioCargo;
	}

	public void setFuncionarioCargo(Cargo funcionarioCargo) {
		this.funcionarioCargo = funcionarioCargo;
	}

	public Set<IncidenciaSalario> getFuncionarioInncidenciasSalario() {
		return funcionarioInncidenciasSalario;
	}

	public void setFuncionarioInncidenciasSalario(Set<IncidenciaSalario> funcionarioInncidenciasSalario) {
		this.funcionarioInncidenciasSalario = funcionarioInncidenciasSalario;
	}

}
