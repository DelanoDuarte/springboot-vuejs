/**
 * 
 */
package br.com.api.employeemanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.api.employeemanagement.domain.Funcionario;

/**
 * @author Delano Jr
 *
 */
@Repository
public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {

}
