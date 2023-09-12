package py.com.jaha.api.establishments.domain.models.establishments;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.EstablishmentBranches;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class City implements Serializable {

  private String id;
  private String name;
}
