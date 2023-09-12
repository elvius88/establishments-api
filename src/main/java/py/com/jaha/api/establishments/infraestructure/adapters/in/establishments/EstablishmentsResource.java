package py.com.jaha.api.establishments.infraestructure.adapters.in.establishments;

import static py.com.jaha.api.establishments.commons.ApiVersions.API_VERSION_V1;
import static py.com.jaha.api.establishments.constants.GlobalConstants.API_BASE;
import static py.com.jaha.api.establishments.domain.usecases.utils.LogUtil.buildErrorCommon;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import py.com.jaha.api.establishments.commons.ApiPageableResponse;
import py.com.jaha.api.establishments.commons.ApiResponse;
import py.com.jaha.api.establishments.commons.Filterable;
import py.com.jaha.api.establishments.commons.PageableComponent;
import py.com.jaha.api.establishments.config.exception.ApiError;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentDetailsResponse;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentNearbyResponse;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentResponse;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentsResponse;
import py.com.jaha.api.establishments.domain.ports.in.GetEstablishmentPort;
import py.com.jaha.api.establishments.domain.ports.in.GetEstablishmentsPageablePort;
import py.com.jaha.api.establishments.domain.ports.in.GetEstablishmentsPort;
import py.com.jaha.api.establishments.infraestructure.adapters.mappers.EstablishmentsCommandMapper;

@RestController
@RequestMapping(value = "/" + API_BASE + "/establishments/" + API_VERSION_V1)
@Tag(name = "EstablishmentsResource")
@RequiredArgsConstructor
@Slf4j
public class EstablishmentsResource {

    private final GetEstablishmentPort getEstablishmentUseCase;
    private final GetEstablishmentsPort getEstablishmentsUseCase;
    private final GetEstablishmentsPageablePort getEstablishmentsPageableUseCase;
    private final PageableComponent pageableComponent;

    @Operation(summary = "Establishment", description = "Get establishment data by ID")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GetEstablishmentResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))) })
    @Filterable
    @GetMapping("/establishments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<GetEstablishmentDetailsResponse> getEstablishment(@PathVariable String id) {
        return ApiResponse.of(
            getEstablishmentUseCase.execute(
                EstablishmentsCommandMapper.INSTANCE.toCommand(id, null, null, null, null, null, null)));
    }

    @Operation(summary = "Establishments", description = "Get establishments data by parameters filters")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GetEstablishmentsResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))) })
    @Filterable
    @GetMapping("/establishments")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<GetEstablishmentsResponse> getEstablishments(@RequestParam(required = false) String name,
                                                                    @RequestParam(name = "client_id", required = false) String clientId,
                                                                    @RequestParam(name = "establishment_Id", required = false) String establishmentId) {
        return ApiResponse.of(
            getEstablishmentsUseCase.execute(
                EstablishmentsCommandMapper.INSTANCE.toCommand(null, name, clientId, establishmentId, null, null, null)));
    }

    @Operation(summary = "Establishments", description = "Get establishments data by parameters filters")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GetEstablishmentNearbyResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))) })
    @Filterable
    @GetMapping("/establishments/nearby")
    @ResponseStatus(HttpStatus.OK)
    public ApiPageableResponse<GetEstablishmentNearbyResponse> getEstablishmentsNearby(@RequestParam(required = false) String latitude,
                                                                                       @RequestParam(required = false) String longitude,
                                                                                       @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                                       @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize) {
        return Try.of(() -> getEstablishmentsPageableUseCase.execute(
            EstablishmentsCommandMapper.INSTANCE.toCommand(null, null, null, null, latitude, longitude, PageRequest.of(page, pageSize))))
            .map(pageableComponent::toEstablishmentApiPageableResource)
            .getOrElseThrow(ex -> buildErrorCommon(log, ex));
    }
}
