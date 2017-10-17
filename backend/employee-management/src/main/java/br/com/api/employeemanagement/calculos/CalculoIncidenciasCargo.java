/**
 * 
 */
package br.com.api.employeemanagement.calculos;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.api.employeemanagement.domain.Funcionario;
import br.com.api.employeemanagement.domain.TipoIncidenciaSalario;

/**
 * @author Delano Jr
 *
 */
@Service
public class CalculoIncidenciasCargo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Double calcularSalarioFuncionario(Funcionario funcionario) {

		BigDecimal salarioFuncionario = null;

		try {
			if (funcionario.getFuncionarioCargo().getCargoIncidenciasSalario().isEmpty()) {
				return 0.0;
			}

			funcionario.getFuncionarioCargo().getCargoIncidenciasSalario().stream().forEach(cargoIs -> {

				double salarioGratificacao = 0.0;
				double salarioDesconto = 0.0;

				if (cargoIs.getTipoIncidenciaSalario().equals(TipoIncidenciaSalario.GRATIFICACAO)) {
					salarioGratificacao = funcionario.getSalarioFuncionario().doubleValue()
							+ cargoIs.getValorIncidenciaSalario().doubleValue();
				}

				if (cargoIs.getTipoIncidenciaSalario().equals(TipoIncidenciaSalario.DESCONTO)) {
					salarioDesconto = funcionario.getSalarioFuncionario().doubleValue()
							- cargoIs.getValorIncidenciaSalario().doubleValue();
				}

				BigDecimal salario = new BigDecimal(salarioGratificacao + salarioDesconto);
				//salarioFuncionario = salario;
			});

		} catch (Exception e) {

		}

		return salarioFuncionario.doubleValue();
	}
}
