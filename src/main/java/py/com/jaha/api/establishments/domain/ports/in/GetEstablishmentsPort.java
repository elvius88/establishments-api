package py.com.jaha.api.establishments.domain.ports.in;

import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentsCommand;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentsResponse;
import py.com.jaha.api.establishments.domain.usecases.UseCase;

public interface GetEstablishmentsPort extends UseCase<GetEstablishmentsResponse, GetEstablishmentsCommand> {
}
