package com.dashboard;

import com.dashboard.repository.CustomerRepository;
import com.dashboard.repository.IBXRepository;
import com.dashboard.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        this.customerRepository.saveAll(Data.CUSTOMERS);
    }

    private void addIdxData() {
        this.ibxRepository.saveAll(Data.IBXS);
    }

    private void addVisitData() {
        this.visitRepository.saveAll(Data.VISITS);
    }

    @Override
    public void run(String... strings) throws Exception {
        addCustomerData();
        addIdxData();
        addVisitData();
    }

}
