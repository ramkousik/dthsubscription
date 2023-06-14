package com.alkimi.dthsubscription.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PackageDTO {
    private Long id;
    private String name;
    private List<ChannelDTO> channels;

}
