package com.example.jobs.init;

import com.example.jobs.model.entity.Career;
import com.example.jobs.repository.CareerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final CareerRepository careerRepository;

    private final List<Career> careerSamples = List.of(
        new Career("Development", "JavaScript Developer", "Some 'Development - JavaScript Developer' job description here", "2 days ago"),
        new Career("Development", "Java Developer", "Some 'Development - Java Developer' job description here", "3 days ago"),
        new Career("Management", "Project Manager", "Some 'Management - Project Manager' job description here", "a week ago"),
        new Career("Sales", "Sales Representative", "Some 'Sales - Sales Representative' job description here", "2 weeks ago"),
        new Career("Development", "Database Administrator", "Some 'Development - Database Administrator' job description here", "a month ago")
    );

    public SampleDataLoader(CareerRepository careerRepository) {

        this.careerRepository = careerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCareers(careerSamples);
    }

    private void loadCareers(List<Career> careers) {

        if (careerRepository.count() > 0) return;

        careerRepository.saveAll(careers);
    }
}
