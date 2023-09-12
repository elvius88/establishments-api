package py.com.jaha.api.establishments.domain.ports.in;

import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentDetailsResponse;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentsCommand;
import py.com.jaha.api.establishments.domain.usecases.UseCase;

public interface GetEstablishmentPort extends UseCase<GetEstablishmentDetailsResponse, GetEstablishmentsCommand> {
}
