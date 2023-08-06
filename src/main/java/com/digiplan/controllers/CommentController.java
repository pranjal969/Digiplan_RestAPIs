package com.digiplan.controllers;

import com.digiplan.entities.Comment;
import com.digiplan.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/getComment")
    public ResponseEntity<Map> getComment(@RequestParam String caseId) {
        return this.commentService.getComment(caseId);
    }

    @GetMapping("/getAllComments")
    public List<Comment> getAllComments() {
        return this.commentService.getAllComments();
    }

    @PostMapping("/addComment/{commentType}")
    public ResponseEntity<Map> addComment(@RequestBody Comment commentData, @PathVariable String commentType) {
        return this.commentService.addComment(commentData, commentType);
    }

    @PutMapping("/updateComment/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Integer id, @RequestBody Comment commentData) {
        commentData.setId(id);
        Comment comment = this.commentService.updateComment(id, commentData);
        if (comment != null)
            return new ResponseEntity<Comment>(comment, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteComment/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Integer id) {
        String status = this.commentService.deleteComment(id);
        if (status.equals("Deleted"))
            return new ResponseEntity<String>(status, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/getCommentTypes")
    public ResponseEntity<Map> getCommentTypes(@RequestParam String caseId, @RequestParam String typeOfUser) {
        return commentService.getCommentTypes(caseId, typeOfUser);
    }

}
