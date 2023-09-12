package py.com.jaha.api.establishments.domain.usecases.establishments.mappers;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.util.CollectionUtils;
import py.com.jaha.api.establishments.domain.commands.establishments.EstablishmentOpenHourResponse;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentDetailsResponse;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentNearbyResponse;
import py.com.jaha.api.establishments.domain.commands.establishments.GetEstablishmentResponse;
import py.com.jaha.api.establishments.domain.commands.establishments.PromotionResponse;
import py.com.jaha.api.establishments.domain.commands.establishments.VoucherResponse;
import py.com.jaha.api.establishments.domain.models.establishments.EstablishmentBranch;
import py.com.jaha.api.establishments.domain.models.establishments.EstablishmentOpenHour;
import py.com.jaha.api.establishments.domain.models.establishments.EstablishmentScore;
import py.com.jaha.api.establishments.domain.models.establishments.Promotion;
import py.com.jaha.api.establishments.domain.models.establishments.VoucherEstablishmentBranch;

@Mapper
public interface GetEstablishmentResponseMapper {

  GetEstablishmentResponseMapper INSTANCE = Mappers.getMapper(GetEstablishmentResponseMapper.class);

  @Mapping(target = "id", source = "establishment.id")
  @Mapping(target = "branchId", source = "id")
  @Mapping(target = "name", source = "establishment.name")
  @Mapping(target = "category", source = "establishment.category.name")
  @Mapping(target = "score", source = "establishmentScores", qualifiedByName = "scoreMapping")
  @Mapping(target = "latitude", source = "latitude")
  @Mapping(target = "longitude", source = "longitude")
  @Mapping(target = "address", source = "address")
  @Mapping(target = "city", source = "city.name")
  @Mapping(target = "profileImagePath", source = "establishment.profileImagePath")
  @Mapping(target = "frontPageImagePath", source = "establishment.frontPageImagePath")
  @Mapping(target = "shortDescription", source = "establishment.shortDescription")
  @Mapping(target = "promotions", source = "promotions", qualifiedByName = "promotionsEstablishmentMapping")
  @Mapping(target = "vouchers", source = "voucherEstablishmentBranches", qualifiedByName = "voucherEstablishmentMapping")
  @Mapping(target = "openingHours", source = "openHours", qualifiedByName = "openingHourByTodayMapping")
  GetEstablishmentDetailsResponse toGetEstablishmentDetailsResponse(EstablishmentBranch establishment);

  @Mapping(target = "id", source = "establishment.id")
  @Mapping(target = "branchId", source = "id")
  @Mapping(target = "name", source = "establishment.name")
  @Mapping(target = "category", source = "establishment.category.name")
  @Mapping(target = "score", source = "establishmentScores", qualifiedByName = "scoreMapping")
  @Mapping(target = "latitude", source = "latitude")
  @Mapping(target = "longitude", source = "longitude")
  @Mapping(target = "address", source = "address")
  @Mapping(target = "city", source = "city.name")
  GetEstablishmentNearbyResponse toGetEstablishmentBranchResponse(EstablishmentBranch establishmentBranch);

  @Mapping(target = "id", source = "establishment.id")
  @Mapping(target = "branchId", source = "id")
  @Mapping(target = "name", source = "establishment.name")
  @Mapping(target = "category", source = "establishment.category.name")
  @Mapping(target = "score", source = "establishmentScores", qualifiedByName = "scoreMapping")
  @Mapping(target = "latitude", source = "latitude")
  @Mapping(target = "longitude", source = "longitude")
  @Mapping(target = "address", source = "address")
  @Mapping(target = "city", source = "city.name")
  @Named(value = "getEstablishmentResponse")
  GetEstablishmentResponse toGetEstablishmentResponse(EstablishmentBranch establishment);

  @IterableMapping(qualifiedByName = "getEstablishmentResponse")
  List<GetEstablishmentResponse> toGetEstablishmentResponseList(List<EstablishmentBranch> establishments);

  default Page<GetEstablishmentNearbyResponse> toGetEstablishmentsPageableResponse(Page<EstablishmentBranch> establishmentPage) {
    return new PageImpl<>(establishmentPage.stream()
        .map(GetEstablishmentResponseMapper.INSTANCE::toGetEstablishmentBranchResponse)
        .collect(Collectors.toList()),
        establishmentPage.getPageable(),
        establishmentPage.getTotalElements());
  }

  @Named("scoreMapping")
  static Integer toScoreMapping(List<EstablishmentScore> establishmentScores) {
    AtomicInteger sum = new AtomicInteger(0);
    establishmentScores.forEach(establishmentScore -> sum.set(sum.get() + establishmentScore.getScore()));

    return sum.get() / Optional.of(establishmentScores)
        .filter(scores -> !CollectionUtils.isEmpty(scores)).map(List::size).orElse(1);
  }

  @Named("openingHourByTodayMapping")
  static EstablishmentOpenHourResponse toOpeningHourByTodayMapping(List<EstablishmentOpenHour> establishmentOpenHours) {
    EstablishmentOpenHour openHour = establishmentOpenHours.stream()
        .filter(establishmentOpenHour -> establishmentOpenHour.getDay().getOrderDay().equals(OffsetDateTime.now().getDayOfWeek().getValue()))
        .findFirst().orElse(new EstablishmentOpenHour());
    return EstablishmentOpenHourResponse.builder().openingTime(openHour.getOpeningTime()).closingTime(openHour.getClosingTime()).build();
  }

  @Named("voucherEstablishmentMapping")
  static List<VoucherResponse> toVoucherEstablishmentMapping(List<VoucherEstablishmentBranch> voucherEstablishmentBranches) {
    List<VoucherResponse> vouchers = new ArrayList<>();
    for (var voucherEstablishmentBranch : voucherEstablishmentBranches) {
      vouchers.add(VoucherResponse.builder()
          .name(voucherEstablishmentBranch.getVoucher().getName())
          .description(voucherEstablishmentBranch.getVoucher().getDescription())
          .imagePath(voucherEstablishmentBranch.getVoucher().getImagePath())
          .build());
    }
    return vouchers;
  }

  @Named("promotionsEstablishmentMapping")
  static List<PromotionResponse> toPromotionsEstablishmentMapping(List<Promotion> promotions) {
    List<PromotionResponse> responseList = new ArrayList<>();
    for (var promotion : promotions) {
      responseList.add(PromotionResponse.builder()
          .name(promotion.getName())
          .description(promotion.getDescription())
          .terms(promotion.getTerms())
          .startDate(promotion.getStartDate())
          .endDate(promotion.getEndDate())
          .imagePath(Objects.requireNonNull(promotion.getPromotionImages().stream()
              .filter(promotionImage -> Boolean.TRUE.equals(promotionImage.getActive()))
              .findFirst().orElse(null)).getImagePath())
          .build());
    }
    return responseList;
  }
}
