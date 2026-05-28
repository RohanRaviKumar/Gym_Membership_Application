package com.example.FitTrack_Backend.entity;

import com.example.FitTrack_Backend.enums.WorkoutCategory;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "attendances")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membership_id", nullable = false)
    private Membership membership;

    private LocalDate attendanceDate;

    @Column(columnDefinition = "DATETIME")       // ← fixes DATETIME(6) error
    private LocalDateTime checkInTime;

    @Column(columnDefinition = "DATETIME")       // ← fixes DATETIME(6) error
    private LocalDateTime checkOutTime;

    @Enumerated(EnumType.STRING)
    private WorkoutCategory workoutCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id")
    private User trainerUser;

    private Integer durationMinutes;

    @Column(length = 50)
    private String status;

    @Column(columnDefinition = "TEXT")
    private String comments;

    @Column(length = 50)
    private String eventType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recorded_by_id")
    private User recordedBy;

    @Column(columnDefinition = "DATETIME")       // ← fixes DATETIME(6) error
    private LocalDateTime recordedOn;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "TINYINT(1)")  // ← fixes TINYINT(6) error
    private Boolean isDeleted = false;
}