package com.bezkoder.spring.hibernate.manytomany.repository;

import java.util.List;

import com.bezkoder.spring.hibernate.manytomany.model.Tenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TenantService {
    @Autowired
    TenantRepository tenantRepository;

    // CREATE
    public Tenant createTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    // READ
    public List<Tenant> getTenants() {
        return tenantRepository.findAll();
    }

    // DELETE
    public void deleteTenant(Long tenantId) {
        tenantRepository.deleteById(tenantId);
    }

    // UPDATE
    public Tenant updateTenant(Long tenantId, Tenant tenantDetails) {
        Tenant tenant = tenantRepository.findById(tenantId).get();
        tenant.setName(tenantDetails.getName());
        tenant.setId(tenantDetails.getId());
        tenant.setEmail(tenantDetails.getEmail());

        return tenantRepository.save(tenant);
    }
}