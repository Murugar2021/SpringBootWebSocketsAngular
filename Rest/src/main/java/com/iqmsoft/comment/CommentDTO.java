package com.iqmsoft.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.iqmsoft.author.AuthorDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Long id;
    private String content;
    private AuthorDTO author;
    private LocalDateTime postedAt;
}
