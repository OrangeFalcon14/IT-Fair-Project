package com.example.ITFairGameProject.Repository;

import com.example.ITFairGameProject.Model.ItFairGameProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItFairGameProjectRepository extends JpaRepository<ItFairGameProject, Long> {
    List<ItFairGameProject> findAllByOrderByTotalPointsDesc();
    ItFairGameProject findItFairGameProjectByUserName(String userName);
}
