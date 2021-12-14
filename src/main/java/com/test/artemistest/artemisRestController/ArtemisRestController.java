package com.test.artemistest.artemisRestController;

import com.test.artemistest.consumers.ArtemisLogConsumer;
import com.test.artemistest.destinations.DestinationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tests")
public class ArtemisRestController {

    private final JmsTemplate jmsTemplate;
    private final DestinationFactory destinationFactory;

    @Autowired
    public ArtemisRestController(JmsTemplate jmsTemplate, DestinationFactory destinationFactory) {
        this.jmsTemplate = jmsTemplate;
        this.destinationFactory = destinationFactory;
    }

    @PostMapping("/{destination}/{message}")
    public String postMessage(@PathVariable(name = "destination") String destination,
                              @PathVariable(name = "message") String message) {

        if (destinationFactory.getDest(destination) != null) {
            jmsTemplate.convertAndSend(destination, message);

        } else {
            return "Неудачный запрос";
        }

        return "Done";
    }
}
