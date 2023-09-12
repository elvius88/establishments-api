package py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities;

import java.io.Serializable;
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
@Table(name = "establishments")
public class Establishments implements Serializable {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(nullable = false, updatable = false)
  private String id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "short_description", nullable = false)
  private String shortDescription;

  @Column(name = "long_description", nullable = false)
  private String longDescription;

  @Column(name = "profile_image_path", nullable = false)
  private String profileImagePath;

  @Column(name = "front_page_image_path", nullable = false)
  private String frontPageImagePath;

  @Column(name = "profile_mini_image_path", nullable = false)
  private String profileMiniImagePath;

  @Column(name = "front_mini_page_image_path", nullable = false)
  private String frontMiniPageImagePath;

  @Column(name = "created_at", nullable = false, updatable = false)
  private OffsetDateTime createdAt;

  @Column(name = "updated_at", nullable = false)
  private OffsetDateTime updatedAt;

  @ManyToOne
  @JoinColumn(name="category_id", nullable=false)
  private Categories category;

  @OneToMany(mappedBy="establishment")
  private List<EstablishmentBranches> establishmentBranches;
}
