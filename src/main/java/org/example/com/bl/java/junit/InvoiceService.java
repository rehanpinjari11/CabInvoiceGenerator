package org.example.com.bl.java.junit;

public class InvoiceService {

    private static final int COST_PER_TIME = 1;
    private static final double MIN_COST_PER_KM = 10;

    public double calculateFare(double distance, int time) {
        return distance *   MIN_COST_PER_KM + time * COST_PER_TIME;
    }
}
