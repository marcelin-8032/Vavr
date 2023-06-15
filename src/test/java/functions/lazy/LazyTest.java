package functions.lazy;

import io.vavr.Lazy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Random;

@Slf4j
public class LazyTest {

    //Lazy is a memorized functions
    @Test
    void testLazy1() {
        Lazy<Integer> lazy = Lazy.of(() -> new Random().nextInt());
        log.info("lazy isEvaluated: "+ lazy.isEvaluated());
        Integer result=lazy.get();
        Integer result2=lazy.get();
        log.info("lazy isEvaluated: "+ lazy.isEvaluated());
        log.info("Result: "+ result);
        log.info("Result: "+ result2);
    }


}
