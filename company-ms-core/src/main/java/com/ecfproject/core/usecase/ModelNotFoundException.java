package com.ecfproject.core.usecase;

public class ModelNotFoundException extends RuntimeException {

  static final long serialVersionUID = 1L;

  public ModelNotFoundException(final Object id) {
    super(String.format("No model found for id %s", id));
  }
}
