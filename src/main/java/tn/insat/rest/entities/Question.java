package tn.insat.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by zied on 19/02/2018.
 */
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue()
    private Integer questionId;

    @Column(length = 100000)
    private String questionHeader;

    @Column(length = 100000)
    private String questionCode;

    @Column(length = 100000)
    private String questionStatement;

    // 1: Single Select, 2: Multiple Select
    private int questionType;

    private String questionExplanation;

    @ManyToOne
    @JoinColumn(name = "chapterId")
    @JsonIgnoreProperties("questions")
    private Chapter chapter;

    @OneToMany(mappedBy = "questionId")
    private Set<Choice> choices;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="test_question", catalog="finalDB", joinColumns = {
            @JoinColumn(name="questionId", nullable=true, updatable=true) }, inverseJoinColumns = {
            @JoinColumn(name="testId", nullable=true, updatable=true) })
    @JsonIgnoreProperties("questions")
    private Set<Test> tests;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionStatement() {
        return questionStatement;
    }

    public String getQuestionHeader() {
        return questionHeader;
    }

    public void setQuestionHeader(String questionHeader) {
        this.questionHeader = questionHeader;
    }

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode;
    }

    public void setQuestionStatement(String questionStatement) {
        this.questionStatement = questionStatement;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public String getQuestionExplanation() {
        return questionExplanation;
    }

    public void setQuestionExplanation(String questionExplanation) {
        this.questionExplanation = questionExplanation;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Set<Choice> getChoices() {
        return choices;
    }

    public void setChoices(Set<Choice> choices) {
        this.choices = choices;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }
}
