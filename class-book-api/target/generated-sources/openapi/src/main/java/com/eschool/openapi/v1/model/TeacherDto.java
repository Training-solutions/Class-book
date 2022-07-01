package com.eschool.openapi.v1.model;

import java.util.Objects;
import com.eschool.openapi.v1.model.CredentialDto;
import com.eschool.openapi.v1.model.GroupDto;
import com.eschool.openapi.v1.model.StudentDto;
import com.eschool.openapi.v1.model.SubjectDto;
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
 * Teacher info
 */
@ApiModel(description = "Teacher info")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-01T17:44:52.817734300+08:00[Asia/Shanghai]")
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

  @JsonProperty("isDeleted")
  private Boolean isDeleted;

  @JsonProperty("creationDate")
  private OffsetDateTime creationDate;

  @JsonProperty("modifyingDate")
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

  public TeacherDto isDeleted(Boolean isDeleted) {
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
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TeacherDto teacher = (TeacherDto) o;
    return Objects.equals(this.id, teacher.id)Objects.equals(this.firstName, teacher.firstName)Objects.equals(this.lastName, teacher.lastName)Objects.equals(this.credential, teacher.credential)Objects.equals(this.groups, teacher.groups)Objects.equals(this.students, teacher.students)Objects.equals(this.subjects, teacher.subjects)Objects.equals(this.isDeleted, teacher.isDeleted)Objects.equals(this.creationDate, teacher.creationDate)Objects.equals(this.modifyingDate, teacher.modifyingDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idfirstNamelastNamecredentialgroupsstudentssubjectsisDeletedcreationDatemodifyingDate);
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

