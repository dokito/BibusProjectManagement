package com.example.BibusProjectManagement.Data.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vacations")
public class Vacation extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userOnVacation;

    @Column(name = "start_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime endDate;

    @Column(name = "days")
    private int days;

    @Column(name = "is_approved")
    private boolean isApproved;
}
