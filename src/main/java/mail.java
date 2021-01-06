import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.CaseFormat;
import com.google.protobuf.InvalidProtocolBufferException;
import com.mindtickle.api.governance.workflows.Workflows;
import com.google.protobuf.util.JsonFormat;

import java.util.ArrayList;
import java.util.List;


public class mail {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws InvalidProtocolBufferException, JsonProcessingException {
//        Workflows.MirrorModuleRequest.Builder builder = Workflows.MirrorModuleRequest.newBuilder();
//        ObjectMapper mapper = new ObjectMapper();
//        String s = "{\"moduleId\":\"johnDoe\"}";
//        JsonFormat.parser().merge(s, builder);
//        Workflows.MirrorModuleRequest req = builder.build();
//        System.out.println(s + req.getModuleId());
//        System.out.println(JsonFormat.printer().preservingProtoFieldNames().print(req));

//        String x = "{\n" +
//                "  \"moduleIds\":[\n" +
//                "    \"1332209487453153569\"],\n" +
//                "  \"inviteType\":\"SELECTIVE\",\n" +
//                "  \"notifyLearners\":true,\n" +
//                "  \"learners\":{\n" +
//                "    \"learnerIds\":[\n" +
//                "      \"12396e4177e97000\"],\n" +
//                "    \"groupIds\":[\n" +
//                "    ],\n" +
//                "    \"filters\":{\n" +
//                "      \"isAllSelected\":true,\n" +
//                "      \"profiles\":\n" +
//                "        {\n" +
//                "          \"a_0\":[\n" +
//                "            \"My Profile\"]\n" +
//                "        }\n" +
//                "    }\n" +
//                "  }\n" +
//                "}";
//
//
//        BulkPublishRequest bulkPublishRequest =
//                mapper.readValue(x, BulkPublishRequest.class);
//
//        System.out.println(bulkPublishRequest);

        List<String> learnerStatus = new ArrayList<>();
        learnerStatus.add("ACTIVE");
        learnerStatus.add("ADDED");

        ObjectNode query = mapper.createObjectNode();
        query.set("op", mapper.createArrayNode().add("get_learners_details"));

        ObjectNode body = mapper.createObjectNode();
        ObjectNode learnersFilter = mapper.createObjectNode();
        learnersFilter.put("type", "status");
        learnersFilter.set("value", mapper.convertValue(learnerStatus, JsonNode.class));
        ArrayNode currFilters = mapper.createArrayNode();
        currFilters.add(learnersFilter);
        body.set("currFilter", currFilters);
        body.set("appliedFilters", mapper.createArrayNode());
        body.put("count", 0);
        body.put("start", 0);

        System.out.println(body.toString());
    }
}
