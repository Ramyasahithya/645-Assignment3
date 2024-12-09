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

/*
This class provide implementation for studentSurveyService interface by hadling business logic for creating, updating, retrieving and deleting student survey form details.
*/

package _5.hw.assignment3.surveyForm.service.impl;

import _5.hw.assignment3.surveyForm.model.studentSurveyData;
import _5.hw.assignment3.surveyForm.repository.studentSurveyRepository;
import _5.hw.assignment3.surveyForm.service.studentSurveyService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class studentSurveyServiceImplementation implements studentSurveyService {
    @Autowired
    private studentSurveyRepository studentRepository;


    @Transactional
    public studentSurveyData saveStudentSurveyData(studentSurveyData student) {
        return studentRepository.save(student);
    }

    public studentSurveyData getStudentSurveyDataById(long id) {
        return studentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(new studentSurveyData())).getBody();
    }
    public List<studentSurveyData> getAllStudentsSurveyData() {
        return studentRepository.findAll();
    }
    @Transactional
    public ResponseEntity<?> updateStudentSurveyDataById(studentSurveyData student, long id){
        Optional<studentSurveyData> optionalSurvey = studentRepository.findById(id);
        if (optionalSurvey.isEmpty()) {
            return new ResponseEntity<>("Survey with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
        studentSurveyData existingSurvey = optionalSurvey.get();

        Optional.ofNullable(student.getFirstName()).ifPresent(existingSurvey::setFirstName);
        Optional.ofNullable(student.getLastName()).ifPresent(existingSurvey::setLastName);
        Optional.ofNullable(student.getCity()).ifPresent(existingSurvey::setCity);
        Optional.ofNullable(student.getState()).ifPresent(existingSurvey::setState);
        Optional.ofNullable(student.getEmail()).ifPresent(existingSurvey::setEmail);
        Optional.ofNullable(student.getStreetAddress()).ifPresent(existingSurvey::setStreetAddress);
        Optional.ofNullable(student.getTelephone()).ifPresent(existingSurvey::setTelephone);
        Optional.ofNullable(student.getZip()).ifPresent(existingSurvey::setZip);
        Optional.ofNullable(student.getCampusFeatures()).ifPresent(existingSurvey::setCampusFeatures);
        Optional.ofNullable(student.getCampusInterest()).ifPresent(existingSurvey::setCampusInterest);
        Optional.ofNullable(student.getUniversityRecommendation()).ifPresent(existingSurvey::setUniversityRecommendation);
        Optional.ofNullable(student.getSurveyDate()).ifPresent(existingSurvey::setSurveyDate);
        Optional.ofNullable(student.getAdditionalComments()).ifPresent(existingSurvey::setAdditionalComments);

        studentRepository.save(existingSurvey);

        return new ResponseEntity<>(existingSurvey,HttpStatus.OK);
    }

    public boolean deleteStudentSurveyData(long id) {
        Optional<studentSurveyData> survey = studentRepository.findById(id);
        if (survey.isPresent()) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }

}
