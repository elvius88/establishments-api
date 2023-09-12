package py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import py.com.jaha.api.establishments.domain.models.establishments.Establishment;
import py.com.jaha.api.establishments.domain.models.establishments.EstablishmentBranch;
import py.com.jaha.api.establishments.domain.models.establishments.EstablishmentScore;
import py.com.jaha.api.establishments.infraestructure.adapters.out.commons.IMapper;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.EstablishmentBranches;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.EstablishmentScores;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.Establishments;

@Mapper
public interface EstablishmentBranchesMapper extends IMapper<EstablishmentBranch, EstablishmentBranches> {

  EstablishmentBranchesMapper INSTANCE = Mappers.getMapper(EstablishmentBranchesMapper.class);

  default Page<EstablishmentBranch> toEstablishmentBranchPageableResponse(Page<EstablishmentBranches> establishmentBranchesPage) {
    return new PageImpl<>(establishmentBranchesPage.stream()
        .map(EstablishmentBranchesMapper.INSTANCE::toDomain)
        .collect(Collectors.toList()),
        establishmentBranchesPage.getPageable(),
        establishmentBranchesPage.getTotalElements());
  }
}
