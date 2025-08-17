package com.nirmaan.Sample.dto;

import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmitQuizDTO {
    private Long quizId;
    private List<AnswerSubmissionDTO> answers;
}
