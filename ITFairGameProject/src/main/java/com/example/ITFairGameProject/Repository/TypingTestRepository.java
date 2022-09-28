package com.example.ITFairGameProject.Repository;

import com.example.ITFairGameProject.Model.TypingTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypingTestRepository extends JpaRepository<TypingTest, Long> {
}
