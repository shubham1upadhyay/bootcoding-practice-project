package com.bootcoding.ipl.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class DataResponse {
    List<Match> matches;
}
