package com.bootcoding.ipl.search.repository;

import com.bootcoding.ipl.model.DataResponse;
import com.bootcoding.ipl.model.Match;
import com.bootcoding.ipl.model.Team;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class MatchSearchRepository {

    private DataResponse inMemoryData;

    public List<Match> findAll(){
        return inMemoryData.getMatches();
    }

    public Optional<Match> findById(int id){
       return inMemoryData.getMatches().stream().filter(match -> match.getId()==id).findAny();
    }


}
