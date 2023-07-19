package com.admin.service.AdminService.repository;

import com.admin.service.AdminService.entity.DonorInfoClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDonorsInfoRepository extends JpaRepository<DonorInfoClass, String> {
    List<DonorInfoClass> findByDonarBloodTypeLike(String donarBloodType);
    List<DonorInfoClass> findAllByBloodOrganizationId(String bloodOrganizationId);
    void deleteAllByBloodOrganizationId(String bloodOrganizationId);

    void deleteByDonarId(String donarId);
}
