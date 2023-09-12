package py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import py.com.jaha.api.establishments.domain.models.establishments.Establishment;
import py.com.jaha.api.establishments.infraestructure.adapters.out.commons.IMapper;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.Establishments;

@Mapper
public interface EstablishmentsMapper extends IMapper<Establishment, Establishments> {

  EstablishmentsMapper INSTANCE = Mappers.getMapper(EstablishmentsMapper.class);

}
