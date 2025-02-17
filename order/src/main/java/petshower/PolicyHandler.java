package petshower;

import petshower.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReserveAccepted_(@Payload ReserveAccepted reserveAccepted){

        if(reserveAccepted.isMe()){
            System.out.println("##### listener  : " + reserveAccepted.toJson());
            
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReserveCanceled_(@Payload ReserveCanceled reserveCanceled){

        if(reserveCanceled.isMe()){
            System.out.println("##### listener  : " + reserveCanceled.toJson());
        }
    }

}
