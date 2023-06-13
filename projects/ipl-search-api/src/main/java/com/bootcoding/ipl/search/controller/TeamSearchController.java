package com.bootcoding.ipl.search.controller;


import com.bootcoding.ipl.model.Team;
import com.bootcoding.ipl.search.service.TeamSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/search")
@AllArgsConstructor
@Slf4j
@Api(tags = {"Match Team Search Service"})
public class TeamSearchController {
    private TeamSearchService searchService;

    @ApiOperation(value = "Team Search Request", notes = "Find all teams of IPL")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returned for successful request")
    })
    @GetMapping("/ipl/teams")
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> allTeams = searchService.getAllTeams();
        return new ResponseEntity<>(allTeams, HttpStatus.OK);
    }

    @ApiOperation(value = "Search Team by id", notes = "Search Team with filters")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returned for successful request")
    })
    @GetMapping("/ipl/teams/{name}")
    public ResponseEntity<Optional<Team>> getTeamByName(@PathVariable String name) {
        Optional<Team> teamByName = searchService.getTeamByName(name);
        return new ResponseEntity<>(teamByName, HttpStatus.OK);
    }

    @ApiOperation(value = "Team Search Request", notes = "Find all teams of IPL")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returned for successful request")
    })
    @GetMapping("/ipl/teams/query")
    public ResponseEntity<List<Team>> searchTeam(@RequestParam Map<String, String> params) {
        List<Team> teams = searchService.search(params);
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

}
