package com.bootcoding.ipl.search.repository;

import com.bootcoding.ipl.model.DataResponse;
import com.bootcoding.ipl.model.Match;
import com.bootcoding.ipl.store.InMemoryDataStore;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class SearchRepository {

    private DataResponse inMemoryData;

    public List<Match> findAll(){
        return inMemoryData.getMatches();
    }

}
