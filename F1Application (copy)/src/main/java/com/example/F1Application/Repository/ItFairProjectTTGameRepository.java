package com.example.F1Application.Repository;

import com.example.F1Application.Model.ItFairProjectTTGameScores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItFairProjectTTGameRepository extends JpaRepository<ItFairProjectTTGameScores, Long> {
}
