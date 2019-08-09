package productoffering.kafka_testing;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
/*import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;*/
/**
 * KeyExchangeMessage
 */
@javax.annotation.Generated(value = "com.amdocs.msbase.swagger.codegen.AmdocsAsyncBusinessMessageCodegen", date = "2019-07-17T14:10:26.851-05:00")

public class KeyExchangeMessage  {
  @JsonProperty("field")
  private String field = null;

  public KeyExchangeMessage field(String field) {
    this.field = field;
    return this;
  }

   /**
   * Get field
   * @return field
  **/
  //@ApiModelProperty(value = "")
  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }


  //@Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeyExchangeMessage keyExchangeMessage = (KeyExchangeMessage) o;
    return Objects.equals(this.field, keyExchangeMessage.field) &&
        super.equals(o);
  }

  //@Override
  public int hashCode() {
    return Objects.hash(field, super.hashCode());
  }

  //@Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeyExchangeMessage {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
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

