package br.com.api.employeemanagement.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID> extends Serializable {

	public T save(T t);

	public List<T> saveAll(List<T> t);

	public List<T> findAll();

	public T findById(ID id);

	public T removeCargoById(ID id);

	public T removeCargo(T t);

}
