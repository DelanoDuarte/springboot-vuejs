/**
 * 
 */
package br.com.api.employeemanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.api.employeemanagement.domain.IncidenciaSalario;

/**
 * @author Delano Jr
 *
 */
@Repository
public interface IncidenciaSalarioRepository extends MongoRepository<IncidenciaSalario, String> {

}
