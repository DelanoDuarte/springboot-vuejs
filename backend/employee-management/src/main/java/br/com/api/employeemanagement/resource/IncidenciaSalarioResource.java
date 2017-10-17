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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.employeemanagement.domain.IncidenciaSalario;
import br.com.api.employeemanagement.service.IncidenciaSalarioService;

/**
 * @author Delano Jr
 *
 */
@CrossOrigin(value = { "*" })
@RestController
@RequestMapping(value = "/incidencia-salario")
public class IncidenciaSalarioResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IncidenciaSalarioService incidenciaSalarioService;

	@GetMapping("/all")
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok(incidenciaSalarioService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping
	public ResponseEntity<?> save(IncidenciaSalario incidenciaSalario) {
		try {
			return ResponseEntity.ok(incidenciaSalarioService.save(incidenciaSalario));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/{incidenciaSalarioId}")
	public ResponseEntity<?> findOne(@PathVariable("incidenciaSalarioId") String incidenciaSalarioId) {
		try {
			return ResponseEntity.ok(incidenciaSalarioService.findIncidenciaSalarioById(incidenciaSalarioId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
