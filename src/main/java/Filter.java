import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Filter {
  String name_like;
  String invite_type;
  List<String> groupIds;
  List<String> learnerIds;
  Map<String, List<String>> profiles;
  List<String> linkStatus;
}
