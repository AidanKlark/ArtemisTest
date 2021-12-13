package com.test.artemistest.artemisRestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tests")
public class ArtemisRestController {

    private JmsTemplate jmsTemplate;
    private final String destinationOne = "One";
    private final String destinationTwo = "Two";
    private final String destinationThree = "Three";

    @Autowired
    public ArtemisRestController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
    @PostMapping("/{destination}/{message}")
    public String postMessage(@PathVariable(name = "destination") String destination,
                              @PathVariable(name = "message") String message) {

        if (destination == destinationOne) {
        jmsTemplate.convertAndSend(destinationOne, message);

        } else if (destination == destinationTwo) {
        jmsTemplate.convertAndSend(destinationTwo, message);

        } else if (destination == destinationThree) {
        jmsTemplate.convertAndSend(destinationThree, message);

        } else return "Неудачный запрос";

        return "Done";
    }



}
