package com.devsuperior.bds04.services;

import java.util.List;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    @Transactional(readOnly = true)
    public List<CityDTO> findAll() {

        List<City> list = repository.findAll(Sort.by("name"));

        return list.stream().map(CityDTO::new).toList();
    }

    @Transactional
    public CityDTO insert(CityDTO dto) {

        City city = new City();
        city.setName(dto.getName());

        city = repository.save(city);
        
        return new CityDTO(city);
    }
    
}
