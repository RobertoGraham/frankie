package frankie.function1;

import java.util.function.Supplier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.cloud.function.context.catalog.FunctionTypeUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootConfiguration(proxyBeanMethods = false)
final class FunctionConfiguration implements ApplicationContextInitializer<GenericApplicationContext> {

  public static void main(final String... args) {
    FunctionalSpringApplication.run(FunctionConfiguration.class, args);
  }

  private Supplier<String> function1() {
    return () -> "Hi!";
  }

  @Override
  public void initialize(final GenericApplicationContext genericApplicationContext) {
    genericApplicationContext.registerBean(FunctionRegistration.class, () -> new FunctionRegistration<>(function1())
        .type(FunctionTypeUtils.supplierType(String.class)));
  }
}
