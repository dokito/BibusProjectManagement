package com.example.BibusProjectManagement.Data.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "buiseness_trips")
public class BusinessTrip extends BaseEntity{

    @Column(name = "location")
    private String location;

    @Column(name = "client")
    private String client;

    @Column(name = "description")
    private String description;

    @Column(name = "report")
    private String report;

    @Column(name = "start_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime endDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private Task taskToComplete;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userOnTheTrip;
}
