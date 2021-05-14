package com.iqmsoft.post;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import com.iqmsoft.author.AuthorDTO;
import com.iqmsoft.comment.CommentDTO;

@Data
public class PostInfoDTO extends PostListingDTO {
    private String content;
    private List<CommentDTO> comments;

    public PostInfoDTO() {
    }

    public PostInfoDTO(Long id, String title, LocalDateTime postedAt, AuthorDTO author, String content, List<CommentDTO> comments) {
        super(id, title, postedAt, author);
        this.content = content;
        this.comments = comments;
    }
}
