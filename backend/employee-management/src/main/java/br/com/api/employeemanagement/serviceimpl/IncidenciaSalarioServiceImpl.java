/**
 * 
 */
package br.com.api.employeemanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.employeemanagement.domain.IncidenciaSalario;
import br.com.api.employeemanagement.repository.IncidenciaSalarioRepository;
import br.com.api.employeemanagement.service.IncidenciaSalarioService;

/**
 * @author Delano Jr
 *
 */
@Service
public class IncidenciaSalarioServiceImpl implements IncidenciaSalarioService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IncidenciaSalarioRepository incidenciaSalarioRepository;

	@Override
	public IncidenciaSalario save(IncidenciaSalario incidenciaSalario) {
		return incidenciaSalarioRepository.save(incidenciaSalario);
	}

	@Override
	public Iterable<IncidenciaSalario> saveIncidenciaSalarios(Iterable<IncidenciaSalario> incidenciasSalario) {
		return incidenciaSalarioRepository.save(incidenciasSalario);
	}

	@Override
	public Iterable<IncidenciaSalario> findAll() {
		return incidenciaSalarioRepository.findAll();
	}

	@Override
	public IncidenciaSalario findIncidenciaSalarioById(String incidenciaSalarioId) {
		return incidenciaSalarioRepository.findOne(incidenciaSalarioId);
	}

	@Override
	public IncidenciaSalario removeIncidenciaSalarioById(String incidenciaSalarioId) {
		IncidenciaSalario incidenciaSalario = findIncidenciaSalarioById(incidenciaSalarioId);
		incidenciaSalarioRepository.delete(incidenciaSalario);
		return null;
	}

	@Override
	public IncidenciaSalario removeIncidenciaSalario(IncidenciaSalario incidenciaSalario) {
		return null;
	}

}
