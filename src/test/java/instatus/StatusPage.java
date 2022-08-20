package instatus;

import io.restassured.response.Response;
import runner.BaseRunner;

import java.util.ArrayList;
import java.util.List;

public final class StatusPage extends BaseRunner<StatusPage> {
    private final String payload = "/v1/pages";

    private final List<StatusPageResponse> statusPagesResponses;

//    public StatusPage() {
//        statusPagesResponses = getGson().fromJson(
//                responseGET(payload).asString(), getCollectionsType(StatusPageResponse.class));
//    }
//experimental
    public StatusPage() {
        statusPagesResponses = getJSON(responseGET(payload));
    }

    public boolean isResponseReceived() {
        return statusPagesResponses != null;
    }

    public String getListResponse() {
        return statusPagesResponses.get(0).id;
    }
// experimental
    public String getExpResponse() {
        return statusPagesResponses.get(0).id;
    }
}
