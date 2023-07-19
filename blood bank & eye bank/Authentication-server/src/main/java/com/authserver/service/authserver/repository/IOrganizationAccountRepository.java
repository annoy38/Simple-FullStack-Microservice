package com.authserver.service.authserver.repository;

import com.authserver.service.authserver.entity.OrganizationAccountClass;
import com.authserver.service.authserver.entity.OrganizationClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOrganizationAccountRepository extends JpaRepository<OrganizationAccountClass, String> {

    Optional<OrganizationAccountClass> findByOrgEmail(String orgEmail);
    OrganizationAccountClass findByOrgNumber(String orgNumber);

    void deleteByOrgEmail(String orgEmail);
}
