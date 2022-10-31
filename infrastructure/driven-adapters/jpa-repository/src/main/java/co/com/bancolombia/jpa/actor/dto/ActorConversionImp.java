package co.com.bancolombia.jpa.actor.dto;

import co.com.bancolombia.jpa.common.IConversion;
import co.com.bancolombia.model.actor.Actor;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorConversionImp implements IConversion<Actor, ActorResponse> {
    @Autowired
    private ObjectMapper mapper;
    @Override
    public List<ActorResponse> listConversion(List<Actor> actor) {
        return actor.stream().map(dato -> mapper.map(dato,ActorResponse.class)).collect(Collectors.toList());
    }

    @Override
    public ActorResponse conversion(Actor data) {
        return mapper.map(data,ActorResponse.class);
    }
}
