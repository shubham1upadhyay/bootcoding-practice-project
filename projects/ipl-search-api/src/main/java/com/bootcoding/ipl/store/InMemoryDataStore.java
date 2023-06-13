package com.bootcoding.ipl.store;

import com.bootcoding.ipl.converter.MatchDataConverter;
import com.bootcoding.ipl.model.DataRequest;
import com.bootcoding.ipl.model.DataResponse;
import com.bootcoding.ipl.model.Match;
import com.bootcoding.ipl.model.Team;
import com.bootcoding.ipl.utils.FileUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class InMemoryDataStore implements DataStore<DataResponse, DataRequest>{

    private MatchDataConverter matchDataConverter;

    @Override
    public DataResponse load(DataRequest request) {
        String filePath = request.getFilePath();
        List<String> lines = FileUtility.readLines(filePath);
        List<Match> matches = matchDataConverter.convertToMatches(lines);
        return DataResponse.builder().matches(matches).teams(buildTeams(matches)).build();
    }

    private Map<String, Team> buildTeams(List<Match> matches) {

        Map<String, Team> teams = new HashMap<>();
        for(Match match: matches){
            teams.putIfAbsent(match.getTeam1().getName(), match.getTeam1());
            teams.putIfAbsent(match.getTeam2().getName(), match.getTeam2());
        }
       return teams;
    }
}
