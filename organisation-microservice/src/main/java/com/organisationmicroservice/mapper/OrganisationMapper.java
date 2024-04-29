package com.organisationmicroservice.mapper;

import com.organisationmicroservice.dto.OrganisationDto;
import com.organisationmicroservice.entity.Organisation;

public class OrganisationMapper {
    public static OrganisationDto convertToDto(Organisation organisation) {
        return new OrganisationDto(
                organisation.getId(),
                organisation.getOrganisationName(),
                organisation.getOrganisationDescription(),
                organisation.getOrganisationCode(),
                organisation.getCreatedDate()
        );
    }

    public static Organisation convertToJpa(OrganisationDto organisationDto) {
        return new Organisation(
                organisationDto.getId(),
                organisationDto.getOrganisationName(),
                organisationDto.getOrganisationDescription(),
                organisationDto.getOrganisationCode(),
                organisationDto.getCreatedDate()
        );
    }
}
