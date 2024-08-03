package com.example.jobs.model.convert;

import com.example.jobs.model.dto.CareerDTO;
import com.example.jobs.model.entity.Career;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CareerDTOConverter {

    private final ModelMapper modelMapper;

    public CareerDTOConverter(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

    public CareerDTO convertCareerToCareerDTO(Career career) {

        return modelMapper.map(career, CareerDTO.class);
    }

    public Career convertCareerDTOToCareer(CareerDTO careerDTO) {

        return modelMapper.map(careerDTO, Career.class);
    }
}
