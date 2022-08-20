package instatus;

import io.restassured.response.Response;
import runner.BaseRunner;

import java.util.ArrayList;
import java.util.List;

public final class StatusPage extends BaseRunner<StatusPage> {
    private final String payload = "/v1/pages";

    private final StatusPageResponse statusPagesResponses;

//    public StatusPage() {
//        statusPagesResponses = getGson().fromJson(
//                responseGET(payload).asString(), getCollectionsType(StatusPageResponse.class));
//    }

    public StatusPage() {
        statusPagesResponses = getGson().fromJson(
                responseGET(payload).asString().substring(1, responseGET("/v1/pages").asString().length() - 1),
                StatusPageResponse.class);
    }

    public boolean isResponseReceived() {
        return statusPagesResponses != null;
    }

    public String getListResponse() {
        return statusPagesResponses.id;
    }
}
