package py.com.jaha.api.establishments.domain.usecases.establishments.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentDetailsResponse;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentDetailsResponse.GetEstablishmentDetailsResponseBuilder;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentNearbyResponse;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentNearbyResponse.GetEstablishmentNearbyResponseBuilder;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentResponse;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentResponse.GetEstablishmentResponseBuilder;
import py.com.jaha.api.establishments.domain.models.establishments.Category;
import py.com.jaha.api.establishments.domain.models.establishments.City;
import py.com.jaha.api.establishments.domain.models.establishments.Establishment;
import py.com.jaha.api.establishments.domain.models.establishments.EstablishmentBranch;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-10T17:19:18-0400",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class GetEstablishmentResponseMapperImpl implements GetEstablishmentResponseMapper {

    @Override
    public GetEstablishmentDetailsResponse toGetEstablishmentDetailsResponse(EstablishmentBranch establishment) {
        if ( establishment == null ) {
            return null;
        }

        GetEstablishmentDetailsResponseBuilder<?, ?> getEstablishmentDetailsResponse = GetEstablishmentDetailsResponse.builder();

        getEstablishmentDetailsResponse.branchId( establishment.getId() );
        getEstablishmentDetailsResponse.address( establishment.getAddress() );
        getEstablishmentDetailsResponse.city( establishmentCityName( establishment ) );
        getEstablishmentDetailsResponse.latitude( establishment.getLatitude() );
        getEstablishmentDetailsResponse.frontPageImagePath( establishmentEstablishmentFrontPageImagePath( establishment ) );
        getEstablishmentDetailsResponse.shortDescription( establishmentEstablishmentShortDescription( establishment ) );
        getEstablishmentDetailsResponse.vouchers( GetEstablishmentResponseMapper.toVoucherEstablishmentMapping( establishment.getVoucherEstablishmentBranches() ) );
        if ( establishment.getEstablishmentScores() != null ) {
            getEstablishmentDetailsResponse.score( String.valueOf( GetEstablishmentResponseMapper.toScoreMapping( establishment.getEstablishmentScores() ) ) );
        }
        getEstablishmentDetailsResponse.promotions( GetEstablishmentResponseMapper.toPromotionsEstablishmentMapping( establishment.getPromotions() ) );
        getEstablishmentDetailsResponse.name( establishmentEstablishmentName( establishment ) );
        getEstablishmentDetailsResponse.profileImagePath( establishmentEstablishmentProfileImagePath( establishment ) );
        getEstablishmentDetailsResponse.openingHours( GetEstablishmentResponseMapper.toOpeningHourByTodayMapping( establishment.getOpenHours() ) );
        getEstablishmentDetailsResponse.id( establishmentEstablishmentId( establishment ) );
        getEstablishmentDetailsResponse.category( establishmentEstablishmentCategoryName( establishment ) );
        getEstablishmentDetailsResponse.longitude( establishment.getLongitude() );

        return getEstablishmentDetailsResponse.build();
    }

    @Override
    public GetEstablishmentNearbyResponse toGetEstablishmentBranchResponse(EstablishmentBranch establishmentBranch) {
        if ( establishmentBranch == null ) {
            return null;
        }

        GetEstablishmentNearbyResponseBuilder getEstablishmentNearbyResponse = GetEstablishmentNearbyResponse.builder();

        getEstablishmentNearbyResponse.branchId( establishmentBranch.getId() );
        if ( establishmentBranch.getEstablishmentScores() != null ) {
            getEstablishmentNearbyResponse.score( String.valueOf( GetEstablishmentResponseMapper.toScoreMapping( establishmentBranch.getEstablishmentScores() ) ) );
        }
        getEstablishmentNearbyResponse.address( establishmentBranch.getAddress() );
        getEstablishmentNearbyResponse.city( establishmentCityName( establishmentBranch ) );
        getEstablishmentNearbyResponse.latitude( establishmentBranch.getLatitude() );
        getEstablishmentNearbyResponse.name( establishmentEstablishmentName( establishmentBranch ) );
        getEstablishmentNearbyResponse.id( establishmentEstablishmentId( establishmentBranch ) );
        getEstablishmentNearbyResponse.category( establishmentEstablishmentCategoryName( establishmentBranch ) );
        getEstablishmentNearbyResponse.longitude( establishmentBranch.getLongitude() );

        return getEstablishmentNearbyResponse.build();
    }

    @Override
    public GetEstablishmentResponse toGetEstablishmentResponse(EstablishmentBranch establishment) {
        if ( establishment == null ) {
            return null;
        }

        GetEstablishmentResponseBuilder<?, ?> getEstablishmentResponse = GetEstablishmentResponse.builder();

        getEstablishmentResponse.branchId( establishment.getId() );
        if ( establishment.getEstablishmentScores() != null ) {
            getEstablishmentResponse.score( String.valueOf( GetEstablishmentResponseMapper.toScoreMapping( establishment.getEstablishmentScores() ) ) );
        }
        getEstablishmentResponse.address( establishment.getAddress() );
        getEstablishmentResponse.city( establishmentCityName( establishment ) );
        getEstablishmentResponse.latitude( establishment.getLatitude() );
        getEstablishmentResponse.name( establishmentEstablishmentName( establishment ) );
        getEstablishmentResponse.id( establishmentEstablishmentId( establishment ) );
        getEstablishmentResponse.category( establishmentEstablishmentCategoryName( establishment ) );
        getEstablishmentResponse.longitude( establishment.getLongitude() );

        return getEstablishmentResponse.build();
    }

    @Override
    public List<GetEstablishmentResponse> toGetEstablishmentResponseList(List<EstablishmentBranch> establishments) {
        if ( establishments == null ) {
            return null;
        }

        List<GetEstablishmentResponse> list = new ArrayList<GetEstablishmentResponse>( establishments.size() );
        for ( EstablishmentBranch establishmentBranch : establishments ) {
            list.add( toGetEstablishmentResponse( establishmentBranch ) );
        }

        return list;
    }

    private String establishmentCityName(EstablishmentBranch establishmentBranch) {
        if ( establishmentBranch == null ) {
            return null;
        }
        City city = establishmentBranch.getCity();
        if ( city == null ) {
            return null;
        }
        String name = city.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String establishmentEstablishmentFrontPageImagePath(EstablishmentBranch establishmentBranch) {
        if ( establishmentBranch == null ) {
            return null;
        }
        Establishment establishment = establishmentBranch.getEstablishment();
        if ( establishment == null ) {
            return null;
        }
        String frontPageImagePath = establishment.getFrontPageImagePath();
        if ( frontPageImagePath == null ) {
            return null;
        }
        return frontPageImagePath;
    }

    private String establishmentEstablishmentShortDescription(EstablishmentBranch establishmentBranch) {
        if ( establishmentBranch == null ) {
            return null;
        }
        Establishment establishment = establishmentBranch.getEstablishment();
        if ( establishment == null ) {
            return null;
        }
        String shortDescription = establishment.getShortDescription();
        if ( shortDescription == null ) {
            return null;
        }
        return shortDescription;
    }

    private String establishmentEstablishmentName(EstablishmentBranch establishmentBranch) {
        if ( establishmentBranch == null ) {
            return null;
        }
        Establishment establishment = establishmentBranch.getEstablishment();
        if ( establishment == null ) {
            return null;
        }
        String name = establishment.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String establishmentEstablishmentProfileImagePath(EstablishmentBranch establishmentBranch) {
        if ( establishmentBranch == null ) {
            return null;
        }
        Establishment establishment = establishmentBranch.getEstablishment();
        if ( establishment == null ) {
            return null;
        }
        String profileImagePath = establishment.getProfileImagePath();
        if ( profileImagePath == null ) {
            return null;
        }
        return profileImagePath;
    }

    private String establishmentEstablishmentId(EstablishmentBranch establishmentBranch) {
        if ( establishmentBranch == null ) {
            return null;
        }
        Establishment establishment = establishmentBranch.getEstablishment();
        if ( establishment == null ) {
            return null;
        }
        String id = establishment.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String establishmentEstablishmentCategoryName(EstablishmentBranch establishmentBranch) {
        if ( establishmentBranch == null ) {
            return null;
        }
        Establishment establishment = establishmentBranch.getEstablishment();
        if ( establishment == null ) {
            return null;
        }
        Category category = establishment.getCategory();
        if ( category == null ) {
            return null;
        }
        String name = category.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
