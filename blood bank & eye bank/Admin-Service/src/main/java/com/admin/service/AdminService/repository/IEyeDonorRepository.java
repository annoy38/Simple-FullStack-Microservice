package com.admin.service.AdminService.repository;

import com.admin.service.AdminService.entity.EyeDonorInfoClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEyeDonorRepository extends JpaRepository<EyeDonorInfoClass, String> {

    List<EyeDonorInfoClass> findAllByEyeOrganizationId(String eyeOrganizationId);
    void deleteAllByEyeOrganizationId(String eyeOrganizationId);
}
