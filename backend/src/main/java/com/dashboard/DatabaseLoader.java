package com.dashboard;

import com.dashboard.model.Customer;
import com.dashboard.model.IBX;
import com.dashboard.model.Visit;
import com.dashboard.repository.CustomerRepository;
import com.dashboard.repository.IBXRepository;
import com.dashboard.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final IBXRepository ibxRepository;
    private final VisitRepository visitRepository;

    @Autowired
    public DatabaseLoader(CustomerRepository customerRepository, IBXRepository ibxRepository,
                          VisitRepository visitRepository) {
        this.customerRepository = customerRepository;
        this.ibxRepository = ibxRepository;
        this.visitRepository = visitRepository;
    }

    private void addCustomerData() {
        List<Customer> customers = List.of(
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
        this.customerRepository.saveAll(customers);
    }

    private void addIdxData() {
        List<IBX> ibxs = List.of(
                new IBX("SG IBX", "Singapore", "Asia"),
                new IBX("US IBX", "United States", "North America"),
                new IBX("JPN IBX", "Japan", "Asia"),
                new IBX("NL IBX", "Netherlands", "Europe"),
                new IBX("CH IBX", "Switzerland", "Europe"),
                new IBX("MX IBX", "Mexico", "North America")
        );
        this.ibxRepository.saveAll(ibxs);
    }

    private void addVisitData() {
        LocalDateTime now = LocalDateTime.now();
        List<Visit> visits = List.of(
                new Visit(1, 1, now.minusMinutes(123), now.plusMinutes(54), "other"),
                new Visit(2, 3, now.minusMinutes(42), now.plusMinutes(43), "take a tour"),
                new Visit(3, 2, now, now.plusMinutes(423), "perform smarthands operations"),
                new Visit(4, 1, now.minusMinutes(212), now.plusMinutes(13), "take a tour"),
                new Visit(5, 4, now, now.plusMinutes(234), "perform smarthands operations"),
                new Visit(6, 5, now.minusMinutes(44), now.plusMinutes(2), "take a tour"),
                new Visit(7, 3, now.minusMinutes(423), now, "perform smarthands operations"),
                new Visit(8, 5, now.minusMinutes(122), now.plusMinutes(3), "take a tour"),
                new Visit(9, 2, now.minusMinutes(43), now.plusMinutes(243), "other"),
                new Visit(10, 6, now.minusMinutes(42), now.plusMinutes(5), "take a tour"),
                new Visit(1, 2, now.minusMinutes(143), now, "perform smarthands operations"),
                new Visit(2, 3, now.minusMinutes(43), now.plusMinutes(123), "take a tour"),
                new Visit(3, 1, now.minusMinutes(113), now, "perform smarthands operations"),
                new Visit(3, 2, now.minusMinutes(52), now.plusMinutes(24), "take a tour"),
                new Visit(4, 4, now.minusMinutes(673), now.plusMinutes(212), "other"),
                new Visit(5, 3, now.minusMinutes(4), now.plusMinutes(22), "take a tour"),
                new Visit(6, 6, now.minusMinutes(16), now.plusMinutes(221), "other"),
                new Visit(7, 2, now.minusMinutes(46), now.plusMinutes(33), "take a tour"),
                new Visit(8, 5, now, now.plusMinutes(323), "perform smarthands operations"),
                new Visit(8, 2, now.minusMinutes(43), now.plusMinutes(43), "take a tour"),
                new Visit(9, 2, now.minusMinutes(143), now, "perform smarthands operations"),
                new Visit(9, 2, now.minusMinutes(37), now.plusMinutes(23), "take a tour")
        );
        this.visitRepository.saveAll(visits);
    }

    @Override
    public void run(String... strings) throws Exception {
        addCustomerData();
        addIdxData();
        addVisitData();
    }
}