package py.com.jaha.api.establishments.infraestructure.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Pageable;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentsCommand;

@Mapper
public interface EstablishmentsCommandMapper {

  EstablishmentsCommandMapper INSTANCE = Mappers.getMapper(EstablishmentsCommandMapper.class);

  default GetEstablishmentsCommand toCommand(String id,
                                             String name,
                                             String clientId,
                                             String establishmentId,
                                             String latitude,
                                             String longitude,
                                             Pageable pageable) {
    return GetEstablishmentsCommand.builder()
        .id(id).name(name)
        .categoryId(clientId).establishmentId(establishmentId)
        .latitude(latitude).longitude(longitude).pageable(pageable).build();
  }
}
