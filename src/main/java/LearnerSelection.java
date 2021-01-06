import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LearnerSelection {
  List<String> learnerIds;
  List<String> groupIds;
  Filter filters;
  Boolean isAllSelected;
}

/** { learnerIds: [""], groupIds: [""], filters: { name_like, profiles : {a: [], b:[]} } } */
