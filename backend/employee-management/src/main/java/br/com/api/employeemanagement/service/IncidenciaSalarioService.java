/**
 * 
 */
package br.com.api.employeemanagement.service;

import java.io.Serializable;

import br.com.api.employeemanagement.domain.IncidenciaSalario;

/**
 * @author Delano Jr
 *
 */
public interface IncidenciaSalarioService extends Serializable {

	public IncidenciaSalario save(IncidenciaSalario incidenciaSalario);

	public Iterable<IncidenciaSalario> saveIncidenciaSalarios(Iterable<IncidenciaSalario> incidenciasSalario);

	public Iterable<IncidenciaSalario> findAll();

	public IncidenciaSalario findIncidenciaSalarioById(String incidenciaSalarioId);

	public IncidenciaSalario removeIncidenciaSalarioById(String incidenciaSalarioId);

	public IncidenciaSalario removeIncidenciaSalario(IncidenciaSalario incidenciaSalario);
}
