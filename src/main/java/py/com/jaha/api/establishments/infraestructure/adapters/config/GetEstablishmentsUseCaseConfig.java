package py.com.jaha.api.establishments.infraestructure.adapters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import py.com.jaha.api.establishments.domain.ports.in.GetEstablishmentPort;
import py.com.jaha.api.establishments.domain.ports.in.GetEstablishmentsPageablePort;
import py.com.jaha.api.establishments.domain.ports.in.GetEstablishmentsPort;
import py.com.jaha.api.establishments.domain.ports.out.EstablishmentsRepositoryPort;
import py.com.jaha.api.establishments.domain.usecases.establishments.GetEstablishmentUseCase;
import py.com.jaha.api.establishments.domain.usecases.establishments.GetEstablishmentsPageableUseCase;
import py.com.jaha.api.establishments.domain.usecases.establishments.GetEstablishmentsUseCase;

@Configuration
public class GetEstablishmentsUseCaseConfig {

    @Bean
    public GetEstablishmentsPort getEstablishmentsUseCase(EstablishmentsRepositoryPort establishmentsRepositoryPort){
        return new GetEstablishmentsUseCase(establishmentsRepositoryPort);
    }

    @Bean
    public GetEstablishmentPort getEstablishmentUseCase(EstablishmentsRepositoryPort establishmentsRepositoryPort){
        return new GetEstablishmentUseCase(establishmentsRepositoryPort);
    }

    @Bean
    public GetEstablishmentsPageablePort getEstablishmentsPageableUseCase(EstablishmentsRepositoryPort establishmentsRepositoryPort){
        return new GetEstablishmentsPageableUseCase(establishmentsRepositoryPort);
    }
}
