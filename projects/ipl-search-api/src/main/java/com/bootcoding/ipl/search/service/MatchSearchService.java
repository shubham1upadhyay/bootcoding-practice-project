package com.bootcoding.ipl.search.service;
import com.bootcoding.ipl.model.Match;
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
        for(Match match : matches) {
            match.setVenue(StringUtility.removeDoubleQuote(match.getVenue()));
            match.setTossWinnerTeam(StringUtility.removeDoubleQuote(match.getTossWinnerTeam()));

            // player of the match
            match.setPlayerOfTheMatch(StringUtility.removeExtraRegex(match.getPlayerOfTheMatch()));

            //winning team
            match.setWinningTeam(StringUtility.removeExtraRegex(match.getWinningTeam()));

              //  removing extra quotes from players name
            for(int i=0; i<match.getTeam1().getPlayers().toArray().length &&
               i<match.getTeam2().getPlayers().toArray().length; i++)
            {
                match.getTeam1().getPlayers().get(i).setName(StringUtility.removeExtraRegex(match.getTeam1().getPlayers().get(i).getName()));
                match.getTeam2().getPlayers().get(i).setName(StringUtility.removeExtraRegex(match.getTeam2().getPlayers().get(i).getName()));

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
