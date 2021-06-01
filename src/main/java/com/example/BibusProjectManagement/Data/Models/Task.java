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
@Table(name = "tasks")
public class Task extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "status", columnDefinition = "varchar(255) default 'Created'")
    private String status;

    @Column(name = "description")
    private String description;

    @Column(name = "created_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime createdDateTime;

    @Column(name = "end_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime endDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User assignedByUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User assignedToUser;

    @ManyToMany(targetEntity = Project.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "unfinished_tasks",
            joinColumns = @JoinColumn(
                    name = "projects_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "tasks_id",
                    referencedColumnName = "id"
            )
    )
    private List<Project> unfinishedTasksInProject = new ArrayList<>();

    @ManyToMany(targetEntity = Project.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "finished_tasks",
            joinColumns = @JoinColumn(
                    name = "projects_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "tasks_id",
                    referencedColumnName = "id"
            )
    )
    private List<Project> finishedTasksInProject = new ArrayList<>();

    @OneToOne(mappedBy = "taskToComplete")
    private BusinessTrip businessTrip;
}
