package com.example.BibusProjectManagement.Data.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "monthly_reports")
public class MonthlyReport extends BaseEntity{

    @Column(name = "month")
    private String month; //add year

    @ManyToMany(mappedBy = "monthlyReportExpense")
    private List<Expense> expenses = new ArrayList<>();

    @Column(name = "total_expenses")
    private double totalExpense;

    @Column(name = "difference")
    private double differenceBetweenReceivedAndSpend;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userMonthlyReport;
}
