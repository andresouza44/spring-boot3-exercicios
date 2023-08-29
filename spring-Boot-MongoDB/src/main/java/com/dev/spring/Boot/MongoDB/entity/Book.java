package com.dev.spring.Boot.MongoDB.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Document
public class Book {
    @Id
    private String id;

    @NonNull
    private Integer bookId;
    @NonNull
    private String bookName;
    @NonNull
    private String bookAuthor;
    @NonNull
    private Double bookCost;


}
