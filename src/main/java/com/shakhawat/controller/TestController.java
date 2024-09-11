package com.shakhawat.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakhawat.model.User;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Authorize and Swagger Test")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}

	@Hidden
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	  @Operation(
		      summary = "Retrieve a Tutorial by Id",
		      description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status.",
		      tags = { "tutorials", "get" })
		  @ApiResponses({
		      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = User.class), mediaType = "application/json") }),
		      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema) }),
		      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema) }) })
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}

}
