package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository sut;

    @BeforeEach
    void resetDatabase() {
        sut.clear();
    }

    @Test
    void canInsertAndReturnFred() {
        Person toSave = new Person();
        toSave.setUsername("fred");
        sut.save(toSave);
        assertThat(sut.getPerson("fred").getUsername(), is("fred"));
    }
}