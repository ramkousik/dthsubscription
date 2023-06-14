package com.alkimi.dthsubscription.service.implementation;

import com.alkimi.dthsubscription.entity.Channel;
import com.alkimi.dthsubscription.exception.NotFoundException;
import com.alkimi.dthsubscription.payload.ChannelDTO;
import com.alkimi.dthsubscription.repository.ChannelRepository;
import com.alkimi.dthsubscription.service.ChannelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChannelServiceImplementation implements ChannelService {

    private final ChannelRepository channelRepository;
    private final ModelMapper modelMapper;

    public ChannelServiceImplementation(ChannelRepository channelRepository, ModelMapper modelMapper) {
        this.channelRepository = channelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ChannelDTO createChannel(ChannelDTO channelDTO) {
        Channel channelEntity = modelMapper.map(channelDTO, Channel.class);
        Channel createdChannel = channelRepository.save(channelEntity);
        return modelMapper.map(createdChannel, ChannelDTO.class);
    }

    @Override
    public ChannelDTO updateChannel(Long channelId, ChannelDTO channelDTO) {
        Channel channelEntity = channelRepository.findById(channelId)
                        .orElseThrow(() -> new NotFoundException("channel not found with id: "+ channelId));
        modelMapper.map(channelDTO, channelEntity);
        Channel updatedChannel = channelRepository.save(channelEntity);
        return modelMapper.map(updatedChannel, ChannelDTO.class);
    }

    @Override
    public ChannelDTO getChannelById(Long channelId) {
        Channel channelEntity = channelRepository.findById(channelId)
                .orElseThrow(() -> new NotFoundException("Channel not found"));
        return modelMapper.map(channelEntity, ChannelDTO.class);
    }

    @Override
    public List<ChannelDTO> getAllChannels() {
        List<Channel> channels = channelRepository.findAll();
        return channels.stream()
                .map(channel -> modelMapper.map(channel, ChannelDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteChannel(Long channelId) {
        Channel channelEntity = channelRepository.findById(channelId)
                .orElseThrow(() ->new NotFoundException("Channel not found: " + channelId) );
        channelRepository.delete(channelEntity);
    }
}