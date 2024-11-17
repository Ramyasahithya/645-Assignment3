package _5.hw.assignment3.surveyForm.service;

import _5.hw.assignment3.surveyForm.model.studentSurveyData;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface studentSurveyService {
    studentSurveyData saveStudentSurveyData(studentSurveyData student);
    List<studentSurveyData> getAllStudentsSurveyData();
    studentSurveyData getStudentSurveyDataById(long id);
    ResponseEntity<?> updateStudentSurveyDataById(studentSurveyData student, long id);
    boolean deleteStudentSurveyData(long id);
}
