package org.example.com.bl.java.junit;

public class InvoiceService {

    private static final int COST_PER_TIME = 1;
    private static final double MIN_COST_PER_KM = 10;
    private static final double MIN_FARE = 5;
    private RideRepository rideRepository;

    public double calculateFare(double distance, int time) {
        double totalFare = distance *   MIN_COST_PER_KM + time * COST_PER_TIME;

        return Math.max(totalFare, MIN_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {

        double totalFare = 0;
        for (Ride ride:rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }

        return new InvoiceSummary(rides.length, totalFare);
    }

    public  InvoiceSummary calculateFareDescription(Ride[] rides) {
        double cost = 0;
        for (Ride ride : rides) {
            cost = cost + this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, cost);
    }

    public InvoiceSummary getInvoiceDescription(String userId) {
        return this.calculateFareDescription(rideRepository.getRides(userId));
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }
}
