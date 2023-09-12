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
@Table(name = "voucher_days")
public class VoucherDays implements Serializable {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(nullable = false, updatable = false)
  private String id;

  @ManyToOne
  @JoinColumn(name="voucher_id", nullable = false)
  private Vouchers voucher;

  @ManyToOne
  @JoinColumn(name="day_id", nullable=false)
  private Days day;
}
