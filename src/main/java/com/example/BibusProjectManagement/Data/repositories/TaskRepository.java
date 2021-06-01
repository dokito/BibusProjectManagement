package com.example.BibusProjectManagement.Data.repositories;

import com.example.BibusProjectManagement.Data.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

    Task getById(String id);

    List<Task> findAll();
}
