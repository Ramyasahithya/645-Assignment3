/*
  Ramyasahithya Magani - G01425752
  Arsitha Sathu - G01445215
  Athiksha Venkannagari - G01461169
  Sreshta Kosaraju - G01460468
*/

/*
This class represents the data model for student survey form responses, By mapping surveyData table in the database.
*/

package _5.hw.assignment3.surveyForm.model;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="surveyData")
public class studentSurveyData
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="first_name",nullable = false)
    private String firstName;
    @Column(name="last_name",nullable = false)
    private String lastName;
    @Column(name="street_address",nullable = false)
    private String streetAddress;
    @Column(name="city",nullable = false)
    private String city;
    @Column(name="state",nullable = false)
    private String state;
    @Column(name="zip",nullable = false)
    private String zip;
    @Column(name="telephone",nullable = false)
    private String telephone;
    @Column(name="email",nullable = false)
    private String email;
    @Column(name="surveyDate",nullable = false)
    private Date surveyDate;
    @Enumerated(EnumType.STRING)
    @Column(name="campus_interest",nullable = false)
    private CampusInterest campusInterest;
    @Column(name="campus_features",nullable = false)
    private String campusFeatures;
    @Enumerated(EnumType.STRING)
    @Column(name="university_recommendation",nullable = false)
    private UniversityRecommendation universityRecommendation;
    @Column(name = "additional_comments", columnDefinition = "TEXT")
    private String additionalComments;
    @Column(name = "record_creation", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp recordCreation;
    @Column(name = "record_updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp recordUpdatedAt;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Date getSurveyDate() {
        return surveyDate;
    }

    public void setSurveyDate(Date surveyDate) {
        this.surveyDate = surveyDate;
    }

    public CampusInterest getCampusInterest() {
        return campusInterest;
    }

    public void setCampusInterest(CampusInterest campusInterest) {
        this.campusInterest = campusInterest;
    }

    public String getCampusFeatures() {
        return campusFeatures;
    }

    public void setCampusFeatures(String campusFeatures) {
        this.campusFeatures = campusFeatures;
    }

    public UniversityRecommendation getUniversityRecommendation() {
        return universityRecommendation;
    }

    public void setUniversityRecommendation(UniversityRecommendation universityRecommendation) {
        this.universityRecommendation = universityRecommendation;
    }
    @PrePersist
    protected void onCreate() {
        this.recordCreation = new Timestamp(System.currentTimeMillis());
        this.recordUpdatedAt = this.recordCreation;
    }
    @PreUpdate
    protected void onUpdate() {
        this.recordUpdatedAt = new Timestamp(System.currentTimeMillis());
    }
    public Timestamp getRecordCreation() {
        return recordCreation;
    }
    public void setRecordCreation(Timestamp recordCreation) {
        this.recordCreation = recordCreation;
    }
    public Timestamp getRecordUpdatedAt() {
        return recordUpdatedAt;
    }
    public void setRecordUpdatedAt(Timestamp recordUpdatedAt) {
        this.recordUpdatedAt = recordUpdatedAt;
    }
    public enum CampusInterest{
        Friends, Television, Internet, Other
    }
    public enum UniversityRecommendation{
        VeryLikely, Likely, Unlikely
    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }
    @Override
    public String toString() {
        return "surveyData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", campusFeatures='" + campusFeatures + '\'' +
                ", campusInterest='" + campusInterest + '\'' +
                ", universityRecommendation='" + universityRecommendation + '\'' +
                ", surveyDate='" + surveyDate + '\'' +
                ", additionalComments='" + additionalComments + '\'' +
                '}';
    }
}
