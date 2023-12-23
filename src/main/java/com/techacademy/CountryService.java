package com.techacademy;

import java.util.List;
import java.util.Optional; // 追加

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // 追加

@Service
public class CountryService {
    private final CountryRepository repository;

  
    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    // Search and return all cases
    public List<Country> getCountryList() {
        // Call the findAll method of the repository
        return repository.findAll();
    }
    
    // ----- Add: from here -----
    // Search and return 1 case
    public Country getCountry(String code) {
        // search by findById
        Optional<Country> option = repository.findById(code);
        // Returns null if not obtained
        Country country = option.orElse(null);
        return country;
    }

    // Make updates (additions)
    @Transactional
    public void updateCountry(String code, String name, int population) {
        Country country = new Country(code, name, population);
        repository.save(country);
    }

    // Perform a delete
    @Transactional
    public void deleteCountry(String code) {
        repository.deleteById(code);
    }
    // ----- Add: so far -----
}
