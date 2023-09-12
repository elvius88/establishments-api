package py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
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
@Table(name = "promotions")
public class Promotions implements Serializable {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(nullable = false, updatable = false)
  private String id;

  @Column(name="name", nullable=false)
  private String name;

  @Column(name="description", nullable=false)
  private String description;

  @Column(name="terms", nullable=false)
  private String terms;

  @Column(name="start_date", nullable=false)
  private LocalDate startDate;

  @Column(name="end_date", nullable=false)
  private LocalDate endDate;

  @Column(name = "created_at", nullable = false, updatable = false)
  private OffsetDateTime createdAt;

  @Column(name = "updated_at", nullable = false)
  private OffsetDateTime updatedAt;

  @ManyToOne
  @JoinColumn(name="establishment_branch_id", nullable=false)
  private EstablishmentBranches establishmentBranch;

  @OneToMany(mappedBy="promotion")
  private List<PromotionImages> promotionImages;

}
