package com.ramraje.myFirstProject.scheduler;

import com.ramraje.myFirstProject.cache.AppCache;
import com.ramraje.myFirstProject.entity.JournalEntry;
import com.ramraje.myFirstProject.entity.User;
import com.ramraje.myFirstProject.enums.Sentiment;
import com.ramraje.myFirstProject.repository.UserRepositoryImpl;
import com.ramraje.myFirstProject.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserSheduler {

    @Autowired
    private EmailService emailService;
    @Autowired
    private AppCache appCache;

    @Autowired
    private UserRepositoryImpl userRepository;
//
//    @Autowired
//    private SentimentAnalysisService sentimentAnalysisService;

    @Scheduled(cron = "0 0 9 * * SUN")
//@Scheduled(cron = "0 0/1 * * * *") // Every minute

public void fetchUserAndSendSaMail(){
       List<User> users= userRepository.getUserForSA();
       for(User user:users){
           List<JournalEntry> journalEntries= user.getJournalEntries();
           List<Sentiment> sentiments = journalEntries.stream().filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).map(x -> x.getSentiment()).collect(Collectors.toList());
           Map<Sentiment, Integer> sentimentCounts = new HashMap<>();
           for (Sentiment sentiment : sentiments) {
               if (sentiment != null)
                   sentimentCounts.put(sentiment, sentimentCounts.getOrDefault(sentiment, 0) + 1);
           }
           Sentiment mostFrequentSentiment = null;
           int maxCount = 0;
           for (Map.Entry<Sentiment, Integer> entry : sentimentCounts.entrySet()) {
               if (entry.getValue() > maxCount) {
                   maxCount = entry.getValue();
                   mostFrequentSentiment = entry.getKey();
               }
           }
           if (mostFrequentSentiment != null) {
               emailService.sendEmail(user.getEmail(),"Sentiment for last 7 days",mostFrequentSentiment.toString());
           }
       }
        emailService.sendEmail(
                "bakleramraje@gmail.com",
                "Testing Java main Sender",
                "Hii Buddy, How are you?"
        );
    }

    @Scheduled(cron = "0 0/5 * * * *")
    public void appCacheClear() {
        appCache.init();
    }
}
