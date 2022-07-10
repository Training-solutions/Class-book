package com.eschool.openapi.v1.model;

import java.util.Objects;
import com.eschool.openapi.v1.model.CredentialDto;
import com.eschool.openapi.v1.model.GroupDto;
import com.eschool.openapi.v1.model.SubjectDto;
import com.eschool.openapi.v1.model.TeacherDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Student info
 */
@ApiModel(description = "Student info")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-04T11:27:54.497233400+03:00[Asia/Istanbul]")
public class StudentDto   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("credential")
  private CredentialDto credential;

  @JsonProperty("group")
  private GroupDto group;

  @JsonProperty("teachers")
  @Valid
  private List<TeacherDto> teachers = null;

  @JsonProperty("subjects")
  @Valid
  private List<SubjectDto> subjects = null;

  @JsonProperty("isDeleted")
  private Boolean isDeleted;

  @JsonProperty("creationDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime creationDate;

  @JsonProperty("modifyingDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime modifyingDate;

  public StudentDto id(Long id) {
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

  public StudentDto firstName(String firstName) {
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

  public StudentDto lastName(String lastName) {
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

  public StudentDto credential(CredentialDto credential) {
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

  public StudentDto group(GroupDto group) {
    this.group = group;
    return this;
  }

  /**
   * Get group
   * @return group
  */
  @ApiModelProperty(value = "")

  @Valid

  public GroupDto getGroup() {
    return group;
  }

  public void setGroup(GroupDto group) {
    this.group = group;
  }

  public StudentDto teachers(List<TeacherDto> teachers) {
    this.teachers = teachers;
    return this;
  }

  public StudentDto addTeachersItem(TeacherDto teachersItem) {
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

  public StudentDto subjects(List<SubjectDto> subjects) {
    this.subjects = subjects;
    return this;
  }

  public StudentDto addSubjectsItem(SubjectDto subjectsItem) {
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

  public StudentDto isDeleted(Boolean isDeleted) {
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

  public StudentDto creationDate(OffsetDateTime creationDate) {
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

  public StudentDto modifyingDate(OffsetDateTime modifyingDate) {
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
    StudentDto student = (StudentDto) o;
    return Objects.equals(this.id, student.id) &&
        Objects.equals(this.firstName, student.firstName) &&
        Objects.equals(this.lastName, student.lastName) &&
        Objects.equals(this.credential, student.credential) &&
        Objects.equals(this.group, student.group) &&
        Objects.equals(this.teachers, student.teachers) &&
        Objects.equals(this.subjects, student.subjects) &&
        Objects.equals(this.isDeleted, student.isDeleted) &&
        Objects.equals(this.creationDate, student.creationDate) &&
        Objects.equals(this.modifyingDate, student.modifyingDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, credential, group, teachers, subjects, isDeleted, creationDate, modifyingDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudentDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    credential: ").append(toIndentedString(credential)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
    sb.append("    teachers: ").append(toIndentedString(teachers)).append("\n");
    sb.append("    subjects: ").append(toIndentedString(subjects)).append("\n");
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

