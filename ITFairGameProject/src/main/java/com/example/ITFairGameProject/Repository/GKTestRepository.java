package com.example.ITFairGameProject.Repository;

import com.example.ITFairGameProject.Model.GKTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GKTestRepository  extends JpaRepository<GKTest, Long> {

    GKTest findById(long id);
}
