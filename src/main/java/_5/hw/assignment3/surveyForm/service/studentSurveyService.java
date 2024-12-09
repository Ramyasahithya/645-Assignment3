/*
Athiksha Venkannagari - G01461169
Arsitha Sathu - G01445215
Ramyasahithya Magani - G01425752
Prasad Reddy Mandha - G01454689
SaichinmayeeYanamadala - G01459318
LikhithNattuva - G0144733
Priya Dharshini Allapuram - G01457911
Sreshta Kosaraju - G01460468
*/

/* studentSurveyService interface define the service for managing student survey data, including CRUD operations such as Create, Update, Get and Delete.*/

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
