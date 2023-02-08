package com.sbszc.eduspringbootrabbitmqproducer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class PublisherController {

    private final RabbitTemplate template;

    public PublisherController(RabbitTemplate template) {
        this.template = template;
    }

    @PostMapping("/publish-message")
    public String publishMessage(@RequestBody CustomMessage message) {
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.BINDING_KEY, message);

        System.out.printf("message: %s%n", message);
        return String.format("message: %s", message);
    }

    @GetMapping("/ping")
    public String ping() {
        return "ping";
    }
}
