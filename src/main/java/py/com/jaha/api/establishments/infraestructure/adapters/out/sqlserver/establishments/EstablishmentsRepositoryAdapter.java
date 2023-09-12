package py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments;

import io.vavr.control.Try;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import py.com.jaha.api.establishments.domain.models.establishments.EstablishmentBranch;
import py.com.jaha.api.establishments.domain.ports.out.EstablishmentsRepositoryPort;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.mapper.EstablishmentBranchesMapper;

@Service
@Slf4j
@RequiredArgsConstructor
public class EstablishmentsRepositoryAdapter implements EstablishmentsRepositoryPort {

  private final EstablishmentBranchesRepository establishmentBranchesRepository;

  @Override
  public EstablishmentBranch getEstablishmentByBranchId(String id) {
    return Try.of(() -> establishmentBranchesRepository.findEstablishmentByBranchId(id))
        .map(EstablishmentBranchesMapper.INSTANCE::toDomain)
        .get();
  }

  @Override
  public List<EstablishmentBranch> getEstablishmentsBy(String name, String categoryId, String establishmentId) {
    return Try.of(() -> establishmentBranchesRepository.findEstablishmentsBy(name, categoryId, establishmentId))
        .map(EstablishmentBranchesMapper.INSTANCE::toDomainList)
        .get();
  }

  @Override
  public Page<EstablishmentBranch> getEstablishmentsNearBy(String latitude, String longitude, Pageable pageable) {
    return Try.of(() -> establishmentBranchesRepository.findEstablishmentBranchesNearBy(latitude, longitude, pageable))
        .map(EstablishmentBranchesMapper.INSTANCE::toEstablishmentBranchPageableResponse)
        .get();
  }
}
