package com.example.GraphQLPlayground.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookInput {
    private Long authorId;
    private Long bookId;
    private String title;
    private String publisher;
}
