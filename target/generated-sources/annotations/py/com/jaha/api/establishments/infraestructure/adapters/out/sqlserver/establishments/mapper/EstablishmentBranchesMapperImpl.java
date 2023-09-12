package py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import py.com.jaha.api.establishments.domain.models.establishments.Category;
import py.com.jaha.api.establishments.domain.models.establishments.City;
import py.com.jaha.api.establishments.domain.models.establishments.Day;
import py.com.jaha.api.establishments.domain.models.establishments.Establishment;
import py.com.jaha.api.establishments.domain.models.establishments.EstablishmentBranch;
import py.com.jaha.api.establishments.domain.models.establishments.EstablishmentOpenHour;
import py.com.jaha.api.establishments.domain.models.establishments.EstablishmentScore;
import py.com.jaha.api.establishments.domain.models.establishments.Promotion;
import py.com.jaha.api.establishments.domain.models.establishments.PromotionImage;
import py.com.jaha.api.establishments.domain.models.establishments.Voucher;
import py.com.jaha.api.establishments.domain.models.establishments.VoucherEstablishmentBranch;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.Categories;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.Cities;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.Days;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.EstablishmentBranches;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.EstablishmentOpenHours;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.EstablishmentScores;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.Establishments;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.PromotionImages;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.Promotions;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.VoucherEstablishmentBranches;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.Vouchers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-10T17:18:59-0400",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class EstablishmentBranchesMapperImpl implements EstablishmentBranchesMapper {

    @Override
    public EstablishmentBranch toDomain(EstablishmentBranches entity) {
        if ( entity == null ) {
            return null;
        }

        EstablishmentBranch establishmentBranch = new EstablishmentBranch();

        establishmentBranch.setId( entity.getId() );
        establishmentBranch.setAddress( entity.getAddress() );
        establishmentBranch.setLatitude( entity.getLatitude() );
        establishmentBranch.setLongitude( entity.getLongitude() );
        establishmentBranch.setZip( entity.getZip() );
        establishmentBranch.setCity( citiesToCity( entity.getCity() ) );
        establishmentBranch.setEstablishment( establishmentsToEstablishment( entity.getEstablishment() ) );
        establishmentBranch.setEstablishmentScores( establishmentScoresListToEstablishmentScoreList( entity.getEstablishmentScores() ) );
        establishmentBranch.setPromotions( promotionsListToPromotionList( entity.getPromotions() ) );
        establishmentBranch.setVoucherEstablishmentBranches( voucherEstablishmentBranchesListToVoucherEstablishmentBranchList( entity.getVoucherEstablishmentBranches() ) );
        establishmentBranch.setOpenHours( establishmentOpenHoursListToEstablishmentOpenHourList( entity.getOpenHours() ) );

        return establishmentBranch;
    }

    @Override
    public EstablishmentBranches toEntity(EstablishmentBranch domain) {
        if ( domain == null ) {
            return null;
        }

        EstablishmentBranches establishmentBranches = new EstablishmentBranches();

        establishmentBranches.setId( domain.getId() );
        establishmentBranches.setAddress( domain.getAddress() );
        establishmentBranches.setLatitude( domain.getLatitude() );
        establishmentBranches.setLongitude( domain.getLongitude() );
        establishmentBranches.setZip( domain.getZip() );
        establishmentBranches.setEstablishment( establishmentToEstablishments( domain.getEstablishment() ) );
        establishmentBranches.setCity( cityToCities( domain.getCity() ) );
        establishmentBranches.setEstablishmentScores( establishmentScoreListToEstablishmentScoresList( domain.getEstablishmentScores() ) );
        establishmentBranches.setOpenHours( establishmentOpenHourListToEstablishmentOpenHoursList( domain.getOpenHours() ) );
        establishmentBranches.setVoucherEstablishmentBranches( voucherEstablishmentBranchListToVoucherEstablishmentBranchesList( domain.getVoucherEstablishmentBranches() ) );
        establishmentBranches.setPromotions( promotionListToPromotionsList( domain.getPromotions() ) );

        return establishmentBranches;
    }

    @Override
    public List<EstablishmentBranch> toDomainList(List<EstablishmentBranches> entities) {
        if ( entities == null ) {
            return null;
        }

        List<EstablishmentBranch> list = new ArrayList<EstablishmentBranch>( entities.size() );
        for ( EstablishmentBranches establishmentBranches : entities ) {
            list.add( toDomain( establishmentBranches ) );
        }

        return list;
    }

    @Override
    public List<EstablishmentBranches> toEntityList(List<EstablishmentBranch> domains) {
        if ( domains == null ) {
            return null;
        }

        List<EstablishmentBranches> list = new ArrayList<EstablishmentBranches>( domains.size() );
        for ( EstablishmentBranch establishmentBranch : domains ) {
            list.add( toEntity( establishmentBranch ) );
        }

        return list;
    }

    protected City citiesToCity(Cities cities) {
        if ( cities == null ) {
            return null;
        }

        City city = new City();

        city.setId( cities.getId() );
        city.setName( cities.getName() );

        return city;
    }

    protected Category categoriesToCategory(Categories categories) {
        if ( categories == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categories.getId() );
        category.setName( categories.getName() );
        category.setImageAppPath( categories.getImageAppPath() );
        category.setImageWebPath( categories.getImageWebPath() );
        category.setCreatedAt( categories.getCreatedAt() );
        category.setUpdatedAt( categories.getUpdatedAt() );

        return category;
    }

    protected Establishment establishmentsToEstablishment(Establishments establishments) {
        if ( establishments == null ) {
            return null;
        }

        Establishment establishment = new Establishment();

        establishment.setId( establishments.getId() );
        establishment.setName( establishments.getName() );
        establishment.setShortDescription( establishments.getShortDescription() );
        establishment.setLongDescription( establishments.getLongDescription() );
        establishment.setProfileImagePath( establishments.getProfileImagePath() );
        establishment.setFrontPageImagePath( establishments.getFrontPageImagePath() );
        establishment.setProfileMiniImagePath( establishments.getProfileMiniImagePath() );
        establishment.setFrontMiniPageImagePath( establishments.getFrontMiniPageImagePath() );
        establishment.setCategory( categoriesToCategory( establishments.getCategory() ) );
        establishment.setCreatedAt( establishments.getCreatedAt() );
        establishment.setUpdatedAt( establishments.getUpdatedAt() );

        return establishment;
    }

    protected EstablishmentScore establishmentScoresToEstablishmentScore(EstablishmentScores establishmentScores) {
        if ( establishmentScores == null ) {
            return null;
        }

        EstablishmentScore establishmentScore = new EstablishmentScore();

        establishmentScore.setId( establishmentScores.getId() );
        establishmentScore.setClient( establishmentScores.getClient() );
        establishmentScore.setScore( establishmentScores.getScore() );

        return establishmentScore;
    }

    protected List<EstablishmentScore> establishmentScoresListToEstablishmentScoreList(List<EstablishmentScores> list) {
        if ( list == null ) {
            return null;
        }

        List<EstablishmentScore> list1 = new ArrayList<EstablishmentScore>( list.size() );
        for ( EstablishmentScores establishmentScores : list ) {
            list1.add( establishmentScoresToEstablishmentScore( establishmentScores ) );
        }

        return list1;
    }

    protected PromotionImage promotionImagesToPromotionImage(PromotionImages promotionImages) {
        if ( promotionImages == null ) {
            return null;
        }

        PromotionImage promotionImage = new PromotionImage();

        promotionImage.setId( promotionImages.getId() );
        promotionImage.setImagePath( promotionImages.getImagePath() );
        promotionImage.setActive( promotionImages.getActive() );

        return promotionImage;
    }

    protected List<PromotionImage> promotionImagesListToPromotionImageList(List<PromotionImages> list) {
        if ( list == null ) {
            return null;
        }

        List<PromotionImage> list1 = new ArrayList<PromotionImage>( list.size() );
        for ( PromotionImages promotionImages : list ) {
            list1.add( promotionImagesToPromotionImage( promotionImages ) );
        }

        return list1;
    }

    protected Promotion promotionsToPromotion(Promotions promotions) {
        if ( promotions == null ) {
            return null;
        }

        Promotion promotion = new Promotion();

        promotion.setName( promotions.getName() );
        promotion.setDescription( promotions.getDescription() );
        promotion.setTerms( promotions.getTerms() );
        promotion.setStartDate( promotions.getStartDate() );
        promotion.setEndDate( promotions.getEndDate() );
        promotion.setPromotionImages( promotionImagesListToPromotionImageList( promotions.getPromotionImages() ) );

        return promotion;
    }

    protected List<Promotion> promotionsListToPromotionList(List<Promotions> list) {
        if ( list == null ) {
            return null;
        }

        List<Promotion> list1 = new ArrayList<Promotion>( list.size() );
        for ( Promotions promotions : list ) {
            list1.add( promotionsToPromotion( promotions ) );
        }

        return list1;
    }

    protected Voucher vouchersToVoucher(Vouchers vouchers) {
        if ( vouchers == null ) {
            return null;
        }

        Voucher voucher = new Voucher();

        voucher.setName( vouchers.getName() );
        voucher.setDescription( vouchers.getDescription() );
        voucher.setImagePath( vouchers.getImagePath() );

        return voucher;
    }

    protected VoucherEstablishmentBranch voucherEstablishmentBranchesToVoucherEstablishmentBranch(VoucherEstablishmentBranches voucherEstablishmentBranches) {
        if ( voucherEstablishmentBranches == null ) {
            return null;
        }

        VoucherEstablishmentBranch voucherEstablishmentBranch = new VoucherEstablishmentBranch();

        voucherEstablishmentBranch.setId( voucherEstablishmentBranches.getId() );
        voucherEstablishmentBranch.setVoucher( vouchersToVoucher( voucherEstablishmentBranches.getVoucher() ) );

        return voucherEstablishmentBranch;
    }

    protected List<VoucherEstablishmentBranch> voucherEstablishmentBranchesListToVoucherEstablishmentBranchList(List<VoucherEstablishmentBranches> list) {
        if ( list == null ) {
            return null;
        }

        List<VoucherEstablishmentBranch> list1 = new ArrayList<VoucherEstablishmentBranch>( list.size() );
        for ( VoucherEstablishmentBranches voucherEstablishmentBranches : list ) {
            list1.add( voucherEstablishmentBranchesToVoucherEstablishmentBranch( voucherEstablishmentBranches ) );
        }

        return list1;
    }

    protected Day daysToDay(Days days) {
        if ( days == null ) {
            return null;
        }

        Day day = new Day();

        day.setId( days.getId() );
        day.setName( days.getName() );
        day.setOrderDay( days.getOrderDay() );

        return day;
    }

    protected EstablishmentOpenHour establishmentOpenHoursToEstablishmentOpenHour(EstablishmentOpenHours establishmentOpenHours) {
        if ( establishmentOpenHours == null ) {
            return null;
        }

        EstablishmentOpenHour establishmentOpenHour = new EstablishmentOpenHour();

        establishmentOpenHour.setOpeningTime( establishmentOpenHours.getOpeningTime() );
        establishmentOpenHour.setClosingTime( establishmentOpenHours.getClosingTime() );
        establishmentOpenHour.setDay( daysToDay( establishmentOpenHours.getDay() ) );

        return establishmentOpenHour;
    }

    protected List<EstablishmentOpenHour> establishmentOpenHoursListToEstablishmentOpenHourList(List<EstablishmentOpenHours> list) {
        if ( list == null ) {
            return null;
        }

        List<EstablishmentOpenHour> list1 = new ArrayList<EstablishmentOpenHour>( list.size() );
        for ( EstablishmentOpenHours establishmentOpenHours : list ) {
            list1.add( establishmentOpenHoursToEstablishmentOpenHour( establishmentOpenHours ) );
        }

        return list1;
    }

    protected Categories categoryToCategories(Category category) {
        if ( category == null ) {
            return null;
        }

        Categories categories = new Categories();

        categories.setId( category.getId() );
        categories.setName( category.getName() );
        categories.setImageAppPath( category.getImageAppPath() );
        categories.setImageWebPath( category.getImageWebPath() );
        categories.setCreatedAt( category.getCreatedAt() );
        categories.setUpdatedAt( category.getUpdatedAt() );

        return categories;
    }

    protected Establishments establishmentToEstablishments(Establishment establishment) {
        if ( establishment == null ) {
            return null;
        }

        Establishments establishments = new Establishments();

        establishments.setId( establishment.getId() );
        establishments.setName( establishment.getName() );
        establishments.setShortDescription( establishment.getShortDescription() );
        establishments.setLongDescription( establishment.getLongDescription() );
        establishments.setProfileImagePath( establishment.getProfileImagePath() );
        establishments.setFrontPageImagePath( establishment.getFrontPageImagePath() );
        establishments.setProfileMiniImagePath( establishment.getProfileMiniImagePath() );
        establishments.setFrontMiniPageImagePath( establishment.getFrontMiniPageImagePath() );
        establishments.setCreatedAt( establishment.getCreatedAt() );
        establishments.setUpdatedAt( establishment.getUpdatedAt() );
        establishments.setCategory( categoryToCategories( establishment.getCategory() ) );

        return establishments;
    }

    protected Cities cityToCities(City city) {
        if ( city == null ) {
            return null;
        }

        Cities cities = new Cities();

        cities.setId( city.getId() );
        cities.setName( city.getName() );

        return cities;
    }

    protected EstablishmentScores establishmentScoreToEstablishmentScores(EstablishmentScore establishmentScore) {
        if ( establishmentScore == null ) {
            return null;
        }

        EstablishmentScores establishmentScores = new EstablishmentScores();

        establishmentScores.setId( establishmentScore.getId() );
        establishmentScores.setClient( establishmentScore.getClient() );
        establishmentScores.setScore( establishmentScore.getScore() );

        return establishmentScores;
    }

    protected List<EstablishmentScores> establishmentScoreListToEstablishmentScoresList(List<EstablishmentScore> list) {
        if ( list == null ) {
            return null;
        }

        List<EstablishmentScores> list1 = new ArrayList<EstablishmentScores>( list.size() );
        for ( EstablishmentScore establishmentScore : list ) {
            list1.add( establishmentScoreToEstablishmentScores( establishmentScore ) );
        }

        return list1;
    }

    protected Days dayToDays(Day day) {
        if ( day == null ) {
            return null;
        }

        Days days = new Days();

        days.setId( day.getId() );
        days.setName( day.getName() );
        days.setOrderDay( day.getOrderDay() );

        return days;
    }

    protected EstablishmentOpenHours establishmentOpenHourToEstablishmentOpenHours(EstablishmentOpenHour establishmentOpenHour) {
        if ( establishmentOpenHour == null ) {
            return null;
        }

        EstablishmentOpenHours establishmentOpenHours = new EstablishmentOpenHours();

        establishmentOpenHours.setOpeningTime( establishmentOpenHour.getOpeningTime() );
        establishmentOpenHours.setClosingTime( establishmentOpenHour.getClosingTime() );
        establishmentOpenHours.setDay( dayToDays( establishmentOpenHour.getDay() ) );

        return establishmentOpenHours;
    }

    protected List<EstablishmentOpenHours> establishmentOpenHourListToEstablishmentOpenHoursList(List<EstablishmentOpenHour> list) {
        if ( list == null ) {
            return null;
        }

        List<EstablishmentOpenHours> list1 = new ArrayList<EstablishmentOpenHours>( list.size() );
        for ( EstablishmentOpenHour establishmentOpenHour : list ) {
            list1.add( establishmentOpenHourToEstablishmentOpenHours( establishmentOpenHour ) );
        }

        return list1;
    }

    protected Vouchers voucherToVouchers(Voucher voucher) {
        if ( voucher == null ) {
            return null;
        }

        Vouchers vouchers = new Vouchers();

        vouchers.setName( voucher.getName() );
        vouchers.setDescription( voucher.getDescription() );
        vouchers.setImagePath( voucher.getImagePath() );

        return vouchers;
    }

    protected VoucherEstablishmentBranches voucherEstablishmentBranchToVoucherEstablishmentBranches(VoucherEstablishmentBranch voucherEstablishmentBranch) {
        if ( voucherEstablishmentBranch == null ) {
            return null;
        }

        VoucherEstablishmentBranches voucherEstablishmentBranches = new VoucherEstablishmentBranches();

        voucherEstablishmentBranches.setId( voucherEstablishmentBranch.getId() );
        voucherEstablishmentBranches.setVoucher( voucherToVouchers( voucherEstablishmentBranch.getVoucher() ) );

        return voucherEstablishmentBranches;
    }

    protected List<VoucherEstablishmentBranches> voucherEstablishmentBranchListToVoucherEstablishmentBranchesList(List<VoucherEstablishmentBranch> list) {
        if ( list == null ) {
            return null;
        }

        List<VoucherEstablishmentBranches> list1 = new ArrayList<VoucherEstablishmentBranches>( list.size() );
        for ( VoucherEstablishmentBranch voucherEstablishmentBranch : list ) {
            list1.add( voucherEstablishmentBranchToVoucherEstablishmentBranches( voucherEstablishmentBranch ) );
        }

        return list1;
    }

    protected PromotionImages promotionImageToPromotionImages(PromotionImage promotionImage) {
        if ( promotionImage == null ) {
            return null;
        }

        PromotionImages promotionImages = new PromotionImages();

        promotionImages.setId( promotionImage.getId() );
        promotionImages.setImagePath( promotionImage.getImagePath() );
        promotionImages.setActive( promotionImage.getActive() );

        return promotionImages;
    }

    protected List<PromotionImages> promotionImageListToPromotionImagesList(List<PromotionImage> list) {
        if ( list == null ) {
            return null;
        }

        List<PromotionImages> list1 = new ArrayList<PromotionImages>( list.size() );
        for ( PromotionImage promotionImage : list ) {
            list1.add( promotionImageToPromotionImages( promotionImage ) );
        }

        return list1;
    }

    protected Promotions promotionToPromotions(Promotion promotion) {
        if ( promotion == null ) {
            return null;
        }

        Promotions promotions = new Promotions();

        promotions.setName( promotion.getName() );
        promotions.setDescription( promotion.getDescription() );
        promotions.setTerms( promotion.getTerms() );
        promotions.setStartDate( promotion.getStartDate() );
        promotions.setEndDate( promotion.getEndDate() );
        promotions.setPromotionImages( promotionImageListToPromotionImagesList( promotion.getPromotionImages() ) );

        return promotions;
    }

    protected List<Promotions> promotionListToPromotionsList(List<Promotion> list) {
        if ( list == null ) {
            return null;
        }

        List<Promotions> list1 = new ArrayList<Promotions>( list.size() );
        for ( Promotion promotion : list ) {
            list1.add( promotionToPromotions( promotion ) );
        }

        return list1;
    }
}
