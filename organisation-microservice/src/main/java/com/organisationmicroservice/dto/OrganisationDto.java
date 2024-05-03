package com.organisationmicroservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganisationDto {
        private Long id;
        @Schema( name = "organisationName", description = "organisationName" )
        private String organisationName;
        @Schema( name = "organisationDescription", description = "organisationDescription" )
        private String organisationDescription;
        @Schema( name = "organisationCode", description = "organisationCode" )
        private String organisationCode;
        @Schema( name = "createdDate", description = "createdDate" )
        private LocalDateTime createdDate;
}
