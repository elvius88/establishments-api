package py.com.jaha.api.establishments.domain.usecases.establishments;

import static py.com.jaha.api.establishments.domain.models.commons.enums.ErrorCatalog.NOT_FOUND;
import static py.com.jaha.api.establishments.domain.usecases.utils.LogUtil.logAndThrows;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentsCommand;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentsResponse;
import py.com.jaha.api.establishments.domain.ports.in.GetEstablishmentsPort;
import py.com.jaha.api.establishments.domain.ports.out.EstablishmentsRepositoryPort;
import py.com.jaha.api.establishments.domain.usecases.establishments.mappers.GetEstablishmentResponseMapper;

@Slf4j
@RequiredArgsConstructor
public class GetEstablishmentsUseCase implements GetEstablishmentsPort {

  private final EstablishmentsRepositoryPort establishmentsRepositoryPort;

  @Override
  public GetEstablishmentsResponse execute(GetEstablishmentsCommand command) {
    return Try.of(() -> establishmentsRepositoryPort.getEstablishmentsBy(command.getName(), command.getCategoryId(), command.getEstablishmentId()))
        .filter(establishments -> !CollectionUtils.isEmpty(establishments))
        .map(GetEstablishmentResponseMapper.INSTANCE::toGetEstablishmentResponseList)
        .map(response -> GetEstablishmentsResponse.builder().establishments(response).build())
        .onSuccess(response -> log.debug("Query has been successful: [{}]", response))
        .onFailure(logAndThrows(log, "Error querying establishments data by criteria: [{}]", NOT_FOUND))
        .get();
  }
}
