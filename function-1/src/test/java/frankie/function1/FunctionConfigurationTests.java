package frankie.function1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.Supplier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;

@FunctionalSpringBootTest
final class FunctionConfigurationTests {

  @Test
  void function1(@Autowired final FunctionCatalog functionCatalog) {
    assertThat(functionCatalog.getNames(Supplier.class))
        .singleElement()
        .extracting(functionCatalog::lookup)
        .extracting(Supplier.class::cast)
        .extracting(Supplier::get)
        .isEqualTo("Hi!");
  }
}
