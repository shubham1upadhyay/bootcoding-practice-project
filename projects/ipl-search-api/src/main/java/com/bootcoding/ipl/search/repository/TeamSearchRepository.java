package com.bootcoding.ipl.search.repository;

import com.bootcoding.ipl.model.DataResponse;
import com.bootcoding.ipl.model.Team;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class TeamSearchRepository {

    private DataResponse inMemoryData;


    public Collection<Team> findAllTeams(){
        return inMemoryData.getTeams().values();
    }

    public Optional<Team> findByName(String name) {
        return inMemoryData.getTeams().values().stream().filter(team -> team.getName().equals(name)).findAny();
    }
}
