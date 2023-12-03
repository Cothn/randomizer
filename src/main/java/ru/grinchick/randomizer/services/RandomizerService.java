package ru.grinchick.randomizer.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomizerService {
    public static List<String> getRandomLongSequence(long min, long max, long limit) {
        return new Random().longs(limit, min, max).parallel().boxed().map(Object::toString).collect(Collectors.toList());
    }

    public static List<String> getRandomDoubleSequence(double min, double max, long limit) {
        return new Random().doubles(limit, min, max).parallel().map(RandomizerService::roundDouble).boxed().map(Object::toString).collect(Collectors.toList());
    }

    private static double roundDouble(double d) {
        int scale = 18; // количество знаков после запятой

        BigDecimal bd = new BigDecimal(d);
        bd = bd.setScale(scale, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }
}
