package py.com.jaha.api.establishments.domain.commands.establishments;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import py.com.jaha.api.establishments.config.DtoMeta;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DtoMeta
public class GetEstablishmentResponse {

  @JsonProperty(value = "id")
  private String id;

  @JsonProperty(value = "branch_id")
  private String branchId;

  @JsonProperty(value = "name")
  private String name;

  @JsonProperty(value = "category")
  private String category;

  @JsonProperty(value = "score")
  private String score;

  @JsonProperty(value = "distance")
  private String distance;

  @JsonProperty(value = "latitude")
  private String latitude;

  @JsonProperty(value = "longitude")
  private String longitude;

  @JsonProperty(value = "address")
  private String address;

  @JsonProperty(value = "city")
  private String city;

  @JsonProperty(value = "review_amount")
  private String reviewAmount;

  @JsonProperty(value = "profile_image_path")
  private String profileImagePath;


}
