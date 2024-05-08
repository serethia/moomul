package com.cheerup.moomul.domain.post.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cheerup.moomul.domain.member.entity.UserDetailDto;
import com.cheerup.moomul.domain.post.dto.CommentRequestDto;
import com.cheerup.moomul.domain.post.dto.CommentResponseDto;
import com.cheerup.moomul.domain.post.dto.PostCommentRequestParam;
import com.cheerup.moomul.domain.post.dto.PostLikeResponseDto;
import com.cheerup.moomul.domain.post.dto.PostRequestDto;
import com.cheerup.moomul.domain.post.dto.PostResponseDto;
import com.cheerup.moomul.domain.post.dto.VoteRequestDto;
import com.cheerup.moomul.domain.post.service.FromMeService;
import com.cheerup.moomul.global.response.BaseException;
import com.cheerup.moomul.global.response.ErrorCode;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(("/users/{userId}/fromme"))
public class FromMeController {
	private final FromMeService fromMeService;

	@DeleteMapping("/{frommeId}")
	public ResponseEntity<Void> deleteFromMe(@AuthenticationPrincipal UserDetailDto user, @PathVariable Long userId,
		@PathVariable Long frommeId) {
		if (user == null) {
			throw new BaseException(ErrorCode.NO_JWT_TOKEN);
		}

		if (!user.Id().equals(userId)) {
			throw new BaseException(ErrorCode.NO_AUTHORITY);
		}

		fromMeService.removeFromMe(userId, frommeId);
		return ResponseEntity.ok().build();
	}

	@PostMapping
	public ResponseEntity<Void> postFromMe(@PathVariable Long userId,
		@RequestBody PostRequestDto postRequestDto) {
		fromMeService.createFromMe(userId, postRequestDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<PostResponseDto>> getFromMeFeed(@AuthenticationPrincipal UserDetailDto user,
		@PathVariable Long userId, Pageable pageable) {
		return ResponseEntity.ok(fromMeService.getFromMeFeed(user, userId, pageable));
	}

	@GetMapping("/{frommeId}")
	public ResponseEntity<PostResponseDto> getFromMe(@AuthenticationPrincipal UserDetailDto user,
		@PathVariable Long frommeId,
		@PathVariable Long userId) {
		return ResponseEntity.ok(fromMeService.getFromMe(user, userId, frommeId));
	}

	@PostMapping("/{frommeId}/likes")
	public ResponseEntity<PostLikeResponseDto> postFromMeLikes(@AuthenticationPrincipal UserDetailDto user,
		@PathVariable Long userId,
		@PathVariable Long frommeId) {
		if (user == null) {
			throw new BaseException(ErrorCode.NO_JWT_TOKEN);
		}

		PostLikeResponseDto likeCnt = fromMeService.likeFromMe(user, userId, frommeId);
		return ResponseEntity.ok().body(likeCnt);
	}

	@PatchMapping("/{frommeId}/votes")
	public ResponseEntity<PostResponseDto> voteFromMe(@AuthenticationPrincipal UserDetailDto user,
		@RequestBody VoteRequestDto voted,
		@PathVariable Long userId,
		@PathVariable Long frommeId) {
		if (user == null) {
			throw new BaseException(ErrorCode.NO_JWT_TOKEN);
		}

		fromMeService.selectFromMeVote(voted, userId, frommeId, user);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{frommeId}/comments")
	ResponseEntity<List<CommentResponseDto>> getComments(@PathVariable Long frommeId) {
		PostCommentRequestParam param = new PostCommentRequestParam(1L, 1L, 1);
		List<CommentResponseDto> result = fromMeService.getComments(frommeId, param);
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}

	@PostMapping("{frommeId}/comments")
	ResponseEntity<List<CommentResponseDto>> postComments(@AuthenticationPrincipal UserDetailDto user,
		@PathVariable Long userId,
		@PathVariable Long frommeId, @RequestBody CommentRequestDto comment) {

		if (user == null) {
			throw new BaseException(ErrorCode.NO_JWT_TOKEN);
		}

		if (!user.Id().equals(userId)) {
			throw new BaseException(ErrorCode.NO_AUTHORITY);
		}

		fromMeService.createComments(user, frommeId, comment); //현재 로그인 user, 게시글 userId, 게시글 Id

		PostCommentRequestParam param = new PostCommentRequestParam(1L, 1L, 1);
		List<CommentResponseDto> result = fromMeService.getComments(frommeId, param);
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}
}