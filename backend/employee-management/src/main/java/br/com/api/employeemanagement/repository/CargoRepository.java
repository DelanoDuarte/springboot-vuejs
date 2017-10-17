/**
 * 
 */
package br.com.api.employeemanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.api.employeemanagement.domain.Cargo;

/**
 * @author Delano Jr
 *
 */
@Repository
public interface CargoRepository extends MongoRepository<Cargo, String> {

}
