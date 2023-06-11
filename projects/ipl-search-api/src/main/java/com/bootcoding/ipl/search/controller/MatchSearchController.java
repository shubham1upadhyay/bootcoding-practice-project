package com.bootcoding.ipl.search.controller;

import com.bootcoding.ipl.model.Match;
import com.bootcoding.ipl.search.service.MatchSearchService;
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
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/search")
@AllArgsConstructor
@Slf4j
@Api(tags = {"Match Search Service"})
public class MatchSearchController {

    private MatchSearchService searchService;

    @ApiOperation(value = "Match Search Request", notes = "Find all matches of IPL")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returned for successful request")
    })
    @GetMapping("/ipl/matches")
    public ResponseEntity<List<Match>> getAllMatches() {
        List<Match> allMatches = searchService.getAllMatches();
        return new ResponseEntity<>(allMatches, HttpStatus.OK);
    }

    @ApiOperation(value = "Search Match by id", notes = "Search Match with filters")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returned for successful request")
    })
    @GetMapping("/ipl/matches/{id}")
    public ResponseEntity<Optional<Match>> getMatchById(@PathVariable int id) {
        Optional<Match> matchById = searchService.getMatchById(id);
        return new ResponseEntity<>(matchById, HttpStatus.OK);
    }
}
