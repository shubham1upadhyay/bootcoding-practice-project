package com.bootcoding.ipl.search.service;

import com.bootcoding.ipl.model.Match;
import com.bootcoding.ipl.model.Player;
import com.bootcoding.ipl.model.Team;
import com.bootcoding.ipl.search.query.QueryMapper;
import com.bootcoding.ipl.search.repository.MatchSearchRepository;
import com.bootcoding.ipl.utils.StringUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MatchSearchService {

    private MatchSearchRepository searchRepository;
    private List<QueryMapper> queryMappers;


    public List<Match> getAllMatches(){
        List<Match> matches = searchRepository.findAll();

        for(Match match : matches){
            match.setVenue(StringUtility.removeDoubleQuote(match.getVenue()));
            match.setTossWinnerTeam(StringUtility.removeDoubleQuote(match.getTossWinnerTeam()));
            for (Player player : match.getTeam1().getPlayers()) {
                player.setName(StringUtility.removeSingleQuotes(player.getName()));
            } for (Player player : match.getTeam2().getPlayers()) {
                player.setName(StringUtility.removeSingleQuotes(player.getName()));
            }
        }

        return matches;
    }

    public Optional<Match> getMatchById(int id){
        return searchRepository.findById(id);
    }

    public List<Match> search(Map<String, String> params) {
        List<Match> allMatches = getAllMatches();
        List<Match> filteredMatches = queryMappers.stream().map(queryMapper -> queryMapper.mapParameter(params, allMatches))
                .flatMap(List::stream).collect(Collectors.toList());
        return filteredMatches;
    }
}
