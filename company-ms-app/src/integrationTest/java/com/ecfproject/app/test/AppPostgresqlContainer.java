package com.ecfproject.app.test;

import org.testcontainers.containers.PostgreSQLContainer;

import static java.util.Objects.isNull;

public class AppPostgresqlContainer extends PostgreSQLContainer<AppPostgresqlContainer> {

  private static final String IMAGE_VERSION = "postgres:13.2";
  private static AppPostgresqlContainer container;

  public AppPostgresqlContainer() {
    super(IMAGE_VERSION);
  }

  public static AppPostgresqlContainer getInstance() {
    if (isNull(container)) {
      container = new AppPostgresqlContainer();
    }
    return container;
  }

  @Override
  public void start() {
    super.start();
    System.setProperty("APP_COMPANY_MS_DB_URL", container.getJdbcUrl());
    System.setProperty("APP_COMPANY_MS_DB_USER", container.getUsername());
    System.setProperty("APP_COMPANY_MS_DB_PASSWORD", container.getPassword());
    System.setProperty("APP_COMPANY_MS_DB_DDL_AUTO", "create-drop");
  }
}
