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
@Table(name = "expenses")
public class Expense extends BaseEntity {

    @Column(name = "start_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime date;

    @Column(name = "type_of_expense")
    private String typeOfExpense; //creditCard, personalFunds, advanceFunds

    @Column(name = "invoice_no")
    private String invoiceNumber;

    @Column(name = "amount")
    private double amount;

    @ManyToMany(targetEntity = Project.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "monthly_reports_expenses",
            joinColumns = @JoinColumn(
                    name = "monthly_report_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "expences_id",
                    referencedColumnName = "id"
            )
    )
    private List<MonthlyReport> monthlyReportExpense = new ArrayList<>();
}
