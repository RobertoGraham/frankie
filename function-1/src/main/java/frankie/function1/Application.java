package frankie.function1;

import java.util.function.Supplier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.function.context.FunctionalSpringApplication;

@SpringBootConfiguration(proxyBeanMethods = false)
final class Application implements Supplier<String> {

  public static void main(final String... args) {
    FunctionalSpringApplication.run(Application.class, args);
  }

  @Override
  public String get() {
    return "Hi!";
  }
}
