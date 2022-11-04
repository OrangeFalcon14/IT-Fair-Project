package com.example.ITFairGameProject.Repository;

import com.example.ITFairGameProject.Model.OpticalIllusionTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpticalIllusionRepository extends JpaRepository<OpticalIllusionTest, Long> {
}
