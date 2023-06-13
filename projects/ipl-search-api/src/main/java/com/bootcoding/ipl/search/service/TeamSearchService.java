package com.bootcoding.ipl.search.service;

import com.bootcoding.ipl.model.Team;
import com.bootcoding.ipl.search.query.QueryMapper;
import com.bootcoding.ipl.search.repository.TeamSearchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class TeamSearchService {

    private TeamSearchRepository searchRepository;
    private List<QueryMapper> queryMappers;


    public List<Team> getAllTeams() {
        Collection<Team> teams = searchRepository.findAllTeams();
        return new ArrayList<>(teams);
    }

    public Optional<Team> getTeamByName(String name) {
        return searchRepository.findByName(name);
    }

    public List<Team> search(Map<String, String> params) {
        return null;
    }
}
