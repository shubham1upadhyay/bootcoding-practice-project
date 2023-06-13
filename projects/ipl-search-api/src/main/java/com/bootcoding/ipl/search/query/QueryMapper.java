package com.bootcoding.ipl.search.query;

import com.bootcoding.ipl.model.Match;

import java.util.List;
import java.util.Map;

public interface QueryMapper {

    List<Match> mapParameter(Map<String, String> params, List<Match> matches);
}
///search/ipl/matches/query?teams=Royal%20Challengers%20Bangalore