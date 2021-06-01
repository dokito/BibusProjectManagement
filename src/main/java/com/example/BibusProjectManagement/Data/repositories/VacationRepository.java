package com.example.BibusProjectManagement.Data.repositories;

import com.example.BibusProjectManagement.Data.Models.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationRepository extends JpaRepository<Vacation, String> {

    Vacation getById(String id);

    List<Vacation> findAll();
}
