/**
 * 
 */
package br.com.api.employeemanagement.calculos;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.api.employeemanagement.domain.Funcionario;
import br.com.api.employeemanagement.domain.IncidenciaSalario;
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

		Double salarioFuncionario = funcionario.getSalarioFuncionario().doubleValue();
		Double salarioCalculado = 0.0;

		try {
			if (funcionario.getFuncionarioCargo().getCargoIncidenciasSalario().isEmpty()) {
				return 0.0;
			}

			for (IncidenciaSalario cargoIs : funcionario.getFuncionarioCargo().getCargoIncidenciasSalario()) {

				if (cargoIs.getTipoIncidenciaSalario().equals(TipoIncidenciaSalario.GRATIFICACAO)) {
					salarioFuncionario += cargoIs.getValorIncidenciaSalario().doubleValue();
				}

				if (cargoIs.getTipoIncidenciaSalario().equals(TipoIncidenciaSalario.DESCONTO)) {
					salarioFuncionario -= cargoIs.getValorIncidenciaSalario().doubleValue();
				}

			}

			funcionario.setSalarioCalculadoFuncionario(new BigDecimal(salarioFuncionario));
			salarioCalculado = funcionario.getSalarioCalculadoFuncionario().doubleValue();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return salarioCalculado;
	}
}
