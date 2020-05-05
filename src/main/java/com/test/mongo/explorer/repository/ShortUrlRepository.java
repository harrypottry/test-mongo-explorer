package com.test.mongo.explorer.repository;

import com.test.mongo.explorer.entity.ShortUrl;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShortUrlRepository extends MongoRepository<ShortUrl,String> {

//    ShortUrl findBySurl(String surl);

}
