/*
This interface helps the repository for managing student survey form data by extending JpaRepository to provide CRUD operations for the surveyData table.
*/

package _5.hw.assignment3.surveyForm.repository;

import _5.hw.assignment3.surveyForm.model.studentSurveyData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentSurveyRepository extends JpaRepository<studentSurveyData,Long> {
}
