package com.dashboard;

import com.dashboard.model.Customer;
import com.dashboard.model.IBX;
import com.dashboard.model.Visit;

import java.time.LocalDateTime;
import java.util.List;

public class Data {
    public static final List<Customer> CUSTOMERS = List.of(
            new Customer("Lori Breanne"),
            new Customer("Ginger Ronda"),
            new Customer("Siena Vinnie"),
            new Customer("Kaylynn Jazmin"),
            new Customer("Madisyn Clementine"),
            new Customer("Frederica Xzavier"),
            new Customer("Pattie Jonelle"),
            new Customer("Lou Wil"),
            new Customer("Lauren Goldie"),
            new Customer("Fredrick Georgie")
    );

    public static final List<IBX> IBXS = List.of(
            new IBX("SG IBX", "Singapore", "Asia"),
            new IBX("US IBX", "United States", "North America"),
            new IBX("JPN IBX", "Japan", "Asia"),
            new IBX("NL IBX", "Netherlands", "Europe"),
            new IBX("CH IBX", "Switzerland", "Europe"),
            new IBX("MX IBX", "Mexico", "North America")
    );

    public static final List<Visit> VISITS = getVisits();

    private static List<Visit> getVisits() {
        LocalDateTime now = LocalDateTime.now();
        return List.of(
                new Visit(CUSTOMERS.get(1), IBXS.get(0), now.minusMinutes(123), now.plusMinutes(54), "other"),
                new Visit(CUSTOMERS.get(8), IBXS.get(1), now.minusMinutes(42), now.plusMinutes(43), "take a tour"),
                new Visit(CUSTOMERS.get(2), IBXS.get(2), now, now.plusMinutes(423), "perform smarthands operations"),
                new Visit(CUSTOMERS.get(3), IBXS.get(3), now.minusMinutes(212), now.plusMinutes(13), "take a tour"),
                new Visit(CUSTOMERS.get(4), IBXS.get(4), now, now.plusMinutes(234), "perform smarthands operations"),
                new Visit(CUSTOMERS.get(5), IBXS.get(0), now.minusMinutes(44), now.plusMinutes(2), "take a tour"),
                new Visit(CUSTOMERS.get(0), IBXS.get(5), now.minusMinutes(423), now, "perform smarthands operations"),
                new Visit(CUSTOMERS.get(8), IBXS.get(2), now.minusMinutes(122), now.plusMinutes(3), "take a tour"),
                new Visit(CUSTOMERS.get(3), IBXS.get(1), now.minusMinutes(43), now.plusMinutes(243), "other"),
                new Visit(CUSTOMERS.get(1), IBXS.get(2), now.minusMinutes(42), now.plusMinutes(5), "take a tour"),
                new Visit(CUSTOMERS.get(2), IBXS.get(0), now.minusMinutes(143), now, "perform smarthands operations"),
                new Visit(CUSTOMERS.get(3), IBXS.get(4), now.minusMinutes(43), now.plusMinutes(123), "take a tour"),
                new Visit(CUSTOMERS.get(5), IBXS.get(5), now.minusMinutes(113), now, "perform smarthands operations"),
                new Visit(CUSTOMERS.get(2), IBXS.get(2), now.minusMinutes(52), now.plusMinutes(24), "take a tour"),
                new Visit(CUSTOMERS.get(3), IBXS.get(3), now.minusMinutes(673), now.plusMinutes(212), "other"),
                new Visit(CUSTOMERS.get(1), IBXS.get(1), now.minusMinutes(4), now.plusMinutes(22), "take a tour"),
                new Visit(CUSTOMERS.get(5), IBXS.get(2), now.minusMinutes(16), now.plusMinutes(221), "other"),
                new Visit(CUSTOMERS.get(6), IBXS.get(0), now.minusMinutes(46), now.plusMinutes(33), "take a tour"),
                new Visit(CUSTOMERS.get(2), IBXS.get(3), now, now.plusMinutes(323), "perform smarthands operations"),
                new Visit(CUSTOMERS.get(4), IBXS.get(0), now.minusMinutes(43), now.plusMinutes(43), "take a tour"),
                new Visit(CUSTOMERS.get(7), IBXS.get(4), now.minusMinutes(143), now, "perform smarthands operations"),
                new Visit(CUSTOMERS.get(0), IBXS.get(5), now.minusMinutes(37), now.plusMinutes(23), "take a tour")
        );
    }

}

