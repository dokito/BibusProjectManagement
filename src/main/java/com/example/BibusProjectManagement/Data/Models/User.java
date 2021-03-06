package com.example.BibusProjectManagement.Data.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {

    @Column(name = "username", nullable = false, updatable = false, unique = true)
    private String username;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Role> authorities;

    @OneToMany(
            mappedBy = "assignedByUser",
            cascade = CascadeType.ALL
    )
    private List<Task> tasksAssignedByUser = new ArrayList<>();

    @OneToMany(
            mappedBy = "assignedToUser",
            cascade = CascadeType.ALL
    )
    private List<Task> tasksAssignedToUser = new ArrayList<>();

    @OneToMany(
            mappedBy = "userResponsible",
            cascade = CascadeType.ALL
    )
    private List<Project> projectsResponsibleFor = new ArrayList<>();

    @ManyToMany(targetEntity = Project.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "projects_involved",
            joinColumns = @JoinColumn(
                    name = "users_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "projects_id",
                    referencedColumnName = "id"
            )
    )
    private List<Project> projectsInvolved = new ArrayList<>();

    @OneToOne(mappedBy = "userOnTheTrip")
    private BusinessTrip businessTrips;

    @OneToMany(
            mappedBy = "userMonthlyReport",
            cascade = CascadeType.ALL
    )
    private List<MonthlyReport> monthlyReports = new ArrayList<>();

    @OneToMany(
            mappedBy = "userOnVacation",
            cascade = CascadeType.ALL
    )
    private List<Vacation> userVacations = new ArrayList<>();

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return true;
    }
}
