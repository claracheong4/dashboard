package com.dashboard.controller;

import com.dashboard.model.Customer;
import com.dashboard.model.IBX;
import com.dashboard.model.Visit;
import com.dashboard.repository.CustomerRepository;
import com.dashboard.repository.IBXRepository;
import com.dashboard.repository.VisitRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@RestController
@RequestMapping("/visits")
public class VisitController {

    private final VisitRepository visitRepository;
    private final CustomerRepository customerRepository;
    private final IBXRepository ibxRepository;
    private final Logger logger;

    public VisitController(VisitRepository visitRepository, CustomerRepository customerRepository,
                           IBXRepository ibxRepository) {
        this.visitRepository = visitRepository;
        this.customerRepository = customerRepository;
        this.ibxRepository = ibxRepository;
        this.logger = Logger.getLogger(VisitController.class.getName());
    }

    @CrossOrigin
    @GetMapping
    public List<Visit> getVisits(@RequestParam(required = false) Integer id,
                                 @RequestParam(required = false) LocalDateTime startTime,
                                 @RequestParam(required = false) LocalDateTime endTime,
                                 @RequestParam(required = false) String purpose) {
        logger.log(Level.INFO, "Get all visits");

        Visit visit = new Visit();
        visit.setId(id);
        visit.setStartTime(startTime);
        visit.setEndTime(endTime);
        visit.setPurpose(purpose);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("id", exact())
                .withMatcher("startTime", exact())
                .withMatcher("endTime", exact())
                .withMatcher("purpose", exact());
        Example<Visit> example = Example.of(visit, matcher);
        return visitRepository.findAll(example);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Visit getVisit(@PathVariable Integer id) {
        logger.log(Level.INFO, "Get visit with id " + id);

        return visitRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Visit> addVisit(@RequestBody Visit visit) throws URISyntaxException {
        logger.log(Level.INFO, "Post visit with id " + visit.getId());

        Customer customer = customerRepository.findById(visit.getCustomer().getId())
                .orElseThrow(RuntimeException::new);
        visit.setCustomer(customer);

        IBX ibx = ibxRepository.findById(visit.getIbx().getId())
                .orElseThrow(RuntimeException::new);
        visit.setIbx(ibx);

        Visit savedVisit = visitRepository.save(visit);
        return ResponseEntity.created(new URI("/visits/" + savedVisit.getId())).body(savedVisit);
    }

    @CrossOrigin
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Visit> updateVisit(@PathVariable Integer id, @RequestBody Visit visit) {
        logger.log(Level.INFO, "Put visit with id " + visit.getId());

        Visit currVisit = visitRepository.findById(id).orElseThrow(RuntimeException::new);
        if (visit.getCustomer() != null) {
            Customer newCustomer = customerRepository.findById(visit.getCustomer().getId())
                    .orElseThrow(RuntimeException::new);
            currVisit.setCustomer(newCustomer);
        }
        if (visit.getIbx() != null) {
            IBX newIBX = ibxRepository.findById(visit.getIbx().getId())
                    .orElseThrow(RuntimeException::new);
            currVisit.setIbx(newIBX);
        }
        if (visit.getStartTime() != null) currVisit.setStartTime(visit.getStartTime());
        if (visit.getEndTime() != null) currVisit.setEndTime(visit.getEndTime());
        if (visit.getPurpose() != null) currVisit.setPurpose(visit.getPurpose());

        return ResponseEntity.ok(currVisit);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Visit> deleteVisit(@PathVariable Integer id) {
        logger.log(Level.INFO, "Delete visit with id " + id);

        visitRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
