package net.kiranatos.youtube.g10tank.utils;

public class Time {    
    public static final long SECOND = 10_000_000_00l;
    public static long get() {
        return System.nanoTime();        
    }    
}
