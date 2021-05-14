package com.iqmsoft.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.iqmsoft.author.AuthorDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostListingDTO {
    private Long id;
    private String title;
    private LocalDateTime postedAt;
    private AuthorDTO author;
}
