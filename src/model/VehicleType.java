package model;

import java.util.Arrays;

public enum VehicleType {
    CAR,
    PLANE,
    SHIP,
    BICYCLE,
    CHOPPER;
    public static String names() {
        return Arrays.toString(values());
        // Возвращает: "[CAR, PLANE, SHIP, BICYCLE, CHOPPER]"
    }
}
