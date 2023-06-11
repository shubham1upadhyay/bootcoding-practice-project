package com.bootcoding.ipl.search.service;

import com.bootcoding.ipl.model.Match;
import com.bootcoding.ipl.search.repository.SearchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SearchService {

    private SearchRepository searchRepository;

    public List<Match> getAllMatches(){
        return searchRepository.findAll();
    }
}
