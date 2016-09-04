package com.nowcoder.service;

import com.nowcoder.dao.CommentDao;
import com.nowcoder.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

/**
 * Created by zhulehao on 16/7/30.
 */
@Service
public class CommentService {

    @Autowired
    CommentDao commentDAO;

    @Autowired
    SensitiveService sensitiveService;
    public List<Comment> getCommentsByEntity(int entityId, int entityType){
        return commentDAO.selectByEntity(entityId, entityType);
    }
    public int addComment(Comment comment) {
        comment.setContent(HtmlUtils.htmlEscape(comment.getContent()));
        comment.setContent(sensitiveService.filter(comment.getContent()));

        return commentDAO.addComment(comment);
    }
    public int getUserCommentCount(int userId) {
        return commentDAO.getUserCommentCount(userId);
    }
    public int getCommentCount(int entityId, int entityType) {
        return commentDAO.getCommentCount(entityId, entityType);
    }
    public Comment getCommentById(int id) {
        return commentDAO.getCommentById(id);
    }
    public void deleteComment(int entityId, int entityType) {
        commentDAO.updateStatus(entityId, entityType, 1);
    }
}
