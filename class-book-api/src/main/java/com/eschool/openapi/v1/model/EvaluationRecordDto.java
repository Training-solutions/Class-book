package com.eschool.openapi.v1.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

/**
 * Evaluation record info
 */
@ApiModel(description = "Evaluation record info")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-15T11:29:21.198765500+02:00[Europe/Helsinki]")
public class EvaluationRecordDto   {
  @JsonProperty("studentFirstName")
  private String studentFirstName;

  @JsonProperty("studentLastName")
  private String studentLastName;

  @JsonProperty("groupName")
  private String groupName;

  @JsonProperty("subjectName")
  private String subjectName;

  @JsonProperty("teacherFirstName")
  private String teacherFirstName;

  @JsonProperty("teacherLastName")
  private String teacherLastName;

  @JsonProperty("marks")
  @Valid
  private List<MarkDto> marks = null;

  @JsonProperty("creationDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime creationDate;

  public EvaluationRecordDto studentFirstName(String studentFirstName) {
    this.studentFirstName = studentFirstName;
    return this;
  }

  /**
   * Get studentFirstName
   * @return studentFirstName
  */
  @ApiModelProperty(value = "")


  public String getStudentFirstName() {
    return studentFirstName;
  }

  public void setStudentFirstName(String studentFirstName) {
    this.studentFirstName = studentFirstName;
  }

  public EvaluationRecordDto studentLastName(String studentLastName) {
    this.studentLastName = studentLastName;
    return this;
  }

  /**
   * Get studentLastName
   * @return studentLastName
  */
  @ApiModelProperty(value = "")


  public String getStudentLastName() {
    return studentLastName;
  }

  public void setStudentLastName(String studentLastName) {
    this.studentLastName = studentLastName;
  }

  public EvaluationRecordDto groupName(String groupName) {
    this.groupName = groupName;
    return this;
  }

  /**
   * Get groupName
   * @return groupName
  */
  @ApiModelProperty(example = "1A", value = "")


  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public EvaluationRecordDto subjectName(String subjectName) {
    this.subjectName = subjectName;
    return this;
  }

  /**
   * Get subjectName
   * @return subjectName
  */
  @ApiModelProperty(example = "MATH", value = "")


  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  public EvaluationRecordDto teacherFirstName(String teacherFirstName) {
    this.teacherFirstName = teacherFirstName;
    return this;
  }

  /**
   * Get teacherFirstName
   * @return teacherFirstName
  */
  @ApiModelProperty(value = "")


  public String getTeacherFirstName() {
    return teacherFirstName;
  }

  public void setTeacherFirstName(String teacherFirstName) {
    this.teacherFirstName = teacherFirstName;
  }

  public EvaluationRecordDto teacherLastName(String teacherLastName) {
    this.teacherLastName = teacherLastName;
    return this;
  }

  /**
   * Get teacherLastName
   * @return teacherLastName
  */
  @ApiModelProperty(value = "")


  public String getTeacherLastName() {
    return teacherLastName;
  }

  public void setTeacherLastName(String teacherLastName) {
    this.teacherLastName = teacherLastName;
  }

  public EvaluationRecordDto marks(List<MarkDto> marks) {
    this.marks = marks;
    return this;
  }

  public EvaluationRecordDto addMarksItem(MarkDto marksItem) {
    if (this.marks == null) {
      this.marks = new ArrayList<>();
    }
    this.marks.add(marksItem);
    return this;
  }

  /**
   * Get marks
   * @return marks
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<MarkDto> getMarks() {
    return marks;
  }

  public void setMarks(List<MarkDto> marks) {
    this.marks = marks;
  }

  public EvaluationRecordDto creationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Get creationDate
   * @return creationDate
  */
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EvaluationRecordDto evaluationRecord = (EvaluationRecordDto) o;
    return Objects.equals(this.studentFirstName, evaluationRecord.studentFirstName) &&
        Objects.equals(this.studentLastName, evaluationRecord.studentLastName) &&
        Objects.equals(this.groupName, evaluationRecord.groupName) &&
        Objects.equals(this.subjectName, evaluationRecord.subjectName) &&
        Objects.equals(this.teacherFirstName, evaluationRecord.teacherFirstName) &&
        Objects.equals(this.teacherLastName, evaluationRecord.teacherLastName) &&
        Objects.equals(this.marks, evaluationRecord.marks) &&
        Objects.equals(this.creationDate, evaluationRecord.creationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(studentFirstName, studentLastName, groupName, subjectName, teacherFirstName, teacherLastName, marks, creationDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EvaluationRecordDto {\n");
    
    sb.append("    studentFirstName: ").append(toIndentedString(studentFirstName)).append("\n");
    sb.append("    studentLastName: ").append(toIndentedString(studentLastName)).append("\n");
    sb.append("    groupName: ").append(toIndentedString(groupName)).append("\n");
    sb.append("    subjectName: ").append(toIndentedString(subjectName)).append("\n");
    sb.append("    teacherFirstName: ").append(toIndentedString(teacherFirstName)).append("\n");
    sb.append("    teacherLastName: ").append(toIndentedString(teacherLastName)).append("\n");
    sb.append("    marks: ").append(toIndentedString(marks)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

