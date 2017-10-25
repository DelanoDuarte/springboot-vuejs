/**
 * 
 */
package br.com.api.employeemanagement.calculos;

import java.io.Serializable;

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

	/*
	 * Método que calculas as incidencias salariais, atreladas a um cargo. O
	 * retorno do método é o valor somado de todas as incidencias.
	 */
	public Double calcularSalarioFuncionario(Funcionario funcionario) {

		Double incidencias = new Double(0.0);

		try {
			if (funcionario.getFuncionarioCargo().getCargoIncidenciasSalario().isEmpty()) {
				return 0.0;
			}

			for (IncidenciaSalario cargoIs : funcionario.getFuncionarioCargo().getCargoIncidenciasSalario()) {

				if (cargoIs.getTipoIncidenciaSalario().equals(TipoIncidenciaSalario.GRATIFICACAO)) {
					incidencias += cargoIs.getValorIncidenciaSalario().doubleValue();
				}

				if (cargoIs.getTipoIncidenciaSalario().equals(TipoIncidenciaSalario.DESCONTO)) {
					incidencias -= cargoIs.getValorIncidenciaSalario().doubleValue();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return incidencias;
	}
}
