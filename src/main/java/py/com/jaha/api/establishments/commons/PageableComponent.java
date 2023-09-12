package py.com.jaha.api.establishments.commons;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import py.com.jaha.api.establishments.config.CustomPageable;
import py.com.jaha.api.establishments.infraestructure.adapters.in.establishments.EstablishmentsResource;

@Component
public class PageableComponent {

    @CustomPageable(EstablishmentsResource.class)
    public <T> ApiPageableResponse<T> toEstablishmentApiPageableResource(Page<T> page) {
        var pagination = new CustomPagination();
        pagination.setPage(page.getNumber());
        pagination.setPageSize(page.getSize());
        pagination.setTotalElements(page.getTotalElements());
        pagination.setTotalPages(page.getTotalPages());
        var response = ApiPageableResponse.of(page.getContent());
        response.setPagination(pagination);
        return ApiPageableResponse.of(page.getContent());
    }
}
