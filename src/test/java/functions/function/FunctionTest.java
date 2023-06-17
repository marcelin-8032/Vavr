package functions.function;

import io.vavr.Function4;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

@Slf4j
public class FunctionTest {

    @Test
    void functionTest() {
        Function4<String, Integer, String, Integer, Integer> f4
                = (a1, a2, a3, a4) -> a1.length() + a2 + a3.length() + a4;

        Integer result = f4.apply("hello", 50, "world", 100);
        log.info("Result" + result);



    }
}
