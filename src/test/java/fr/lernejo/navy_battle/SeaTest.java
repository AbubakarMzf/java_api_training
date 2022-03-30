package fr.lernejo.navy_battle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeaTest {
    @Test
    void test_sea1() {
        Sea sea = new Sea();
        int size = sea.getSea().size();
        Assertions.assertThat(size).isEqualTo(17);
    }
}
