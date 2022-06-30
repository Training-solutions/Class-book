package com.eschool.openapi.v1.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Score info
 */
@ApiModel(description = "Score info")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-06-30T19:01:36.792883800+08:00[Asia/Shanghai]")
public class ScoreDto   {
  @JsonProperty("id")
  private Long id;

  /**
   * Gets or Sets score
   */
  public enum ScoreEnum {
    ONE_1_("ONE(1)"),
    
    TWO_2_("TWO(2)"),
    
    THREE_3_("THREE(3)"),
    
    FOUR_4_("FOUR(4)"),
    
    FIVE_5_("FIVE(5)"),
    
    SIX_6_("SIX(6)"),
    
    SEVEN_7_("SEVEN(7)"),
    
    EIGHT_8_("EIGHT(8)"),
    
    NINE_9_("NINE(9)"),
    
    TEN_10_("TEN(10)"),
    
    ELEVEN_11_("ELEVEN(11)"),
    
    TWELVE_12_("TWELVE(12)");

    private String value;

    ScoreEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ScoreEnum fromValue(String value) {
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

  @JsonProperty("isDeleted")
  private Boolean isDeleted;

  @JsonProperty("creationDate")
  private OffsetDateTime creationDate;

  @JsonProperty("modifyingDate")
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

  public ScoreDto isDeleted(Boolean isDeleted) {
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
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScoreDto score = (ScoreDto) o;
    return Objects.equals(this.id, score.id)Objects.equals(this.score, score.score)Objects.equals(this.isDeleted, score.isDeleted)Objects.equals(this.creationDate, score.creationDate)Objects.equals(this.modifyingDate, score.modifyingDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idscoreisDeletedcreationDatemodifyingDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScoreDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
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

