package com.example.BibusProjectManagement.Data.repositories;

import com.example.BibusProjectManagement.Data.Models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

    Project getById(String id);

    List<Project> findAll();
}
