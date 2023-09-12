package py.com.jaha.api.establishments.domain.ports.out;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import py.com.jaha.api.establishments.domain.models.establishments.EstablishmentBranch;

public interface EstablishmentsRepositoryPort {

  EstablishmentBranch getEstablishmentByBranchId(String id);

  List<EstablishmentBranch> getEstablishmentsBy(String name, String categoryId, String establishmentId);
  Page<EstablishmentBranch> getEstablishmentsNearBy(String latitude, String longitude, Pageable pageable);
}
