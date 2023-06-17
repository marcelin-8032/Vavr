package functions.tuple;

import io.vavr.Tuple;
import io.vavr.Tuple3;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TupleTest {

    @Test
    void testTuple1() {
        Tuple3<String, Integer, String> tuple3 = Tuple.of("Mo", 1400, "Tennis");
        log.info("Tuple: " + tuple3);

        Tuple3<String, Integer, String> mappedTuple = tuple3.map(s -> s.toUpperCase(),
                l -> l - 5,
                s -> s.substring(2));
        log.info("Tuple Mapped: " + mappedTuple);

    }
}
