package com.bootcoding.ipl.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Match {
    private int id;
    private Team team1;
    private Team team2;
    private Date date;
    private String season;
    private String matchNumber;
    private String venue;
    private String tossWinnerTeam;
    private String tossDecision;
    private boolean superOver;
    private String winningTeam;
    private String playerOfTheMatch;
    private String umpire1;
    private String umpire2;
    private String city;
    private String wonBy;
    private String margin;
}
