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
public class CalculoIncidenciasFuncionario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Método responsavel por calcular as incidencias selecionadas para um
	 * funcionario, durante o cadastro do funcionario. Este método retorna a
	 * soma de todas as incidencias escolhidas pelo usuario para ser cadastrada.
	 */
	public Double calcularSalarioFuncionario(Funcionario funcionario) {

		if (funcionario.getFuncionarioInncidenciasSalario().isEmpty())
			return 0.0;

		Double incidencias = new Double(0.0);

		try {
			for (IncidenciaSalario ic : funcionario.getFuncionarioInncidenciasSalario()) {

				if (ic.getTipoIncidenciaSalario().equals(TipoIncidenciaSalario.GRATIFICACAO)) {
					incidencias += ic.getValorIncidenciaSalario().doubleValue();
				}

				if (ic.getTipoIncidenciaSalario().equals(TipoIncidenciaSalario.DESCONTO)) {
					incidencias -= ic.getValorIncidenciaSalario().doubleValue();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return incidencias;
	}
}
