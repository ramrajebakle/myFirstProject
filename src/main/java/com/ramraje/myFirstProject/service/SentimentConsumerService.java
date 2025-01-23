//package com.ramraje.myFirstProject.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SentimentConsumerService {
//
//    @Autowired
//    private EmailService emailService;
//    @KafkaListener
//    public void consume(SentimentData sentimentData){
//    sendEmail(sendEmail(sentimentData));
//}
//    private void sendEmail(SentimentData sentimentData){
//        emailService.sendEmail(sentimentData.getEmail(),"Sentiment for previous week ",sentimentData.getSentiment());
//    }
//}
