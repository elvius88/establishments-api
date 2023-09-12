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
public class VoucherResponse implements Serializable {

  private String name;
  private String description;

  @JsonProperty(value = "voucher_image_path")
  private String imagePath;
}
