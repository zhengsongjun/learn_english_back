package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlashCard {
    private String id;
    private String categoryId;
    private String question;
    private String answer;
    private String masteryStatus;
    private Integer practiceCount;
    private Integer errorCount;
    private Date lastReviewedAt;
    private Date createdAt;
}