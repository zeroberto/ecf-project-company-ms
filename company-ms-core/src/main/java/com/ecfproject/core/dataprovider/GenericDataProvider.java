package com.ecfproject.core.dataprovider;

import java.util.Optional;
import java.util.Set;

public interface GenericDataProvider<T> {

  Set<T> findAll();

  Optional<T> findById(Long id);

  T save(T model);

}
