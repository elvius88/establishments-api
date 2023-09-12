package py.com.jaha.api.establishments.domain.models.establishments;

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
public class Offer implements Serializable {

  private String name;
  private String description;
  private String terms;
  private String startDate;
  private String endDate;
  private String startHour;
  private String endHour;
  private String imagePath;
}
