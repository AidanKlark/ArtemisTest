package com.test.artemistest.consumers;

import com.test.artemistest.models.ArtemisLogEntity;
import com.test.artemistest.repository.ArtemisRepository;
import com.test.artemistest.service.ArtemisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.artemis.api.core.management.ActiveMQServerControl;
import org.apache.activemq.artemis.api.core.management.AddressControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.annotation.JmsListenerAnnotationBeanPostProcessor;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSDestinationDefinition;
import java.util.Date;

@Component
@Slf4j
public class ArtemisLogConsumer {

    private final ArtemisService service;

    @Autowired
    public ArtemisLogConsumer(ArtemisService service) {
        this.service = service;
    }

    @JmsListener(destination = "one_q")
    public void addLogOne(String message) {
        log.info("Я ввел в потоке ONE: {}", message);
        service.addLog(message, "one_q");
    }

    @JmsListener(destination = "two_q")
    public void addLogTwo(String message) {
        service.addLog(message, "two_q");
    }

    @JmsListener(destination = "three_q")
    public void addLogThree(String message) {
        service.addLog(message, "three_q");
    }
}
