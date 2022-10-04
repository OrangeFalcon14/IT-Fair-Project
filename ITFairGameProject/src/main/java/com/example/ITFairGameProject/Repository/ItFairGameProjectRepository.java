package com.example.ITFairGameProject.Repository;

import com.example.ITFairGameProject.Model.ItFairGameProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItFairGameProjectRepository extends JpaRepository<ItFairGameProject, Long> {


}
