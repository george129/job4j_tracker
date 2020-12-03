package ru.job4j.streamapi;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void checkAddress() {
        Profiles p = new Profiles();
        List<Profile> pr = new ArrayList<>();
        pr.add(new Profile(new Address(
                "Смоленск",
                "Пушкина",
                23,
                15), "Innokenty")
        );
        pr.add(new Profile(new Address(
                "Москва",
                "Свободы",
                120,
                31), "Samson")
        );
        pr.add(new Profile(new Address(
                "City 17",
                "Liberty",
                5,
                2), "Anatoly")
        );
        pr.add(new Profile(new Address(
                "Москва",
                "Свободы",
                120,
                31), "Socrat")
        );
        assertThat(p.collect(pr), is(Arrays.asList(
                new Address("City 17", "Liberty", 5, 2),
                new Address("Москва", "Свободы", 120, 31),
                new Address("Смоленск", "Пушкина", 23, 15)))
        );
    }
}