package com.bootcoding.ipl.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Builder
@Data
public class DataResponse {
    List<Match> matches;

    Map<String, Team> teams;

}
