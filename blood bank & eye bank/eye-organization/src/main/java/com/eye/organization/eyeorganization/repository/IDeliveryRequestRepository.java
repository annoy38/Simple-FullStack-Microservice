package com.eye.organization.eyeorganization.repository;

import com.eye.organization.eyeorganization.entity.DeliveryRequestClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDeliveryRequestRepository extends JpaRepository<DeliveryRequestClass, String> {
    List<DeliveryRequestClass> findByOrganizationId(String organizationId);
    DeliveryRequestClass findByDeliverId(String deliverId);
}
