package com.bootcoding.ipl.search.query;

import com.bootcoding.ipl.model.Match;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TeamQueryMapper implements QueryMapper{

    @Override
    public List<Match> mapParameter(Map<String, String> params, List<Match> matches) {
        Optional<String> teamsExists = params.keySet().stream().filter(key -> key.equalsIgnoreCase("teams")).findAny();
        return teamsExists.map(s -> matches.stream().filter(m -> containsTeam(params.get(s), m)).collect(Collectors.toList())).orElse(matches);
    }

    private static boolean containsTeam(String teams, Match m) {
        return teams.contains(m.getTeam1().getName()) || teams.contains(m.getTeam2().getName());
    }
}
