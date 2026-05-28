package com.example.FitTrack_Backend.repository;

import com.example.FitTrack_Backend.entity.Membership;
import com.example.FitTrack_Backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MembershipRepository extends JpaRepository<Membership, Long> {

    // All active memberships (excludes soft-deleted)
    List<Membership> findByIsActiveTrue();

    // Member sees only their own
    List<Membership> findByMembershipUserAndIsActiveTrue(User user);

    // Trainer sees only assigned
    List<Membership> findByAssignedTrainerAndIsActiveTrue(User trainer);

    // Filter by status
    List<Membership> findByStatusAndIsActiveTrue(String status);
}