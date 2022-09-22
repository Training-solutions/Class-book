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
 * Teacher info
 */
@ApiModel(description = "Teacher info")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-21T19:00:20.213481100+03:00[Europe/Helsinki]")
public class TeacherDto   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("credential")
  private CredentialDto credential;

  @JsonProperty("groups")
  @Valid
  private List<GroupDto> groups = null;

  @JsonProperty("students")
  @Valid
  private List<StudentDto> students = null;

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

  public TeacherDto id(Long id) {
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

  public TeacherDto firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  */
  @ApiModelProperty(example = "David", value = "")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public TeacherDto lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  */
  @ApiModelProperty(example = "Mondel", value = "")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public TeacherDto credential(CredentialDto credential) {
    this.credential = credential;
    return this;
  }

  /**
   * Get credential
   * @return credential
  */
  @ApiModelProperty(value = "")

  @Valid

  public CredentialDto getCredential() {
    return credential;
  }

  public void setCredential(CredentialDto credential) {
    this.credential = credential;
  }

  public TeacherDto groups(List<GroupDto> groups) {
    this.groups = groups;
    return this;
  }

  public TeacherDto addGroupsItem(GroupDto groupsItem) {
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

  public TeacherDto students(List<StudentDto> students) {
    this.students = students;
    return this;
  }

  public TeacherDto addStudentsItem(StudentDto studentsItem) {
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

  public TeacherDto subjects(List<SubjectDto> subjects) {
    this.subjects = subjects;
    return this;
  }

  public TeacherDto addSubjectsItem(SubjectDto subjectsItem) {
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

  public TeacherDto isDeleted(boolean deleted) {
    this.deleted = deleted;
    return this;
  }

  /**
   * Get isDeleted
   * @return isDeleted
  */
  @ApiModelProperty(example = "false", value = "")


  public boolean isIsDeleted() {
    return deleted;
  }

  public void setDeleted(boolean isDeleted) {
    this.deleted = deleted;
  }

  public TeacherDto creationDate(OffsetDateTime creationDate) {
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

  public TeacherDto modifyingDate(OffsetDateTime modifyingDate) {
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
    TeacherDto teacher = (TeacherDto) o;
    return Objects.equals(this.id, teacher.id) &&
        Objects.equals(this.firstName, teacher.firstName) &&
        Objects.equals(this.lastName, teacher.lastName) &&
        Objects.equals(this.credential, teacher.credential) &&
        Objects.equals(this.groups, teacher.groups) &&
        Objects.equals(this.students, teacher.students) &&
        Objects.equals(this.subjects, teacher.subjects) &&
        Objects.equals(this.deleted, teacher.deleted) &&
        Objects.equals(this.creationDate, teacher.creationDate) &&
        Objects.equals(this.modifyingDate, teacher.modifyingDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, credential, groups, students, subjects, deleted, creationDate, modifyingDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TeacherDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    credential: ").append(toIndentedString(credential)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
    sb.append("    students: ").append(toIndentedString(students)).append("\n");
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

