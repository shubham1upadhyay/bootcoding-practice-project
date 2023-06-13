package com.bootcoding.ipl.search.service;

import com.bootcoding.ipl.model.Match;
import com.bootcoding.ipl.model.Team;
import com.bootcoding.ipl.search.query.QueryMapper;
import com.bootcoding.ipl.search.repository.MatchSearchRepository;
import com.bootcoding.ipl.utils.StringUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TeamSearchService {

    private MatchSearchRepository searchRepository;
    private List<QueryMapper> queryMappers;

    public Collection<Team> getAllTeams(){
       return searchRepository.findAllTeams();

    }

}
