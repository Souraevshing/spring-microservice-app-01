package com.organisationmicroservice.service;

import com.organisationmicroservice.dto.OrganisationDto;

public interface OrganisationService {
    OrganisationDto saveOrganisation(OrganisationDto organisationDto);
    OrganisationDto getOrganisationByCode(String organisationCode);
}
