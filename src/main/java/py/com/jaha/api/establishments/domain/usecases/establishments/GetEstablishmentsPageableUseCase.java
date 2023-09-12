package py.com.jaha.api.establishments.domain.usecases.establishments;

import static py.com.jaha.api.establishments.domain.models.commons.enums.ErrorCatalog.NOT_FOUND;
import static py.com.jaha.api.establishments.domain.usecases.utils.LogUtil.logAndThrows;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.util.CollectionUtils;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentNearbyResponse;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentsCommand;
import py.com.jaha.api.establishments.domain.ports.in.GetEstablishmentsPageablePort;
import py.com.jaha.api.establishments.domain.ports.out.EstablishmentsRepositoryPort;
import py.com.jaha.api.establishments.domain.usecases.establishments.mappers.GetEstablishmentResponseMapper;

@Slf4j
@RequiredArgsConstructor
public class GetEstablishmentsPageableUseCase implements GetEstablishmentsPageablePort {

  private final EstablishmentsRepositoryPort establishmentsRepositoryPort;

  @Override
  public Page<GetEstablishmentNearbyResponse> execute(GetEstablishmentsCommand command) {
    return Try.of(() -> establishmentsRepositoryPort.getEstablishmentsNearBy(command.getLatitude(), command.getLongitude(), command.getPageable()))
        .filter(establishmentPage -> !CollectionUtils.isEmpty(establishmentPage.getContent()))
        .map(GetEstablishmentResponseMapper.INSTANCE::toGetEstablishmentsPageableResponse)
        .onSuccess(response -> log.debug("Query has been successful: [{}]", response))
        .onFailure(logAndThrows(log, "Error querying establishment data: [{}]", NOT_FOUND))
        .get();
  }

}
