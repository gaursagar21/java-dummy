import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BulkPublishRequest {
  List<String> moduleIds;
  InviteOptions inviteType;
  Boolean notifyLearners;
  LearnerSelection learners;
  Object appliedFilters;
}
