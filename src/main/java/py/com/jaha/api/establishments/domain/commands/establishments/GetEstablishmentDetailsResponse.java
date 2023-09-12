package py.com.jaha.api.establishments.domain.commands.establishments;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@DtoMeta
public class GetEstablishmentDetailsResponse extends GetEstablishmentResponse {

  @JsonProperty(value = "profile_image_path")
  private String profileImagePath;

  @JsonProperty(value = "front_page_image_path")
  private String frontPageImagePath;

  @JsonProperty(value = "short_description")
  private String shortDescription;

  @JsonProperty(value = "offers")
  private List<OfferResponse> offers;

  @JsonProperty(value = "promotions")
  private List<PromotionResponse> promotions;

  @JsonProperty(value = "vouchers")
  private List<VoucherResponse> vouchers;

  @JsonProperty(value = "opening_hours")
  private EstablishmentOpenHourResponse openingHours;
}
