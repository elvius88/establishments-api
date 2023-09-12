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
public class VoucherEstablishmentBranch implements Serializable {

  private String id;
  private Voucher voucher;
}
