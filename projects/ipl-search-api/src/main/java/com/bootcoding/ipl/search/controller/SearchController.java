package com.bootcoding.ipl.search.controller;


import com.bootcoding.ipl.model.Match;
import com.bootcoding.ipl.search.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/search")
@AllArgsConstructor
@Slf4j
@Api(tags = {"Match Search Service"})
public class SearchController {

    private SearchService searchService;

    @ApiOperation(value = "Match Search Request", notes = "Search Match with filters")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returned for successful request"),
            @ApiResponse(code = 400, message = "Returned in case of JSON parsing problems or values in request fail in validation phase"),
            @ApiResponse(code = 415, message = "Returned for Unsupported Media Type, currently JSON type is supported"),
            @ApiResponse(code = 500, message = "Returned when Internal Server Error occurs!"),
            @ApiResponse(code = 503, message = "Returned when Service is not Available!")
    })
    @GetMapping("/ipl/matches")
    public ResponseEntity<List<Match>> getAllMatches() {
        List<Match> allMatches = searchService.getAllMatches();
        return new ResponseEntity<>(allMatches, HttpStatus.OK);
    }
}
