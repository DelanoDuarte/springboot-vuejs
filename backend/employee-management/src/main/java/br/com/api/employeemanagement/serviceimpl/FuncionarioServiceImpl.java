/**
 * 
 */
package br.com.api.employeemanagement.serviceimpl;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.employeemanagement.calculos.CalculoIncidenciasCargo;
import br.com.api.employeemanagement.domain.Funcionario;
import br.com.api.employeemanagement.repository.FuncionarioRepository;
import br.com.api.employeemanagement.service.FuncionarioService;

/**
 * @author Delano Jr
 *
 */
@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private CalculoIncidenciasCargo calculoIncidenciasCargo;

	@Override
	public Funcionario save(Funcionario funcionario) {

		funcionario.setFunciarioAtivo(true);
		funcionario.setDataCadastro(LocalDate.now());

		funcionario.setSalarioCalculadoFuncionario(
				new BigDecimal(calculoIncidenciasCargo.calcularSalarioFuncionario(funcionario)));

		return funcionarioRepository.save(funcionario);
	}

	@Override
	public Iterable<Funcionario> saveFuncionarios(Iterable<Funcionario> funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	@Override
	public Iterable<Funcionario> findAll() {
		return funcionarioRepository.findAll();
	}

	@Override
	public Funcionario findFuncionarioById(String funcionarioId) {
		return funcionarioRepository.findOne(funcionarioId);
	}

	@Override
	public Funcionario removeFuncionarioById(String funcionarioId) {
		Funcionario funcionario = findFuncionarioById(funcionarioId);
		funcionarioRepository.delete(funcionario);
		return funcionario;
	}

	@Override
	public Funcionario removeFuncionario(Funcionario funcionario) {
		// TODO Auto-generated method stub
		return null;
	}

}
