package py.com.jaha.api.establishments.domain.models.establishments;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PromotionImage implements Serializable {

  private String id;
  private String imagePath;
  private Boolean active;
}
