/*
  Ramyasahithya Magani - G01425752
  Arsitha Sathu - G01445215
  Athiksha Venkannagari - G01461169
  Sreshta Kosaraju - G01460468
*/

/*
 This controller file manage HTTP requests for survey form data.
 It provides endpoints to create, update, retrieve and delete survey form data.
 */

package _5.hw.assignment3.surveyForm.controller;

import _5.hw.assignment3.surveyForm.model.studentSurveyData;
import _5.hw.assignment3.surveyForm.service.studentSurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/surveyData")
public class studentSurveyController {
    private final studentSurveyService studentService;

    public studentSurveyController(studentSurveyService studentService) {
        super();
        this.studentService = studentService;
    }

    private static final Logger logger = LoggerFactory.getLogger(studentSurveyController.class);

    @PostMapping
    public ResponseEntity<studentSurveyData> saveStudentSurveyData(@RequestBody studentSurveyData studentSurvey) {
        logger.info("Received survey data: {}", studentSurvey.toString());
        return new ResponseEntity<studentSurveyData>(studentService.saveStudentSurveyData(studentSurvey), HttpStatus.CREATED);
    }

    @GetMapping
    public List<studentSurveyData> getAllStudentsSurveyData() {
        logger.info("Received a request for getting the student survey data from data");
        return studentService.getAllStudentsSurveyData();
    }

    @GetMapping("{id}")
    public ResponseEntity<studentSurveyData> getStudentSurveyDataById(@PathVariable("id") long studentId) {
        return new ResponseEntity<studentSurveyData>(studentService.getStudentSurveyDataById(studentId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateStudentSurveyDataById(@RequestBody studentSurveyData studentSurvey, @PathVariable("id") long studentId) {
        logger.info("Received survey data: {}", studentSurvey.toString());
        return studentService.updateStudentSurveyDataById(studentSurvey, studentId);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudentSurveyData(@PathVariable("id") long studentId) {
        logger.info("Received request to delete survey data for id: {}", studentId);
        try {
            boolean isDeleted = studentService.deleteStudentSurveyData(studentId);
            if (isDeleted) {
                logger.info("Deleted student survey data from database for the id: {}", studentId);
                return new ResponseEntity<>("Student survey form deleted successfully", HttpStatus.OK);
            } else {
                logger.warn("Attempted to delete non-existent student survey data for id: {}", studentId);
                return new ResponseEntity<>("No data found for the given ID. It might have already been deleted.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("An error occurred while deleting the student survey data for id: {}", studentId, e);
            return new ResponseEntity<>("An error occurred while processing the request.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
