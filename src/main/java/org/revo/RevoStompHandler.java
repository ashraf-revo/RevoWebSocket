package org.revo;

import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;

import java.lang.reflect.Type;
import java.util.function.Consumer;

/**
 * Created by revo on 23/12/15.
 */
public class RevoStompHandler<T> implements StompFrameHandler {
    private Type aClass;
    private Consumer<T> consumer;

    public RevoStompHandler(Class<T> aClass, Consumer<T> consumer) {
        this.aClass = aClass;
        this.consumer = consumer;
    }

    public Type getPayloadType(StompHeaders headers) {
        return aClass;
    }

    public void handleFrame(StompHeaders headers, Object payload) {
        consumer.accept((T) payload);
    }
}
