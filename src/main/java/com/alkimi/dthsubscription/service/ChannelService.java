package com.alkimi.dthsubscription.service;

import com.alkimi.dthsubscription.entity.Channel;
import com.alkimi.dthsubscription.payload.ChannelDTO;

import java.util.List;

public interface ChannelService {
    List<ChannelDTO> getAllChannels();
    ChannelDTO getChannelById(Long channelId);
    ChannelDTO createChannel(ChannelDTO channelDTO);
    ChannelDTO updateChannel(Long id, ChannelDTO channelDTO);
    void deleteChannel(Long id);



}
