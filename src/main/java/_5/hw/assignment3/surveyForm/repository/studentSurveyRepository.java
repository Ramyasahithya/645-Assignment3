package _5.hw.assignment3.surveyForm.repository;

import _5.hw.assignment3.surveyForm.model.studentSurveyData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentSurveyRepository extends JpaRepository<studentSurveyData,Long> {
}
