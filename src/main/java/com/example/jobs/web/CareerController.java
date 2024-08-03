package com.example.jobs.web;

import com.example.jobs.model.dto.CareerDTO;
import com.example.jobs.service.CareerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/careers")
public class CareerController {

    private final CareerService careerService;

    public CareerController(CareerService careerService) {

        this.careerService = careerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CareerDTO> findById( @PathVariable("id") Long id ) {

        return ResponseEntity.ok( careerService.getCareerById(id) );
    }

    @PostMapping
    public ResponseEntity<CareerDTO> create( @RequestBody CareerDTO careerDTO ) {

        return ResponseEntity.ok( careerService.create(careerDTO) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CareerDTO> deleteById( @PathVariable("id") Long id ) {

        careerService.delete( id );

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CareerDTO> update( @PathVariable Long id, @RequestBody CareerDTO careerDTO ) {

        CareerDTO updateCareer = careerService.getCareerById(id);

        updateCareer
                .setCategory(careerDTO.getCategory())
                .setTitle(careerDTO.getTitle())
                .setDescription(careerDTO.getDescription())
                .setPublished(careerDTO.getPublished());

        careerService.update(updateCareer);

        return ResponseEntity.ok(updateCareer);
    }

    @GetMapping
    public ResponseEntity<List<CareerDTO>> getAll() {

        return ResponseEntity.ok( careerService.getAll() );
    }

}
