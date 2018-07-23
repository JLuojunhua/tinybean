package com.qqdzz.controller;

import com.qqdzz.entity.Comment;
import com.qqdzz.entity.JsonResult;
import com.qqdzz.entity.User;
import com.qqdzz.service.CommentService;
import com.qqdzz.service.UserService;
import com.qqdzz.vo.CommentVO;
import com.qqdzz.vo.SearchUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;

    /**
     * 根据用户id或用户名查找用户
     * @param userIdOrName
     * @return
     */
    @GetMapping("/searchuser")
    public JsonResult<SearchUserVO> searchUser(String userIdOrName){
        List<SearchUserVO> searchUserVOList = new ArrayList<SearchUserVO>();
        Integer userId = Integer.valueOf(userIdOrName);
        User user = userService.findById(userId);
        if (user != null) {
            searchUserVOList.add(new SearchUserVO(userId, user.getIcon(), user.getUserName()));
        }
        String userName = userIdOrName;
        user = userService.findByUserName(userName);
        if (user != null) {
            searchUserVOList.add(new SearchUserVO(userId, user.getIcon(), user.getUserName()));
        }
        return new JsonResult<SearchUserVO>(searchUserVOList);
    }

    /**
     * 根据用户id删除用户+返回再次搜索结果
     * @param userId
     * @return
     */
    @DeleteMapping("/user")
    public JsonResult<SearchUserVO> deleteUser(Integer userId){
        userService.doRemove(userId);
        return this.searchUser(userId.toString());
    }

    /**
     * 根据userId/commentId/commentText进行搜索
     * 若搜索内容为空 返回十条
     * @param condition
     * @return
     */
    @GetMapping("/comment")
    public JsonResult<CommentVO> getCommentByCondition(String condition){
        List<CommentVO> commentVOList = new ArrayList<CommentVO>();
        if (condition != "") {
            Integer userId = Integer.valueOf(condition);
            Comment comment = commentService.findByUserId(userId);
            if (comment != null) {
                User user = userService.findById(comment.getUserId());
                commentVOList.add(new CommentVO(user.getId(), user.getIcon(), user.getUserName(), comment.getId(), comment.getComment()));
            }

            Integer commentId = Integer.valueOf(condition);
            comment = commentService.findById(commentId);
            if (comment != null) {
                User user = userService.findById(comment.getUserId());
                commentVOList.add(new CommentVO(user.getId(), user.getIcon(), user.getUserName(), comment.getId(), comment.getComment()));
            }

            String commentText = condition;
            comment = commentService.findByCommentText(commentText);
            if (comment != null) {
                User user = userService.findById(comment.getUserId());
                commentVOList.add(new CommentVO(user.getId(), user.getIcon(), user.getUserName(), comment.getId(), comment.getComment()));
            }
        } else {
            List<Comment> commentList = commentService.findBannedAll();
            int time = 10;
            for (int index = 0; index < time; index++) {
                Comment comment = commentList.get(index);
                User user = userService.findById(comment.getUserId());
                commentVOList.add(new CommentVO(user.getId(), user.getIcon(), user.getUserName(), comment.getId(), comment.getComment()));
            }
        }
        return new JsonResult<CommentVO>(commentVOList);
    }

    @DeleteMapping("/comment")
    private JsonResult<CommentVO> deleteCommentByCommentId(Integer commentId){
        commentService.doRemove(commentId);
        return this.getCommentByCondition(commentId.toString());
    }
}
