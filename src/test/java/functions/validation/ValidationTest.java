package functions.validation;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ValidationTest {


    @Test
    void testValidation1() {
        String userName = "Mohsen";
        Integer phoneNumber = 85959;

        Validation<Seq<String>, User> validationCombined =
                validateName(userName)
                        .combine(validateAge(phoneNumber))
                        .ap((a, b) -> new User(userName, phoneNumber));

        log.info("Validation Combined Result: " + validationCombined);

        User user = validationCombined.getOrElseGet((ls) ->
                new User("Auguste Rodin", 5055555));
        log.info("--------------");
        log.info("User: " + user);
    }


    private Validation<String, String> validateName(String name) {
        if (name.length() == 0 || name.length() > 6)
            return Validation.invalid("The name is not valid");

        return Validation.valid(name);
    }

    private Validation<String, Integer> validateAge(Integer phoneNumber) {
        if (phoneNumber < 1000)
            return Validation.invalid("Phone number not valid");

        return Validation.valid(phoneNumber);
    }


}
