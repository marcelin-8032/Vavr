package functions;

import io.vavr.API;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static io.vavr.API.*;
import static io.vavr.Predicates.isIn;

@Slf4j
class TestMatch {


    @Test
    void testMatch1() {
        Integer matchThisNumber = 10;
        String stringResult = Match(matchThisNumber)
                .of(
                        Case($(10), "The number 10"),
                        Case($(20), "Much higher than 10 (20)"),
                        Case($(), "We ended up in the wildcard case")
                );

        log.info("String result: " + stringResult);

    }

    @Test
    void testMatchStringAndUserPredicates() {

        String matchOnThis = "truck";

        String result = Match(matchOnThis).of(
                Case($(isIn("truck", "motorBike", "bicycle")), "We have a match in the vehicles"),
                Case($(isIn("apple", "tomato", "orange")), "We have a match in the fruits"),
                Case($(isIn()), "There is no match")
        );

        log.info("Result:" + result);

    }


}
