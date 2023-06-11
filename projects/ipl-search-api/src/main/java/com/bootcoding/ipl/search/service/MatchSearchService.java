package com.bootcoding.ipl.search.service;

import com.bootcoding.ipl.model.Match;
import com.bootcoding.ipl.search.repository.MatchSearchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MatchSearchService {

    private MatchSearchRepository searchRepository;

    public List<Match> getAllMatches(){
        return searchRepository.findAll();
    }

    public Optional<Match> getMatchById(int id){
        return searchRepository.findById(id);
    }
}
