package com.organisationmicroservice.controller;

import com.organisationmicroservice.dto.OrganisationDto;
import com.organisationmicroservice.service.OrganisationService;
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
    public ResponseEntity<OrganisationDto> saveOrganisation(@RequestBody OrganisationDto organisationDto) {
        return new ResponseEntity<>(organisationService.saveOrganisation(organisationDto), HttpStatus.CREATED);
    }

    @GetMapping("{organisation-code}")
    public ResponseEntity<OrganisationDto> getOrganisationByCode(@PathVariable("organisation-code") String organisationCode) {
        return new ResponseEntity<>(organisationService.getOrganisationByCode(organisationCode), HttpStatus.OK);
    }
}
