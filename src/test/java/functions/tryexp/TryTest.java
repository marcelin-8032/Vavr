package functions.tryexp;

import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class TryTest {

    @Test
    void tryTest1() {
        Try<Integer> result = Try.of(this::calculateImportantthings);
        log.info("result: " + result);
        Try<Integer> recover = result.recover(BusinessException.class,10 )
                .recover(OtherException.class, 20);
        log.info("Recover: " + recover);
        Integer orElseGet = result.getOrElse(50);
        log.info("Get or else: " + orElseGet);
    }


    private Integer calculateImportantthings() throws BusinessException, OtherException {

        if (2 == 1) {
            throw new BusinessException();
        } else if (3 == 1) {
            throw new OtherException();
        }
        return 42;
    }
}
