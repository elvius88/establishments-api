package py.com.jaha.api.establishments.domain.commands.establishments;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfferResponse implements Serializable {

  private String name;
  private String description;
  private String terms;

  @JsonProperty(value = "start_date")
  private String startDate;

  @JsonProperty(value = "end_date")
  private String endDate;

  @JsonProperty(value = "start_hour")
  private String startHour;

  @JsonProperty(value = "end_hour")
  private String endHour;

  @JsonProperty(value = "image_path")
  private String imagePath;
}
