package ru.job4j.streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .sorted(Comparator.comparing(Profile::getAddress, new ProfileCmpByAddr()))
                .distinct()
                .map(profile -> profile.getAddress())
                .collect(Collectors.toList()
                );
    }
}
