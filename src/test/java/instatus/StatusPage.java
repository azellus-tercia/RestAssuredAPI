package instatus;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import io.restassured.response.Response;
import runner.BaseRunner;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.List;

public final class StatusPage extends BaseRunner<StatusPage> {
    private final String payload = "/v1/pages";

    private final List<StatusPageResponse> statusPagesResponses;

    public StatusPage() {
        statusPagesResponses = getGson().fromJson(
                responseGET(payload).getBody().asString(), new TypeToken<ArrayList<StatusPageResponse>>(){}.getType());
    }
//experimental
//    public StatusPage() {
//        statusPagesResponses = getJSON(responseGET(payload));
//    }

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
