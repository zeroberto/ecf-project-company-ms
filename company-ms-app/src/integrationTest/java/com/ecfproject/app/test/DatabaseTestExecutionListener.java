package com.ecfproject.app.test;

import org.springframework.lang.NonNull;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.testcontainers.containers.PostgreSQLContainer;

public class DatabaseTestExecutionListener extends AbstractTestExecutionListener {

  @Override
  public void beforeTestClass(@NonNull final TestContext testContext) throws Exception {
    final PostgreSQLContainer<?> postgreSQLContainer = AppPostgresqlContainer.getInstance();

    if (!postgreSQLContainer.isRunning()) {
      postgreSQLContainer.start();
    }

    super.beforeTestClass(testContext);
  }
}
