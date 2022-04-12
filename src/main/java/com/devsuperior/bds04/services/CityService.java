package com.devsuperior.bds04.services;

import java.util.List;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public List<CityDTO> findAll() {

        List<City> list = repository.findAll(Sort.by("name"));

        return list.stream().map(CityDTO::new).toList();
    }
    
}
