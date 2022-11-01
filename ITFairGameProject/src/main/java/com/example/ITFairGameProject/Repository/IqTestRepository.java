package com.example.ITFairGameProject.Repository;

import com.example.ITFairGameProject.Model.IqTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IqTestRepository extends JpaRepository<IqTest, Long> {
    
    IqTest findById(long id);
}
