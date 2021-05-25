package com.automation.utils;

import java.util.Date;
import java.util.Random;

public class IntegerUtils {

    private static final int SEED_TIME = 1;

    public static Integer random(int max) throws InterruptedException {

        Thread.sleep(SEED_TIME);

        Random random = new Random(new Date().getTime() % 1000);

        return random.nextInt(max);
    }

    public static Integer random(int min, int max) throws InterruptedException {

        Thread.sleep(SEED_TIME);

        Random random = new Random(new Date().getTime() % 1000);

        return random.nextInt(max + 1 - min) + min;
    }
}