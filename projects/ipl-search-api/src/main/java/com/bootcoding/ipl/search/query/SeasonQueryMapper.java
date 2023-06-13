package com.bootcoding.ipl.search.query;

import com.bootcoding.ipl.model.Match;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SeasonQueryMapper implements QueryMapper{

    @Override
    public List<Match> mapParameter(Map<String, String> params, List<Match> matches) {
        Optional<String> seasonsExists = params.keySet().stream().filter(key -> key.equalsIgnoreCase("seasons")).findAny();
        return seasonsExists.map(s -> matches.stream().filter(m -> containsTeam(params.get(s), m)).collect(Collectors.toList())).orElse(matches);

    }

    private static boolean containsTeam(String seasons, Match m) {
        return seasons.contains(m.getSeason()) || seasons.contains(m.getSeason());
    }
}
