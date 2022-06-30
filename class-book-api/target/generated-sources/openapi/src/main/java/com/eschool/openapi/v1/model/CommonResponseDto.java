package com.eschool.openapi.v1.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CommonResponse
 */
@ApiModel(description = "CommonResponse")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-06-30T19:01:36.792883800+08:00[Asia/Shanghai]")
public class CommonResponseDto   {
  @JsonProperty("responseId")
  private Long responseId;

  @JsonProperty("status")
  private String status;

  public CommonResponseDto responseId(Long responseId) {
    this.responseId = responseId;
    return this;
  }

  /**
   * Get responseId
   * @return responseId
  */
  @ApiModelProperty(example = "186", value = "")


  public Long getResponseId() {
    return responseId;
  }

  public void setResponseId(Long responseId) {
    this.responseId = responseId;
  }

  public CommonResponseDto status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @ApiModelProperty(example = "Some status", value = "")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommonResponseDto commonResponse = (CommonResponseDto) o;
    return Objects.equals(this.responseId, commonResponse.responseId)Objects.equals(this.status, commonResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseIdstatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommonResponseDto {\n");
    
    sb.append("    responseId: ").append(toIndentedString(responseId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

