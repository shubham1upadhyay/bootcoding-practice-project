package com.bootcoding.ipl.converter;

import com.bootcoding.ipl.model.Match;
import com.bootcoding.ipl.model.Player;
import com.bootcoding.ipl.model.Team;
import com.bootcoding.ipl.utils.DateUtility;
import com.bootcoding.ipl.utils.StringUtility;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MatchDataConverter {

    public List<Match> convertToMatches(List<String> records){
         return records.stream().skip(1).map(this::buildMatch).collect(Collectors.toList());
    }

    public Match buildMatch(String record){
        String[] data = record.split(",");
        return Match.builder()
                .id(Integer.parseInt(data[0]))
                .city(data[1])
                .date(DateUtility.getDate(data[2]))
                .season(data[3])
                .matchNumber(data[4])
                .team1(buildTeam(data[5], StringUtility.extractFromSquareBrackets(record, true)))
                .team2(buildTeam(data[6], StringUtility.extractFromSquareBrackets(record, false)))
                .venue(data[7])
                .tossWinnerTeam(data[8])
                .tossDecision(data[9])
                .superOver(getSuperOver(data[10]))
                .winningTeam(data[data.length-4])
                .wonBy(data[12])
                .margin(data[13])
                .playerOfTheMatch(data[data.length-3])
                .umpire1(data[data.length-2])
                .umpire2(data[data.length-1])
                .build();
    }
//1312199,Ahmedabad,2022-05-27,2022,Qualifier 2,Royal Challengers Bangalore,Rajasthan Royals,"Narendra Modi Stadium, Ahmedabad",Rajasthan Royals,field,N,Rajasthan Royals,Wickets,7,NA,JC Buttler,"['V Kohli', 'F du Plessis', 'RM Patidar', 'GJ Maxwell', 'MK Lomror', 'KD Karthik', 'Shahbaz Ahmed', 'PWH de Silva', 'HV Patel', 'JR Hazlewood', 'Mohammed Siraj']","['YBK Jaiswal', 'JC Buttler', 'SV Samson', 'D Padikkal', 'SO Hetmyer', 'R Parag', 'R Ashwin', 'TA Boult', 'YS Chahal', 'M Prasidh Krishna', 'OC McCoy']",CB Gaffaney,Nitin Menon
    private Team buildTeam(String teamName, String players) {
        return Team.builder()
                .name(teamName)
                .players(buildPlayers(players))
                .build();
    }

    private List<Player> buildPlayers(String playersStr) {
        playersStr = sanitize(playersStr);
        String[] players = playersStr.split(",");
        List<Player> playerList = new ArrayList<>();
        for (String player : players) {
            playerList.add(Player.builder().name(player).build());
        }
        return playerList;
    }

    private String sanitize(String players) {
        return players.replace("[", "").replace("]", "");
    }

    private boolean getSuperOver(String value) {
        return value.equals("Y");
    }
}
