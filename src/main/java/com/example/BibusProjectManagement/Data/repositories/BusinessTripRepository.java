package com.example.BibusProjectManagement.Data.repositories;

import com.example.BibusProjectManagement.Data.Models.BusinessTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessTripRepository extends JpaRepository<BusinessTrip, String> {

    BusinessTrip getById(String id);

    List<BusinessTrip> findAll();
}
