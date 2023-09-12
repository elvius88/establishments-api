package py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "establishment_scores")
public class EstablishmentScores implements Serializable {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(nullable = false, updatable = false)
  private String id;

  @Column(name = "client_id", nullable = false)
  private String client;

  @ManyToOne
  @JoinColumn(name="establishment_branch_id", nullable=false)
  private EstablishmentBranches establishmentBranch;

  @Column(name = "score", nullable = false)
  private Integer score;
}
