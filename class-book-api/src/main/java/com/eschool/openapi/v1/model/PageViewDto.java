package com.eschool.openapi.v1.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PageViewDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-21T19:00:20.213481100+03:00[Europe/Helsinki]")
public class PageViewDto<T>   {
  @JsonProperty("total")
  private Integer total;

  @JsonProperty("data")
  @Valid
  private List<T> data = null;

  public PageViewDto total(Integer total) {
    this.total = total;
    return this;
  }

  /**
   * Get total
   * @return total
  */
  @ApiModelProperty(example = "1000", value = "")


  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public PageViewDto (List<T> data) {
    this.data = data;
    this.total = data.size();
  }

  public PageViewDto addDataItem(T dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @ApiModelProperty(value = "")


  public List<T> getData() {
    return data;
  }

  public void setData(List<T> data) {
    this.data = data;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageViewDto pageView = (PageViewDto) o;
    return Objects.equals(this.total, pageView.total) &&
        Objects.equals(this.data, pageView.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageViewDto {\n");
    
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

