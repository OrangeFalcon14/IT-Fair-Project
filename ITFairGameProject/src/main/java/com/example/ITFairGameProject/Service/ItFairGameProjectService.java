package com.example.ITFairGameProject.Service;

import com.example.ITFairGameProject.Dto.ItFairGameProjectDto;
import com.example.ITFairGameProject.Model.ItFairGameProject;
import com.example.ITFairGameProject.Repository.ItFairGameProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ItFairGameProjectService {

    @Autowired
    private ItFairGameProjectRepository itFairGameProjectRepository;

    public ItFairGameProjectService(ItFairGameProjectRepository itFairGameProjectRepository) {
        this.itFairGameProjectRepository = itFairGameProjectRepository;
    }
}
