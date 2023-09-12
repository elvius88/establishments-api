package py.com.jaha.api.establishments.domain.commands.establishments;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import py.com.jaha.api.establishments.config.DtoMeta;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DtoMeta
public class GetEstablishmentNearbyResponse {

  private String id;

  @JsonProperty(value = "branch_id")
  private String branchId;
  private String name;
  private String category;
  private String score;
  private String distance;
  private String latitude;
  private String longitude;
  private String address;
  private String city;

  @JsonProperty(value = "review_amount")
  private String reviewAmount;

  @JsonProperty(value = "profile_image_path")
  private String profileImagePath;

}
