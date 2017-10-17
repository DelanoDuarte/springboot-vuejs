/**
 * 
 */
package br.com.api.employeemanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.api.employeemanagement.domain.Setor;

/**
 * @author Delano Jr
 *
 */
@Repository
public interface SetorRepostory extends MongoRepository<Setor, String> {

}
