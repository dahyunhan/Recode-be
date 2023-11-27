package com.abo2.recode.controller;

import com.abo2.recode.config.auth.LoginUser;
import com.abo2.recode.dto.ResponseDto;
import com.abo2.recode.dto.post.PostReqDto;
import com.abo2.recode.dto.post.PostRespDto;
import com.abo2.recode.service.PostReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostReplyController {

    private final PostReplyService postReplyService;


    // 게시글 댓글 작성
    @PostMapping("/v1/study/{postId}/postReply")
    public ResponseEntity<?> createPostReply(@AuthenticationPrincipal LoginUser loginUser, @RequestBody PostReqDto.PostReplyReqDto postReplyReqDto) {
        PostRespDto.PostReplyRespDto createdPostReply = postReplyService.createPostReply(loginUser.getUser().getId(), postReplyReqDto);

        return new ResponseEntity<>(new ResponseDto<>(1, "댓글 작성 완료", postReplyReqDto), HttpStatus.OK);
    }

    // 게시글 댓글 수정
    @PutMapping("/v1/study/{post_id}/postReply/{postReply_id}")
    public ResponseEntity<?> updatePostReply(@PathVariable("post_id") Long postId, @PathVariable("postReply_id") Long postReplyId, @RequestBody PostReqDto.PostReplyReqDto postReplyReqDto) {
        PostRespDto.PostReplyRespDto updatedPostReply = postReplyService.updatePostReply(postId, postReplyId, postReplyReqDto);

        return new ResponseEntity<>(new ResponseDto(1, "댓글 수정 완료", updatedPostReply), HttpStatus.OK);
    }

    // 게시글 댓글 삭제
    @DeleteMapping("/v1/study/{post_id}/postReply/{postReply_id}")
    public ResponseEntity<?> deletePostReply(@PathVariable("post_id") Long postId, @PathVariable("postReply_id") Long postReplyId) {
        postReplyService.deletePostReply(postId, postReplyId);

        return new ResponseEntity<>(new ResponseDto<>(1, "댓글 삭제 완료", null), HttpStatus.OK);
    }

}

