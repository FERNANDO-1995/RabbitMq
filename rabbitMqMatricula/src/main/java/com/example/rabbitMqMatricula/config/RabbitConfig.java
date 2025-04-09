package com.example.rabbitMqMatricula.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue matriculaQueue() {
        return new Queue("matriculaQueue", true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("matriculaExchange");
    }

    @Bean
    public Binding binding(Queue matriculaQueue, TopicExchange exchange) {
        return BindingBuilder.bind(matriculaQueue).to(exchange).with("matricula.routing.key");
    }
}
