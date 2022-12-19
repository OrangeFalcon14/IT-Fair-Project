package com.example.ITFairGameProject.Repository;

import com.example.ITFairGameProject.Model.UserNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserNamesRepository extends JpaRepository<UserNames, Long> {}
