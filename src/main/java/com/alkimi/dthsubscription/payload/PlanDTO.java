package com.alkimi.dthsubscription.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PlanDTO {
    private Long id;
    private String name;
    private String duration;
}
