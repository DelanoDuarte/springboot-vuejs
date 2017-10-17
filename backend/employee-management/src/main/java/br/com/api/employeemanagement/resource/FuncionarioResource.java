/**
 * 
 */
package br.com.api.employeemanagement.resource;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.employeemanagement.domain.Funcionario;
import br.com.api.employeemanagement.service.FuncionarioService;

/**
 * @author Delano Jr
 *
 */
@CrossOrigin(value = { "*" })
@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping("/all")
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok(funcionarioService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Funcionario funcionario) {
		try {
			return ResponseEntity.ok(funcionarioService.save(funcionario));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/{funcionarioId}")
	public ResponseEntity<?> findById(@PathVariable("funcionarioId") String funcionarioId) {
		try {
			return ResponseEntity.ok(funcionarioService.findFuncionarioById(funcionarioId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
