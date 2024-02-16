package org.example.service;

import org.example.aspects.ToLog;
import org.example.model.Comment;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @ToLog
    public String publishComment(Comment comment) {
        System.out.println("Опубликовать комментарий: " + comment.getText());
        return "SUCCESS";
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}