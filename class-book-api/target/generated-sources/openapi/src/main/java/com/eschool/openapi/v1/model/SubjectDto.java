package com.eschool.openapi.v1.model;

import java.util.Objects;
import com.eschool.openapi.v1.model.GroupDto;
import com.eschool.openapi.v1.model.ScoreDto;
import com.eschool.openapi.v1.model.StudentDto;
import com.eschool.openapi.v1.model.TeacherDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Subject info
 */
@ApiModel(description = "Subject info")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-01T17:44:52.817734300+08:00[Asia/Shanghai]")
public class SubjectDto   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("subjectTitle")
  private String subjectTitle;

  @JsonProperty("groups")
  @Valid
  private List<GroupDto> groups = null;

  @JsonProperty("scores")
  @Valid
  private List<ScoreDto> scores = null;

  @JsonProperty("students")
  @Valid
  private List<StudentDto> students = null;

  @JsonProperty("teachers")
  @Valid
  private List<TeacherDto> teachers = null;

  @JsonProperty("isDeleted")
  private Boolean isDeleted;

  @JsonProperty("creationDate")
  private OffsetDateTime creationDate;

  @JsonProperty("modifyingDate")
  private OffsetDateTime modifyingDate;

  public SubjectDto id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Score Id
   * @return id
  */
  @ApiModelProperty(example = "186", value = "Score Id")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public SubjectDto subjectTitle(String subjectTitle) {
    this.subjectTitle = subjectTitle;
    return this;
  }

  /**
   * Get subjectTitle
   * @return subjectTitle
  */
  @ApiModelProperty(example = "David", value = "")


  public String getSubjectTitle() {
    return subjectTitle;
  }

  public void setSubjectTitle(String subjectTitle) {
    this.subjectTitle = subjectTitle;
  }

  public SubjectDto groups(List<GroupDto> groups) {
    this.groups = groups;
    return this;
  }

  /**
   * Get groups
   * @return groups
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<GroupDto> getGroups() {
    return groups;
  }

  public void setGroups(List<GroupDto> groups) {
    this.groups = groups;
  }

  public SubjectDto scores(List<ScoreDto> scores) {
    this.scores = scores;
    return this;
  }

  /**
   * Get scores
   * @return scores
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<ScoreDto> getScores() {
    return scores;
  }

  public void setScores(List<ScoreDto> scores) {
    this.scores = scores;
  }

  public SubjectDto students(List<StudentDto> students) {
    this.students = students;
    return this;
  }

  /**
   * Get students
   * @return students
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<StudentDto> getStudents() {
    return students;
  }

  public void setStudents(List<StudentDto> students) {
    this.students = students;
  }

  public SubjectDto teachers(List<TeacherDto> teachers) {
    this.teachers = teachers;
    return this;
  }

  /**
   * Get teachers
   * @return teachers
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<TeacherDto> getTeachers() {
    return teachers;
  }

  public void setTeachers(List<TeacherDto> teachers) {
    this.teachers = teachers;
  }

  public SubjectDto isDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
    return this;
  }

  /**
   * Get isDeleted
   * @return isDeleted
  */
  @ApiModelProperty(example = "false", value = "")


  public Boolean isIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public SubjectDto creationDate(OffsetDateTime creationDate) {
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

  public SubjectDto modifyingDate(OffsetDateTime modifyingDate) {
    this.modifyingDate = modifyingDate;
    return this;
  }

  /**
   * Get modifyingDate
   * @return modifyingDate
  */
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getModifyingDate() {
    return modifyingDate;
  }

  public void setModifyingDate(OffsetDateTime modifyingDate) {
    this.modifyingDate = modifyingDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubjectDto subject = (SubjectDto) o;
    return Objects.equals(this.id, subject.id)Objects.equals(this.subjectTitle, subject.subjectTitle)Objects.equals(this.groups, subject.groups)Objects.equals(this.scores, subject.scores)Objects.equals(this.students, subject.students)Objects.equals(this.teachers, subject.teachers)Objects.equals(this.isDeleted, subject.isDeleted)Objects.equals(this.creationDate, subject.creationDate)Objects.equals(this.modifyingDate, subject.modifyingDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idsubjectTitlegroupsscoresstudentsteachersisDeletedcreationDatemodifyingDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubjectDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    subjectTitle: ").append(toIndentedString(subjectTitle)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
    sb.append("    scores: ").append(toIndentedString(scores)).append("\n");
    sb.append("    students: ").append(toIndentedString(students)).append("\n");
    sb.append("    teachers: ").append(toIndentedString(teachers)).append("\n");
    sb.append("    isDeleted: ").append(toIndentedString(isDeleted)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    modifyingDate: ").append(toIndentedString(modifyingDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

