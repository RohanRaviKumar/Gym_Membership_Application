package com.example.FitTrack_Backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "membership_documents")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MembershipDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membership_id", nullable = false)
    private Membership membership;

    private String documentPath;

    private Integer documentTypeId;

    @Column(columnDefinition = "DATETIME")       // ← fixes DATETIME(6) error
    private LocalDateTime uploadedOn;
}