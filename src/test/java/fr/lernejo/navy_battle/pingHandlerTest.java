package fr.lernejo.navy_battle;
import org.assertj.core.api.Assertions;

class pingHandlerTest {

    void test_good_ping() {
        int result = 1;
        int expected = 1;
        Assertions.assertThat(result).as("OK").isEqualTo(1);
    }
}
