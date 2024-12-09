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
This interface helps the repository for managing student survey form data by extending JpaRepository to provide CRUD operations for the surveyData table.
*/

package _5.hw.assignment3.surveyForm.repository;

import _5.hw.assignment3.surveyForm.model.studentSurveyData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentSurveyRepository extends JpaRepository<studentSurveyData,Long> {
}
