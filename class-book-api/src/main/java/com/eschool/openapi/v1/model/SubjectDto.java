package com.eschool.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Subject info
 */
@ApiModel(description = "Subject info")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-21T19:00:20.213481100+03:00[Europe/Helsinki]")
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
  private List<MarkDto> marks = null;

  @JsonProperty("students")
  @Valid
  private List<StudentDto> students = null;

  @JsonProperty("teachers")
  @Valid
  private List<TeacherDto> teachers = null;

  @JsonProperty("deleted")
  private boolean deleted;

  @JsonProperty("creationDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime creationDate;

  @JsonProperty("modifyingDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
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

  public SubjectDto addGroupsItem(GroupDto groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<>();
    }
    this.groups.add(groupsItem);
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

  public SubjectDto scores(List<MarkDto> marks) {
    this.marks = marks;
    return this;
  }

  public SubjectDto addScoresItem(MarkDto mark) {
    if (this.marks == null) {
      this.marks = new ArrayList<>();
    }
    this.marks.add(mark);
    return this;
  }

  /**
   * Get scores
   * @return scores
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<MarkDto> getScores() {
    return marks;
  }

  public void setScores(List<MarkDto> scores) {
    this.marks = marks;
  }

  public SubjectDto students(List<StudentDto> students) {
    this.students = students;
    return this;
  }

  public SubjectDto addStudentsItem(StudentDto studentsItem) {
    if (this.students == null) {
      this.students = new ArrayList<>();
    }
    this.students.add(studentsItem);
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

  public SubjectDto addTeachersItem(TeacherDto teachersItem) {
    if (this.teachers == null) {
      this.teachers = new ArrayList<>();
    }
    this.teachers.add(teachersItem);
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

  public SubjectDto isDeleted(boolean deleted) {
    this.deleted = deleted;
    return this;
  }

  /**
   * Get isDeleted
   * @return isDeleted
  */
  @ApiModelProperty(example = "false", value = "")


  public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubjectDto subject = (SubjectDto) o;
    return Objects.equals(this.id, subject.id) &&
        Objects.equals(this.subjectTitle, subject.subjectTitle) &&
        Objects.equals(this.groups, subject.groups) &&
        Objects.equals(this.marks, subject.marks) &&
        Objects.equals(this.students, subject.students) &&
        Objects.equals(this.teachers, subject.teachers) &&
        Objects.equals(this.deleted, subject.deleted) &&
        Objects.equals(this.creationDate, subject.creationDate) &&
        Objects.equals(this.modifyingDate, subject.modifyingDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, subjectTitle, groups, marks, students, teachers, deleted, creationDate, modifyingDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubjectDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    subjectTitle: ").append(toIndentedString(subjectTitle)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
    sb.append("    scores: ").append(toIndentedString(marks)).append("\n");
    sb.append("    students: ").append(toIndentedString(students)).append("\n");
    sb.append("    teachers: ").append(toIndentedString(teachers)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    modifyingDate: ").append(toIndentedString(modifyingDate)).append("\n");
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

