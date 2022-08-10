package com.eschool.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PageView
 */
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-07-04T11:27:54.497233400+03:00[Asia/Istanbul]")
public class PageView<T>   {
  @JsonProperty("total")
  private Integer total;

  @JsonProperty("data")
  @Valid
  private List<T> data = null;

  public PageView total(Integer total) {
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

  public PageView data(List<T> data) {
    this.data = data;
    this.total = data.size();
    return this;
  }

  public PageView addDataItem(T dataItem) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageView pageView = (PageView) o;
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
    sb.append("class PageView {\n");
    
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

