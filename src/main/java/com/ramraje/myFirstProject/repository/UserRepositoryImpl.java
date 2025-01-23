package com.ramraje.myFirstProject.repository;

import com.ramraje.myFirstProject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getUserForSA(){
//        Query query = new Query();
//        query.addCriteria(Criteria.where("email").exists(true));
//        query.addCriteria(Criteria.where("email").ne(null).ne(""));
//        query.addCriteria(Criteria.where("sentimentAnalysis").is(true));
//        List<User> users= mongoTemplate.find(query, User.class);
//        return users;
        Query query = new Query();
        query.addCriteria(Criteria.where("email").regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$"));
        query.addCriteria(Criteria.where("sentimentAnalysis").is(true));
        return mongoTemplate.find(query, User.class);
//        Criteria criteria = new Criteria();
//        query.addCriteria(criteria.orOperator(
//                Criteria.where("email").exists(true),
//                Criteria.where("sentimentAnalysis").is(true)
//        ));
    }

}
