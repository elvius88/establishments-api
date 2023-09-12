package py.com.jaha.api.establishments.domain.models.establishments;

import java.io.Serializable;
import java.util.List;
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
public class EstablishmentBranch implements Serializable {

  private String id;
  private String address;
  private String latitude;
  private String longitude;
  private Integer zip;
  private City city;
  private Establishment establishment;
  private List<EstablishmentScore> establishmentScores;
  private List<Promotion> Promotions;
  private List<VoucherEstablishmentBranch> voucherEstablishmentBranches;
  private List<EstablishmentOpenHour> openHours;
}
