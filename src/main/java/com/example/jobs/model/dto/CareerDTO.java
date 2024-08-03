package com.example.jobs.model.dto;

import jakarta.validation.constraints.NotBlank;

public class CareerDTO {

    private long id;

    @NotBlank
    private String category;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String published;

    public CareerDTO() {
    }

    public long getId() {
        return id;
    }

    public CareerDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public CareerDTO setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CareerDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CareerDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPublished() {
        return published;
    }

    public CareerDTO setPublished(String published) {
        this.published = published;
        return this;
    }
}
