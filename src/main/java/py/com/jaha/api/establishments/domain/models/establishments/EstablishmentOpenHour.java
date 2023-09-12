package py.com.jaha.api.establishments.domain.models.establishments;

import java.io.Serializable;
import java.time.LocalTime;
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
public class EstablishmentOpenHour implements Serializable {

  private LocalTime openingTime;
  private LocalTime closingTime;
  private Day day;
}
