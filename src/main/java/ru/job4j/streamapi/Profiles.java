package ru.job4j.streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .sorted(new Comparator<Profile>() {
                    @Override
                    public int compare(Profile p1, Profile p2) {
                        return new ProfileCmpByAddr().compare(p1.getAddress(), p2.getAddress());
                    }
                })
                .distinct()
                .map(profile -> profile.getAddress())
                .collect(Collectors.toList()
                );
    }
}
