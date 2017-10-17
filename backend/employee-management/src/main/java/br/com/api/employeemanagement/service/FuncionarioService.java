/**
 * 
 */
package br.com.api.employeemanagement.service;

import java.io.Serializable;

import br.com.api.employeemanagement.domain.Funcionario;

/**
 * @author Delano Jr
 *
 */
public interface FuncionarioService extends Serializable {

	public Funcionario save(Funcionario funcionario);

	public Iterable<Funcionario> saveFuncionarios(Iterable<Funcionario> funcionario);

	public Iterable<Funcionario> findAll();

	public Funcionario findFuncionarioById(String funcionarioId);

	public Funcionario removeFuncionarioById(String funcionarioId);

	public Funcionario removeFuncionario(Funcionario funcionario);
}
