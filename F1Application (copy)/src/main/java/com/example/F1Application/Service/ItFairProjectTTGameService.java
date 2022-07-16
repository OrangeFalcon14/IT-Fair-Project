package com.example.F1Application.Service;

import com.example.F1Application.Repository.ItFairProjectTTGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItFairProjectTTGameService {

    @Autowired
    private ItFairProjectTTGameRepository itFairProjectTTGameRepository;

    public ItFairProjectTTGameService(ItFairProjectTTGameRepository itFairProjectTTGameRepository) {
        this.itFairProjectTTGameRepository = itFairProjectTTGameRepository;
    }
}
