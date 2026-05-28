package com.example.FitTrack_Backend.repository;

import com.example.FitTrack_Backend.entity.Attendance;
import com.example.FitTrack_Backend.entity.Membership;
import com.example.FitTrack_Backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// AttendanceRepository.java
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    // All non-deleted attendance for a membership
    List<Attendance> findByMembershipAndIsDeletedFalse(Membership membership);

    // Trainer sees assigned sessions
    List<Attendance> findByTrainerUserAndIsDeletedFalse(User trainer);

    // Last 30 records for AI summary
    List<Attendance> findTop30ByMembershipOrderByAttendanceDateDesc(Membership membership);

    // Pending attendance for admin review
    List<Attendance> findByStatusAndIsDeletedFalse(String status);
}