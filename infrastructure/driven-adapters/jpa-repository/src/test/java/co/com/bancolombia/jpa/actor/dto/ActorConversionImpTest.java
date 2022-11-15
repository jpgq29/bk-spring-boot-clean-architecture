package co.com.bancolombia.jpa.actor.dto;

import co.com.bancolombia.model.actor.Actor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reactivecommons.utils.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ActorConversionImpTest {
    @Mock
    ObjectMapper mapper;
    @InjectMocks
    ActorConversionImp conversion;

    @Test
    void listConversion(){
        List<Actor> actorList = new ArrayList<>();
        actorList.add(new Actor().toBuilder().actorId(33L).firstName("Juan").lastName("b").build());
        actorList.add(new Actor().toBuilder().actorId(34L).firstName("Angelica").lastName("b").build());

        when(mapper.map(any(),any())).thenReturn(new ActorResponse().toBuilder().actorId(33L).firstName("Juan").build());

        List<ActorResponse> actorResponseList =  conversion.listConversion(actorList);

        System.out.println("actorResponseList = " + actorResponseList.size());

        Assertions.assertEquals(actorResponseList.size(),2);
        Assertions.assertEquals(actorResponseList.get(0).getActorId(),33L);
    }

    @Test
    void conversion() {
        ActorResponse a = new ActorResponse();
        a.setActorId(33L);

        when(mapper.map(any(), any())).thenReturn(a);

        ActorResponse actor = conversion.conversion(Actor.builder().actorId(33L).build());
        Assertions.assertEquals(actor.getActorId(), 33L);
    }
}