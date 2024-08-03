package com.example.jobs.service.impl;

import com.example.jobs.model.convert.CareerDTOConverter;
import com.example.jobs.model.dto.CareerDTO;
import com.example.jobs.model.entity.Career;
import com.example.jobs.repository.CareerRepository;
import com.example.jobs.service.CareerService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CareerServiceImpl implements CareerService {

    private final CareerRepository careerRepository;
    private final CareerDTOConverter converter;

    public CareerServiceImpl(CareerRepository careerRepository, CareerDTOConverter converter) {

        this.careerRepository = careerRepository;
        this.converter = converter;
    }


    @Override
    public CareerDTO create(CareerDTO careerDTO) {

        Career career = careerRepository.save(converter.convertCareerDTOToCareer(careerDTO));
        return converter.convertCareerToCareerDTO(career);
    }

    @Override
    public void update(CareerDTO careerDTO) {

        careerRepository.save(converter.convertCareerDTOToCareer(careerDTO));
    }

    @Override
    public void delete(Long id) {

        careerRepository.deleteById(id);
    }

    @Override
    public CareerDTO getCareerById(Long id) {

        return careerRepository.findById(id)
                .map(converter::convertCareerToCareerDTO)
                .orElseThrow(() -> new IllegalArgumentException("Not found!"));
    }

    @Override
    public List<CareerDTO> getAll() {

        return careerRepository.findAll().stream()
                .map(converter::convertCareerToCareerDTO)
                .toList();
    }
}
