package py.com.jaha.api.establishments.domain.commands.establishments;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDate;
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
public class PromotionResponse implements Serializable {

  @JsonProperty(value = "name")
  private String name;

  @JsonProperty(value = "description")
  private String description;

  @JsonProperty(value = "terms")
  private String terms;

  @JsonProperty(value = "start_date")
  private LocalDate startDate;

  @JsonProperty(value = "end_date")
  private LocalDate endDate;

  @JsonProperty(value = "image_path")
  private String imagePath;
}
