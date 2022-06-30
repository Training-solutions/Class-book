package com.eschool.openapi.v1.model;

import java.util.Objects;
import com.eschool.openapi.v1.model.StudentDto;
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
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Group info
 */
@ApiModel(description = "Group info")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-06-30T19:01:36.792883800+08:00[Asia/Shanghai]")
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

  @JsonProperty("isDeleted")
  private Boolean isDeleted;

  @JsonProperty("creationDate")
  private OffsetDateTime creationDate;

  @JsonProperty("modifyingDate")
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

  public GroupDto isDeleted(Boolean isDeleted) {
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
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupDto group = (GroupDto) o;
    return Objects.equals(this.id, group.id)Objects.equals(this.groupTitle, group.groupTitle)Objects.equals(this.students, group.students)Objects.equals(this.teachers, group.teachers)Objects.equals(this.subjects, group.subjects)Objects.equals(this.isDeleted, group.isDeleted)Objects.equals(this.creationDate, group.creationDate)Objects.equals(this.modifyingDate, group.modifyingDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idgroupTitlestudentsteacherssubjectsisDeletedcreationDatemodifyingDate);
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

