package com.example.BibusProjectManagement.Data.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "name")
    private String description;

    @Column(name = "status", columnDefinition = "varchar(255) default 'Created'")
    private String status;

    @Column(name = "client")
    private String client;

    @Column(name = "created_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime createdDateTime;

    @Column(name = "end_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime endDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userResponsible;

    @ManyToMany(mappedBy = "projectsInvolved") //this creates a table for Users involved in project
    private List<User> usersInvolved = new ArrayList<>();

    @ManyToMany(mappedBy = "unfinishedTasksInProject") //this creates a table for Tasks that need to be complete
    private List<Task> tasksToComplete = new ArrayList<>();

    @ManyToMany(mappedBy = "finishedTasksInProject") //this create a table for Tasks that are finished
    private List<Task> completedTasks = new ArrayList<>();
}
