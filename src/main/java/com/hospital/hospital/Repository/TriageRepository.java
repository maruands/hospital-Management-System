package com.hospital.hospital.Repository;

import com.hospital.hospital.Entities.Triage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TriageRepository extends JpaRepository<Triage, Integer> {
}
