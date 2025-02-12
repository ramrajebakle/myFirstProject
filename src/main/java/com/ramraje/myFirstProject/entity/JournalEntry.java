package com.ramraje.myFirstProject.entity;

import com.ramraje.myFirstProject.enums.Sentiment;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection ="journal_entries")
@Getter
@Setter
public class JournalEntry {
    @Id
    private ObjectId id;
    @NonNull
    private  String title;
    private  String content;
    private  LocalDateTime date;
    private Sentiment sentiment;
//    public void setId(ObjectId id) {
//        this.id = id;
//    }
//
//    public ObjectId getId() {
//        return id;
//    }
//    public LocalDateTime getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDateTime date) {
//        this.date = date;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//    public void setContent(String content) {
//        this.content = content;
//    }

}
