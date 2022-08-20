package instatus;

import runner.BaseRunner;

import java.util.ArrayList;
import java.util.List;

public final class StatusPage extends BaseRunner<StatusPage> {
    private final String payload = "/v1/pages";

    private final ArrayList<StatusPageResponse> statusPagesResponses;

    public StatusPage() {
        statusPagesResponses = getGson().fromJson(
                responseGET(payload).asString(), getCollectionsType(StatusPageResponse.class));
    }

    public boolean isResponseReceived() {
        return statusPagesResponses != null;
    }

    public String getListResponse() {
        return statusPagesResponses.get(0).id;
    }
}
