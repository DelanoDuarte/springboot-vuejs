/**
 * 
 */
package br.com.api.employeemanagement.service;

import java.io.Serializable;

import br.com.api.employeemanagement.domain.Cargo;

/**
 * @author Delano Jr
 *
 */
public interface CargoService extends Serializable {

	public Cargo save(Cargo cargo);

	public Iterable<Cargo> saveCargos(Iterable<Cargo> cargos);

	public Iterable<Cargo> findAll();

	public Cargo findCargoById(String cargoId);

	public Cargo removeCargoById(String cargoId);

	public Cargo removeCargo(Cargo cargo);

}
