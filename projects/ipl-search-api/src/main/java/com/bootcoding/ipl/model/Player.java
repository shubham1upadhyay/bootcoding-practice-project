package com.bootcoding.ipl.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {
    private String name;
    private PlayerType type;
}
