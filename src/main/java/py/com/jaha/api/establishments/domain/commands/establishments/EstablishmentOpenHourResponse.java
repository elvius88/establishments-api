package py.com.jaha.api.establishments.domain.commands.establishments;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EstablishmentOpenHourResponse implements Serializable {


  @JsonProperty(value = "opening_time")
  private LocalTime openingTime;

  @JsonProperty(value = "closing_time")
  private LocalTime closingTime;
}
