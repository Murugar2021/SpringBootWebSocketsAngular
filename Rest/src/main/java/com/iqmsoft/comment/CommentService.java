package com.iqmsoft.comment;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iqmsoft.author.AuthorNotFoundException;
import com.iqmsoft.author.AuthorRepository;
import com.iqmsoft.author.AuthorService;
import com.iqmsoft.post.Post;
import com.iqmsoft.post.PostNotFoundException;
import com.iqmsoft.post.PostRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CommentService {
    private AuthorService authorService;
    private PostRepository postRepository;
    private AuthorRepository authorRepository;

    @Transactional
    public CommentDTO createComment(Long postId, CommentInputDTO comment) {
        Post post = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);
        Comment entity = new Comment(
            null,
            post,
            authorRepository.findById(comment.getAuthorId()).orElseThrow(AuthorNotFoundException::new),
            comment.getContent(),
            LocalDateTime.now());
        post.getComments().add(entity);
        return getDTO(entity);
    }

    public CommentDTO getDTO(Comment entity) {
        return new CommentDTO(
            entity.getId(),
            entity.getContent(),
            authorService.getDTO(entity.getAuthor()),
            entity.getPostedAt());
    }
}
