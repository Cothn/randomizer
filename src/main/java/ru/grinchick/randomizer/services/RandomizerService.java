package ru.grinchick.randomizer.services;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomizerService {
    public static List<String> getRandomLongSequence(long min, long max, long limit) {
        return new Random().longs(limit, min, max).boxed().map(Object::toString).collect(Collectors.toList());
    }

    public static List<String> getRandomDoubleSequence(double min, double max, long limit) {
        return new Random().doubles(limit, min, max).boxed().map(Object::toString).collect(Collectors.toList());
    }
}
