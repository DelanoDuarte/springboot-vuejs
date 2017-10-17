/**
 * 
 */
package br.com.api.employeemanagement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.api.employeemanagement.domain.Cargo;
import br.com.api.employeemanagement.domain.IncidenciaSalario;
import br.com.api.employeemanagement.domain.Setor;
import br.com.api.employeemanagement.domain.TipoIncidenciaSalario;
import br.com.api.employeemanagement.service.CargoService;
import br.com.api.employeemanagement.service.IncidenciaSalarioService;
import br.com.api.employeemanagement.service.SetorService;

/**
 * @author Delano Jr
 *
 */
@Component
public class AppInitialize implements Serializable, CommandLineRunner {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private CargoService cargoService;

	@Autowired
	private IncidenciaSalarioService incidenciaSalarioService;

	@Autowired
	private SetorService setorService;

	@Override
	public void run(String... args) throws Exception {

		IncidenciaSalario incidenciaSalario = new IncidenciaSalario();
		incidenciaSalario.setNomeIncidenciaSalario("Gratificação 1");
		incidenciaSalario.setValorIncidenciaSalario(new BigDecimal(124.41));
		incidenciaSalario.setTipoIncidenciaSalario(TipoIncidenciaSalario.GRATIFICACAO);

		IncidenciaSalario incidenciaSalario1 = new IncidenciaSalario();
		incidenciaSalario1.setNomeIncidenciaSalario("Gratificação 2");
		incidenciaSalario1.setValorIncidenciaSalario(new BigDecimal(541.56));
		incidenciaSalario1.setTipoIncidenciaSalario(TipoIncidenciaSalario.GRATIFICACAO);

		IncidenciaSalario incidenciaSalario2 = new IncidenciaSalario();
		incidenciaSalario2.setNomeIncidenciaSalario("Desconto 1");
		incidenciaSalario2.setValorIncidenciaSalario(new BigDecimal(354.25));
		incidenciaSalario2.setTipoIncidenciaSalario(TipoIncidenciaSalario.DESCONTO);

		IncidenciaSalario incidenciaSalario3 = new IncidenciaSalario();
		incidenciaSalario3.setNomeIncidenciaSalario("Desconto 2");
		incidenciaSalario3.setValorIncidenciaSalario(new BigDecimal(184.12));
		incidenciaSalario3.setTipoIncidenciaSalario(TipoIncidenciaSalario.DESCONTO);

		incidenciaSalarioService.save(incidenciaSalario);
		incidenciaSalarioService.save(incidenciaSalario1);
		incidenciaSalarioService.save(incidenciaSalario2);
		incidenciaSalarioService.save(incidenciaSalario3);

		List<IncidenciaSalario> incidenciasSalariais = new ArrayList<>();
		incidenciasSalariais.add(incidenciaSalario);
		incidenciasSalariais.add(incidenciaSalario1);
		incidenciasSalariais.add(incidenciaSalario2);
		incidenciasSalariais.add(incidenciaSalario3);

		Setor setor1 = new Setor();
		setor1.setSetorAtivo(true);
		setor1.setDscSetor("T.I.");
		setor1.setNumFuncionarios(0);

		Setor setor2 = new Setor();
		setor2.setSetorAtivo(true);
		setor2.setDscSetor("Recursos Humanos");
		setor2.setNumFuncionarios(0);

		Setor setor3 = new Setor();
		setor3.setSetorAtivo(true);
		setor3.setDscSetor("Administrativo");
		setor3.setNumFuncionarios(0);

		Setor setor4 = new Setor();
		setor4.setSetorAtivo(true);
		setor4.setDscSetor("Financeiro");
		setor4.setNumFuncionarios(0);

		setorService.save(setor1);
		setorService.save(setor2);
		setorService.save(setor3);
		setorService.save(setor4);

		Cargo cargo = new Cargo();
		cargo.setDscCargo("Programador");
		cargo.setCargoAtivo(true);
		cargo.setCargoIncidenciasSalario(incidenciasSalariais);
		cargo.setCargoSetor(setor1);

		cargoService.save(cargo);
	}

}
