package com.dashboard.controller;

import com.dashboard.model.IBX;
import com.dashboard.repository.IBXRepository;
import com.dashboard.repository.VisitRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@RestController
@RequestMapping("/ibxs")
public class IBXController {

    private final VisitRepository visitRepository;
    private final IBXRepository ibxRepository;
    private final Logger logger;

    public IBXController(IBXRepository ibxRepository, VisitRepository visitRepository) {
        this.ibxRepository = ibxRepository;
        this.visitRepository = visitRepository;
        this.logger = Logger.getLogger(IBXController.class.getName());
    }

    @CrossOrigin
    @GetMapping
    public List<IBX> getIbxs(@RequestParam(required = false) Integer id,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String country,
                             @RequestParam(required = false) String region) {
        logger.log(Level.INFO, "Get all ibxs");

        IBX ibx = new IBX();
        ibx.setId(id);
        ibx.setName(name);
        ibx.setCountry(country);
        ibx.setRegion(region);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("id", exact())
                .withMatcher("name", exact())
                .withMatcher("country", exact())
                .withMatcher("region", exact());
        Example<IBX> example = Example.of(ibx, matcher);
        return ibxRepository.findAll(example);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public IBX getIbx(@PathVariable Integer id) {
        logger.log(Level.INFO, "Get ibx with id " + id);

        return ibxRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<IBX> addIbx(@RequestBody IBX ibx) throws URISyntaxException {
        logger.log(Level.INFO, "Post ibx with id " + ibx.getId());

        IBX savedIbx = ibxRepository.save(ibx);
        return ResponseEntity.created(new URI("/ibxs/" + savedIbx.getId())).body(savedIbx);
    }

    @CrossOrigin
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<IBX> updateIbx(@PathVariable Integer id, @RequestBody IBX ibx) {
        logger.log(Level.INFO, "Put ibx with id " + ibx.getId());

        IBX currIbx = ibxRepository.findById(id).orElseThrow(RuntimeException::new);
        if (ibx.getName() != null) currIbx.setName(ibx.getName());
        if (ibx.getCountry() != null) ibx.setCountry(ibx.getCountry());
        if (ibx.getRegion() != null) ibx.setRegion(ibx.getRegion());

        return ResponseEntity.ok(currIbx);
    }

    @Transactional
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<IBX> deleteIbx(@PathVariable Integer id) {
        logger.log(Level.INFO, "Delete ibx with id " + id);

        visitRepository.deleteByIbxId(id);
        ibxRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
