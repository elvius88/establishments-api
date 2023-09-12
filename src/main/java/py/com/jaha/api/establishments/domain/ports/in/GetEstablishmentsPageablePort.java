package py.com.jaha.api.establishments.domain.ports.in;

import org.springframework.data.domain.Page;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentNearbyResponse;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentsCommand;
import py.com.jaha.api.establishments.domain.usecases.UseCase;

public interface GetEstablishmentsPageablePort extends UseCase<Page<GetEstablishmentNearbyResponse>, GetEstablishmentsCommand> {
}
