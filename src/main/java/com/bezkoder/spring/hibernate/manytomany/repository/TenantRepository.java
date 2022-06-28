package com.bezkoder.spring.hibernate.manytomany.repository;

import com.bezkoder.spring.hibernate.manytomany.model.Tenant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

}