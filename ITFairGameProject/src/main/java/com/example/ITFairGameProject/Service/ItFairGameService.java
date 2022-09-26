package com.example.ITFairGameProject.Service;

import com.example.ITFairGameProject.Repository.ItFairGameProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItFairGameService {

    @Autowired
    private ItFairGameProjectRepository itFairGameProjectRepository;

    public ItFairGameService(ItFairGameProjectRepository itFairGameProjectRepository) {
        this.itFairGameProjectRepository = itFairGameProjectRepository;
    }


}
