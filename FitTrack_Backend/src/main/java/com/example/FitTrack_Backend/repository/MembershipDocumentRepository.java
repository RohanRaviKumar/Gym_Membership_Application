package com.example.FitTrack_Backend.repository;

import com.example.FitTrack_Backend.entity.Membership;
import com.example.FitTrack_Backend.entity.MembershipDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MembershipDocumentRepository extends JpaRepository<MembershipDocument, Long> {

    // Get all documents for a specific membership
    List<MembershipDocument> findByMembership(Membership membership);

    // Get all documents for a membership by membership ID directly
    List<MembershipDocument> findByMembershipMembershipId(Long membershipId);

    // Get documents by type (1=Profile photo, 2=Workout schedule, 3=ID Proof)
    List<MembershipDocument> findByDocumentTypeId(Integer documentTypeId);

    // Get a specific document type for a specific membership
    List<MembershipDocument> findByMembershipAndDocumentTypeId(Membership membership, Integer documentTypeId);

    // Delete all documents for a membership
    void deleteByMembership(Membership membership);
}