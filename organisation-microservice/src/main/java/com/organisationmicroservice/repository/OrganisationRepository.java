package com.organisationmicroservice.repository;

import com.organisationmicroservice.entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
    Organisation findByOrganisationCode(String organisationCode);
}
