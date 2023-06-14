package com.alkimi.dthsubscription.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ChannelDTO {
    private Long id;
    private String name;
    private BigDecimal cost;
    private String language;


}
