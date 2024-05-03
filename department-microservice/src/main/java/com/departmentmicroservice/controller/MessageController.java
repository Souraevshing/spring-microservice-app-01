package com.departmentmicroservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageController {

    @Value("${spring.boot.message}")
    private String message;

    @Operation( summary = "Test config server", description = "Send message to test config server")
    @ApiResponses( value = {
            @ApiResponse( responseCode = "200", description = "Success testing config server", useReturnTypeSchema = true),
            @ApiResponse( responseCode = "404", description = "Failed testing config server", useReturnTypeSchema = true )
    })
    @GetMapping("message")
    public String message() {
        return message;
    }
}
