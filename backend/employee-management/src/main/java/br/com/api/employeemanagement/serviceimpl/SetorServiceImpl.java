/**
 * 
 */
package br.com.api.employeemanagement.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.employeemanagement.domain.Setor;
import br.com.api.employeemanagement.repository.SetorRepostory;
import br.com.api.employeemanagement.service.SetorService;

/**
 * @author Delano Jr
 *
 */
@Service
public class SetorServiceImpl implements SetorService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private SetorRepostory setorRepostory;

	@Override
	public Setor save(Setor setor) {
		return setorRepostory.save(setor);
	}

	@Override
	public List<Setor> saveAll(List<Setor> setores) {
		return setorRepostory.save(setores);
	}

	@Override
	public List<Setor> findAll() {
		return setorRepostory.findAll();
	}

	@Override
	public Setor findById(String id) {
		return setorRepostory.findOne(id);
	}

	@Override
	public Setor removeCargoById(String id) {
		Setor setor = setorRepostory.findOne(id);
		setorRepostory.delete(setor);
		return setor;
	}

	@Override
	public Setor removeCargo(Setor setor) {
		setorRepostory.delete(setor);
		return setor;
	}

}
