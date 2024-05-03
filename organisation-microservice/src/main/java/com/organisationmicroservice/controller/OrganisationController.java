package com.organisationmicroservice.controller;

import com.organisationmicroservice.dto.OrganisationDto;
import com.organisationmicroservice.service.OrganisationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/organisation")
@AllArgsConstructor
public class OrganisationController {
    private OrganisationService organisationService;

    @PostMapping
    @Operation( summary = "Create organisation", description = "Returns organisation as response")
    @ApiResponses( value = {
            @ApiResponse( responseCode = "201", description = "Organisation retrieved successfully", useReturnTypeSchema = true),
            @ApiResponse( responseCode = "404", description = "Not found", useReturnTypeSchema = true )
    })
    public ResponseEntity<OrganisationDto> saveOrganisation(@RequestBody OrganisationDto organisationDto) {
        return new ResponseEntity<>(organisationService.saveOrganisation(organisationDto), HttpStatus.CREATED);
    }

    @GetMapping("{organisation-code}")
    @Operation( summary = "Get organisation by id", description = "Returns organisation as response")
    @ApiResponses( value = {
            @ApiResponse( responseCode = "201", description = "Organisation retrieved successfully", useReturnTypeSchema = true),
            @ApiResponse( responseCode = "404", description = "Not found", useReturnTypeSchema = true )
    })
    public ResponseEntity<OrganisationDto> getOrganisationByCode(@PathVariable("organisation-code") String organisationCode) {
        return new ResponseEntity<>(organisationService.getOrganisationByCode(organisationCode), HttpStatus.OK);
    }
}
