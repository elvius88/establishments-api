package py.com.jaha.api.establishments.domain.models.establishments;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Establishment implements Serializable {

  private String id;
  private String name;
  private String shortDescription;
  private String longDescription;
  private String profileImagePath;
  private String frontPageImagePath;
  private String profileMiniImagePath;
  private String frontMiniPageImagePath;
  private Category category;
  private OffsetDateTime createdAt;
  private OffsetDateTime updatedAt;
}
