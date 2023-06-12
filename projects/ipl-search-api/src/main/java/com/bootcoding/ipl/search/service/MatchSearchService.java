package com.bootcoding.ipl.search.service;

import com.bootcoding.ipl.model.Match;
import com.bootcoding.ipl.search.repository.MatchSearchRepository;
import com.bootcoding.ipl.utils.StringUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MatchSearchService {

    private MatchSearchRepository searchRepository;

    public List<Match> getAllMatches(){
        List<Match> matches = searchRepository.findAll();

        for(Match match : matches){
            match.setVenue(StringUtility.removeDoubleQuote(match.getVenue()));
            match.setTossWinnerTeam(StringUtility.removeDoubleQuote(match.getTossWinnerTeam()));



        }

        return matches;
    }

    public Optional<Match> getMatchById(int id){
        return searchRepository.findById(id);
    }
}
