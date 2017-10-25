/**
 * 
 */
package br.com.api.employeemanagement.serviceimpl;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.employeemanagement.calculos.CalculoIncidenciasCargo;
import br.com.api.employeemanagement.calculos.CalculoIncidenciasFuncionario;
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

	@Autowired
	private CalculoIncidenciasFuncionario calculoIncidenciasFuncionario;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.api.employeemanagement.service.FuncionarioService#save(br.com.api.
	 * employeemanagement.domain.Funcionario) Método para salvar um novo
	 * funcionario no sistema. Todos os funcionários começam ativos,
	 * posteriormente podendo ser desativados. Nesse método, tambem chama-se as
	 * Classes auxiliares de calcula do salario, definindo aqui o valor final do
	 * salário do funcionário
	 */
	@Override
	public Funcionario save(Funcionario funcionario) {

		funcionario.setFunciarioAtivo(true);
		funcionario.setDataCadastro(LocalDate.now());

		Double incidenciasSalariais = calculoIncidenciasCargo.calcularSalarioFuncionario(funcionario)
				+ calculoIncidenciasFuncionario.calcularSalarioFuncionario(funcionario);
		Double salarioCalculado = funcionario.getSalarioFuncionario().doubleValue() + incidenciasSalariais;

		funcionario.setSalarioCalculadoFuncionario(new BigDecimal(salarioCalculado));
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
