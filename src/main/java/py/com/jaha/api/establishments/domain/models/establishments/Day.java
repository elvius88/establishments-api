package py.com.jaha.api.establishments.domain.models.establishments;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Day implements Serializable {

  private String id;
  private String name;
  private Integer orderDay;
}
