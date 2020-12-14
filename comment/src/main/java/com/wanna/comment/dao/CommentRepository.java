package com.wanna.comment.dao;

import com.wanna.comment.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentReposity extends MongoRepository<Comment,String> {

}
