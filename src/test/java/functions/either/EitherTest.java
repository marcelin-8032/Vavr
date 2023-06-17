package functions.either;

import io.vavr.control.Either;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class EitherTest {


    @Test
    void testEitherTest1() {
        Either<String, Integer> either = calculate(-2);
        log.info("Result: " + either);


        if (either.isLeft()) {
            String left = either.getLeft();
            log.info("left value" + left);
        }


        if (either.isRight()){
            Integer right = either.get();
            log.info("right value" + right);
        }

    }

    private Either<String, Integer> calculate(int i) {
        if (i <= 0)
            return Either.left("The argument value should be more than zero. \nThe argument you passed was" + i);
        return Either.right(i * 10);
    }


}
