package com.example.jobs.service;

import com.example.jobs.model.dto.CareerDTO;

import java.util.List;

public interface CareerService {

    CareerDTO create(CareerDTO careerDTO);

    void update(CareerDTO careerDTO);

    void delete(Long id);

    CareerDTO getCareerById(Long id);

    List<CareerDTO> getAll();
}
