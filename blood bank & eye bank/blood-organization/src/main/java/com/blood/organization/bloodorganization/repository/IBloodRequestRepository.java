package com.blood.organization.bloodorganization.repository;

import com.blood.organization.bloodorganization.entity.BloodRequestClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBloodRequestRepository extends JpaRepository<BloodRequestClass, Integer> {
    List<BloodRequestClass> findAllByBloodOrganizationEmail(String bloodOrganizationEmail);

}
