package com.example.FitTrack_Backend.entity;

import com.example.FitTrack_Backend.enums.MembershipStatus;
import com.example.FitTrack_Backend.enums.MembershipType;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "memberships")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membershipId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User membershipUser;

    @Enumerated(EnumType.STRING)
    private MembershipType membershipType;

    @Enumerated(EnumType.STRING)
    private MembershipStatus membershipStatus;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(length = 50)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_trainer_id")
    private User assignedTrainer;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalFee;

    @Column(columnDefinition = "TEXT")
    private String notes;

    private BigDecimal heightCm;
    private BigDecimal weightKg;

    private String createdBy;

    @Column(columnDefinition = "DATETIME")       // ← fixes DATETIME(6) error
    private LocalDateTime createdOn;

    @Column(columnDefinition = "DATETIME")       // ← fixes DATETIME(6) error
    private LocalDateTime lastUpdatedOn;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "TINYINT(1)")  // ← fixes TINYINT(6) error
    private Boolean isActive = true;
}