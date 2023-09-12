package py.com.jaha.api.establishments.domain.usecases.establishments;

import static py.com.jaha.api.establishments.domain.models.commons.enums.ErrorCatalog.NOT_FOUND;
import static py.com.jaha.api.establishments.domain.usecases.utils.LogUtil.logAndThrows;

import io.vavr.control.Try;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentDetailsResponse;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentsCommand;
import py.com.jaha.api.establishments.domain.ports.in.GetEstablishmentPort;
import py.com.jaha.api.establishments.domain.ports.out.EstablishmentsRepositoryPort;
import py.com.jaha.api.establishments.domain.usecases.establishments.mappers.GetEstablishmentResponseMapper;

@Slf4j
@RequiredArgsConstructor
public class GetEstablishmentUseCase implements GetEstablishmentPort {

  private final EstablishmentsRepositoryPort establishmentsRepositoryPort;

  @Override
  public GetEstablishmentDetailsResponse execute(GetEstablishmentsCommand command) {
    return Try.of(() -> establishmentsRepositoryPort.getEstablishmentByBranchId(command.getId()))
        .filter(Objects::nonNull)
        .map(GetEstablishmentResponseMapper.INSTANCE::toGetEstablishmentDetailsResponse)
        .onSuccess(response -> log.debug("Query has been successful: [{}]", response))
        .onFailure(logAndThrows(log, "Error querying establishment data by branch: [{}]", NOT_FOUND))
        .get();
  }
}
