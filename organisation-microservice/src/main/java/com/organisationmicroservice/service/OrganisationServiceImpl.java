package com.organisationmicroservice.service;

import com.organisationmicroservice.dto.OrganisationDto;
import com.organisationmicroservice.entity.Organisation;
import com.organisationmicroservice.mapper.OrganisationMapper;
import com.organisationmicroservice.repository.OrganisationRepository;
import org.springframework.stereotype.Service;

@Service
public class OrganisationServiceImpl implements OrganisationService {

    private final OrganisationRepository organisationRepository;

    public OrganisationServiceImpl(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    @Override
    public OrganisationDto saveOrganisation(OrganisationDto organisationDto) {
        Organisation organisation = OrganisationMapper.convertToJpa(organisationDto);
        Organisation savedOrganisation = organisationRepository.save(organisation);
        return OrganisationMapper.convertToDto(savedOrganisation);
    }

    @Override
    public OrganisationDto getOrganisationByCode(String organisationCode) {
        Organisation organisation = organisationRepository.findByOrganisationCode(organisationCode);
        return OrganisationMapper.convertToDto(organisation);
    }
}
