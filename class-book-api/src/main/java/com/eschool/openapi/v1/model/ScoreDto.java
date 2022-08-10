package com.eschool.openapi.v1.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Score info
 */
@ApiModel(description = "Score info")
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-07-04T11:27:54.497233400+03:00[Asia/Istanbul]")
public class ScoreDto   {
  @JsonProperty("id")
  private Long id;

  /**
   * Gets or Sets score
   */
  public enum ScoreEnum {
    ONE(1),
    
    TWO(2),
    
    THREE(3),
    
    FOUR(4),
    
    FIVE(5),
    
    SIX(6),
    
    SEVEN(7),
    
    EIGHT(8),
    
    NINE(9),
    
    TEN(10),
    
    ELEVEN(11),
    
    TWELVE(12);

    private Integer value;

    ScoreEnum(Integer value) {
      this.value = value;
    }

    @JsonValue
    public Integer getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ScoreEnum fromValue(Integer value) {
      for (ScoreEnum b : ScoreEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("score")
  private ScoreEnum score;

  @JsonProperty("deleted")
  private Boolean deleted;

  @JsonProperty("creationDate")
  @DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime creationDate;

  @JsonProperty("modifyingDate")
  @DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime modifyingDate;

  public ScoreDto id(Long id) {
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

  public ScoreDto score(ScoreEnum score) {
    this.score = score;
    return this;
  }

  /**
   * Get score
   * @return score
  */
  @ApiModelProperty(value = "")


  public ScoreEnum getScore() {
    return score;
  }

  public void setScore(ScoreEnum score) {
    this.score = score;
  }

  public ScoreDto isDeleted(Boolean deleted) {
    this.deleted = deleted;
    return this;
  }

  /**
   * Get deleted
   * @return deleted
  */
  @ApiModelProperty(example = "false", value = "")


  public Boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  public ScoreDto creationDate(OffsetDateTime creationDate) {
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

  public ScoreDto modifyingDate(OffsetDateTime modifyingDate) {
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
    ScoreDto score = (ScoreDto) o;
    return Objects.equals(this.id, score.id) &&
        Objects.equals(this.score, score.score) &&
        Objects.equals(this.deleted, score.deleted) &&
        Objects.equals(this.creationDate, score.creationDate) &&
        Objects.equals(this.modifyingDate, score.modifyingDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, score, deleted, creationDate, modifyingDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScoreDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
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

