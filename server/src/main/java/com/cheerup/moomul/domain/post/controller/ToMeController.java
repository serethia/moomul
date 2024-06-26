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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cheerup.moomul.domain.member.entity.UserDetailDto;
import com.cheerup.moomul.domain.post.dto.CommentRequestDto;
import com.cheerup.moomul.domain.post.dto.CommentResponseDto;
import com.cheerup.moomul.domain.post.dto.PostCommentRequestParam;
import com.cheerup.moomul.domain.post.dto.PostLikeResponseDto;
import com.cheerup.moomul.domain.post.dto.PostRequestDto;
import com.cheerup.moomul.domain.post.dto.PostResponseDto;
import com.cheerup.moomul.domain.post.dto.ReplyRequestDto;
import com.cheerup.moomul.domain.post.dto.VoteRequestDto;
import com.cheerup.moomul.domain.post.service.ToMeService;
import com.cheerup.moomul.global.response.BaseException;
import com.cheerup.moomul.global.response.ErrorCode;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping(("/tome"))
@Slf4j
public class ToMeController {
	private final ToMeService toMeService;

	@GetMapping("/{tomeId}/comments")
	ResponseEntity<List<CommentResponseDto>> getComments(@PathVariable Long tomeId) {
		PostCommentRequestParam param = new PostCommentRequestParam(1L, 1L, 1);
		List<CommentResponseDto> result = toMeService.getComments(tomeId, param);
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}

	@PostMapping("{tomeId}/comments")
	ResponseEntity<List<CommentResponseDto>> postComments(@AuthenticationPrincipal UserDetailDto user,
		@PathVariable Long tomeId, @RequestBody CommentRequestDto comment) {

		if (user == null) {
			throw new BaseException(ErrorCode.NO_LOGIN);
		}

		toMeService.createComments(user, tomeId, comment); //현재 로그인 user, 게시글 userId, 게시글 Id

		PostCommentRequestParam param = new PostCommentRequestParam(1L, 1L, 1);
		List<CommentResponseDto> result = toMeService.getComments(tomeId, param);
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}

	@PostMapping
	public ResponseEntity<Void> postToMe(@RequestParam String username, @RequestBody PostRequestDto postRequestDto) {
		toMeService.createToMe(username, postRequestDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/replied")
	public ResponseEntity<List<PostResponseDto>> getRepliedToMe(@AuthenticationPrincipal UserDetailDto user,
		@RequestParam String username, Pageable pageable) {
		return ResponseEntity.ok(toMeService.getRepliedToMe(user, username, pageable));
	}

	@GetMapping("/not-replied")
	public ResponseEntity<List<PostResponseDto>> getNotRepliedToMe(@AuthenticationPrincipal UserDetailDto user,
		@RequestParam String username, Pageable pageable) {
		return ResponseEntity.ok(toMeService.getNotRepliedToMe(user, username, pageable));
	}

	@GetMapping("/{tomeId}")
	public ResponseEntity<PostResponseDto> getToMe(@AuthenticationPrincipal UserDetailDto user,
		@PathVariable Long tomeId,
		@RequestParam String username) {
		return ResponseEntity.ok(toMeService.getToMe(user, username, tomeId));
	}

	@DeleteMapping("/{tomeId}")
	public ResponseEntity<Void> deleteToMe(@AuthenticationPrincipal UserDetailDto user, @RequestParam String username,
		@PathVariable Long tomeId) {
		if (user == null) {
			throw new BaseException(ErrorCode.NO_JWT_TOKEN);
		}

		if (!user.username().equals(username)) {
			throw new BaseException(ErrorCode.NO_AUTHORITY);
		}

		toMeService.removeToMe(username, tomeId);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/{tomeId}/replies")
	public ResponseEntity<Void> postReplies(@AuthenticationPrincipal UserDetailDto user,
		@RequestBody ReplyRequestDto reply,
		@RequestParam String username,
		@PathVariable Long tomeId, Pageable pageable) {
		if (user == null) {
			throw new BaseException(ErrorCode.NO_JWT_TOKEN);
		}

		if (!user.username().equals(username)) {
			throw new BaseException(ErrorCode.NO_AUTHORITY);
		}

		toMeService.createReplies(reply, username, tomeId, user, pageable);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/{tomeId}/likes")
	public ResponseEntity<PostLikeResponseDto> postToMeLikes(@AuthenticationPrincipal UserDetailDto user,
		@RequestParam String username,
		@PathVariable Long tomeId) {
		if (user == null) {
			throw new BaseException(ErrorCode.NO_JWT_TOKEN);
		}

		PostLikeResponseDto likeCnt = toMeService.likeToMe(username, tomeId);
		return ResponseEntity.ok().body(likeCnt);
	}

	@PatchMapping("/{tomeId}/votes")
	public ResponseEntity<PostResponseDto> voteToMe(@AuthenticationPrincipal UserDetailDto user,
		@RequestBody VoteRequestDto voted,
		@RequestParam String username,
		@PathVariable Long tomeId) {
		if (user == null) {
			throw new BaseException(ErrorCode.NO_JWT_TOKEN);
		}

		if (!user.username().equals(username)) {
			throw new BaseException(ErrorCode.NO_AUTHORITY);
		}

		PostResponseDto dto = toMeService.selectToMeVote(voted, username, tomeId, user);
		return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
	}
}
