package py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "establishment_branches")
public class EstablishmentBranches implements Serializable {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(nullable = false, updatable = false)
  private String id;

  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "latitude", nullable = false)
  private String latitude;

  @Column(name = "longitude", nullable = false)
  private String longitude;

  @Column(name = "zip", nullable = false)
  private Integer zip;

  @ManyToOne
  @JoinColumn(name="establishment_id", nullable=false)
  private Establishments establishment;

  @ManyToOne
  @JoinColumn(name="city_id", nullable=false)
  private Cities city;

  @OneToMany(mappedBy="establishmentBranch")
  private List<EstablishmentScores> establishmentScores;

  @OneToMany(mappedBy="establishmentBranch")
  private List<EstablishmentOpenHours> openHours;

  @OneToMany(mappedBy="establishmentBranch")
  private List<VoucherEstablishmentBranches> voucherEstablishmentBranches;

  @OneToMany(mappedBy="establishmentBranch")
  private List<Promotions> promotions;
}
