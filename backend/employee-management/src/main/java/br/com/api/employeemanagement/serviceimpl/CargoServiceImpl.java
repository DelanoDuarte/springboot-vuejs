/**
 * 
 */
package br.com.api.employeemanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.employeemanagement.domain.Cargo;
import br.com.api.employeemanagement.repository.CargoRepository;
import br.com.api.employeemanagement.service.CargoService;

/**
 * @author Delano Jr
 *
 */
@Service
public class CargoServiceImpl implements CargoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private CargoRepository cargoRepository;

	@Override
	public Cargo save(Cargo cargo) {
		return cargoRepository.save(cargo);
	}

	@Override
	public Iterable<Cargo> saveCargos(Iterable<Cargo> cargos) {
		return cargoRepository.save(cargos);
	}

	@Override
	public Iterable<Cargo> findAll() {
		return cargoRepository.findAll();
	}

	@Override
	public Cargo findCargoById(String cargoId) {
		return cargoRepository.findOne(cargoId);
	}

	@Override
	public Cargo removeCargoById(String cargoId) {
		Cargo cargo = cargoRepository.findOne(cargoId);
		cargoRepository.delete(cargo.getIdCargo());
		return cargo;
	}

	@Override
	public Cargo removeCargo(Cargo cargo) {
		Cargo cargoDelete = cargoRepository.findOne(cargo.getIdCargo());
		cargoRepository.delete(cargoDelete);
		return cargoDelete;
	}

}
