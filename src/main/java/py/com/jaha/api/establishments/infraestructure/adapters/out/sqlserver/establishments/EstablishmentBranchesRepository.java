package py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.EstablishmentBranches;

@Repository
public interface EstablishmentBranchesRepository extends CrudRepository<EstablishmentBranches, String> {


  @Query("SELECT eb FROM EstablishmentBranches eb " +
      "WHERE (:name IS NULL OR eb.establishment.name LIKE %:name%) " +
      "AND (:categoryId IS NULL OR eb.establishment.category.id = :categoryId) " +
      "AND (:establishmentId IS NULL OR eb.establishment.id = :establishmentId) " +
      "ORDER BY eb.establishment.createdAt")
  List<EstablishmentBranches> findEstablishmentsBy(@Param("name") String name,
                                                   @Param("categoryId") String categoryId,
                                                   @Param("establishmentId") String establishmentId);

  @Query(value = "SELECT eb FROM EstablishmentBranches eb " +
      "WHERE (:latitude IS NULL OR eb.latitude = :latitude) " +
      "AND (:longitude IS NULL OR eb.longitude = :longitude) ",
      countQuery = "SELECT COUNT(eb.id) FROM EstablishmentBranches eb " +
          "WHERE (:latitude IS NULL OR eb.latitude = :latitude) " +
          "AND (:longitude IS NULL OR eb.longitude = :longitude) ")
  Page<EstablishmentBranches> findEstablishmentBranchesNearBy(@Param("latitude") String latitude,
                                                              @Param("longitude") String longitude,
                                                              Pageable pageable);

  @Query(value = "SELECT eb FROM EstablishmentBranches eb " +
      "WHERE eb.id = :branchId ")
  EstablishmentBranches findEstablishmentByBranchId(@Param("branchId") String branchId);
}

