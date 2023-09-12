package py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.establishments.entities.Establishments;

@Repository
public interface EstablishmentsRepository extends CrudRepository<Establishments, String> {

  @Query("SELECT e FROM Establishments e " +
      "WHERE (:name IS NULL OR e.name LIKE %:name%) " +
      "AND (:categoryId IS NULL OR e.category.id = :categoryId) " +
      "ORDER BY e.createdAt")
  List<Establishments> findEstablishmentsBy(@Param("name") String name,
                                            @Param("categoryId") String categoryId);
  
  @Query(value = "SELECT eb FROM EstablishmentBranches eb " +
      "WHERE (:latitude IS NULL OR eb.latitude = :latitude) " +
      "AND (:longitude IS NULL OR eb.longitude = :longitude) ",
      countQuery = "SELECT COUNT(eb.id) FROM EstablishmentBranches eb " +
          "WHERE (:latitude IS NULL OR eb.latitude = :latitude) " +
          "AND (:longitude IS NULL OR eb.longitude = :longitude) ")
  Page<Establishments> findEstablishmentsNearBy(@Param("latitude") String latitude,
                                                @Param("longitude") String longitude,
                                                Pageable pageable);
}

