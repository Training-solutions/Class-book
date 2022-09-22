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
 * Group info
 */
@ApiModel(description = "Group info")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-21T19:00:20.213481100+03:00[Europe/Helsinki]")
public class GroupDto   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("groupTitle")
  private String groupTitle;

  @JsonProperty("students")
  @Valid
  private List<StudentDto> students = null;

  @JsonProperty("teachers")
  @Valid
  private List<TeacherDto> teachers = null;

  @JsonProperty("subjects")
  @Valid
  private List<SubjectDto> subjects = null;

  @JsonProperty("deleted")
  private boolean deleted;

  @JsonProperty("creationDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime creationDate;

  @JsonProperty("modifyingDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime modifyingDate;

  public GroupDto id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Group Id
   * @return id
  */
  @ApiModelProperty(example = "186", value = "Group Id")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public GroupDto groupTitle(String groupTitle) {
    this.groupTitle = groupTitle;
    return this;
  }

  /**
   * Group title
   * @return groupTitle
  */
  @ApiModelProperty(example = "David", value = "Group title")


  public String getGroupTitle() {
    return groupTitle;
  }

  public void setGroupTitle(String groupTitle) {
    this.groupTitle = groupTitle;
  }

  public GroupDto students(List<StudentDto> students) {
    this.students = students;
    return this;
  }

  public GroupDto addStudentsItem(StudentDto studentsItem) {
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

  public GroupDto teachers(List<TeacherDto> teachers) {
    this.teachers = teachers;
    return this;
  }

  public GroupDto addTeachersItem(TeacherDto teachersItem) {
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

  public GroupDto subjects(List<SubjectDto> subjects) {
    this.subjects = subjects;
    return this;
  }

  public GroupDto addSubjectsItem(SubjectDto subjectsItem) {
    if (this.subjects == null) {
      this.subjects = new ArrayList<>();
    }
    this.subjects.add(subjectsItem);
    return this;
  }

  /**
   * Get subjects
   * @return subjects
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<SubjectDto> getSubjects() {
    return subjects;
  }

  public void setSubjects(List<SubjectDto> subjects) {
    this.subjects = subjects;
  }

  public GroupDto isDeleted(boolean deleted) {
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

  public void setDeleted(Boolean isDeleted) {
    this.deleted = deleted;
  }

  public GroupDto creationDate(OffsetDateTime creationDate) {
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

  public GroupDto modifyingDate(OffsetDateTime modifyingDate) {
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
    GroupDto group = (GroupDto) o;
    return Objects.equals(this.id, group.id) &&
        Objects.equals(this.groupTitle, group.groupTitle) &&
        Objects.equals(this.students, group.students) &&
        Objects.equals(this.teachers, group.teachers) &&
        Objects.equals(this.subjects, group.subjects) &&
        Objects.equals(this.deleted, group.deleted) &&
        Objects.equals(this.creationDate, group.creationDate) &&
        Objects.equals(this.modifyingDate, group.modifyingDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, groupTitle, students, teachers, subjects, deleted, creationDate, modifyingDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    groupTitle: ").append(toIndentedString(groupTitle)).append("\n");
    sb.append("    students: ").append(toIndentedString(students)).append("\n");
    sb.append("    teachers: ").append(toIndentedString(teachers)).append("\n");
    sb.append("    subjects: ").append(toIndentedString(subjects)).append("\n");
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

