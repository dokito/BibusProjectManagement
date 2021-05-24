package com.example.BibusProjectManagement.Data.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

    @OneToOne
    private User assignedTo;
}
