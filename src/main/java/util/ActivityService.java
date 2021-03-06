package util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.*;

import static io.restassured.RestAssured.given;

public class ActivityService {

    Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    private static String getTesterStaffId(String token) {
        JWT parsedJWT = new JWT();
        DecodedJWT decodedJWT = parsedJWT.decodeJwt(token);
        return decodedJWT.getClaims().get("oid").asString();
    }

    public void closeCurrentUserActivity(String token) {

        logger.info("closing user's activity");
        String getStaffId = getTesterStaffId(token);

        List<String> openActivitiesIdforUser = getAllOpenActivitiesForTesterStaffId(getStaffId,token);

        if(openActivitiesIdforUser != null){
            for(String activityIdToClose: openActivitiesIdforUser){
                closeOpenActivityById(activityIdToClose,token);
            }
        }else{
           logger.info("No open activity to close for StaffId: " + getStaffId);
        }
    }

    private List<String> getAllOpenActivitiesForTesterStaffId(String testerStaffId, String token) {
        List<String> activityIds = null;

        for (int i =0; i<3; i++) {
            Response response = given().filters(new BasePathFilter(token))
                    .contentType(ContentType.JSON)
                    .queryParam("activityType", "visit")
                    .queryParam("fromStartTime", LocalDateTime.now().minusDays(90).toString())
                    .queryParam("testerStaffId", testerStaffId)
                    .get("/activities/details");

            if (response.getStatusCode() != 200) {
                logger.info("This should not have happened: " + response.toString());
            } else {
                if (!response.getBody().asString().contains("No resources match the search criteria")) {
                    activityIds = response.jsonPath().getList("findAll { it.endTime == null}.id");
                }
                break;
            }
        }
        return activityIds;
    }

    private void closeOpenActivityById(String id, String token) {

        for (int i =0; i<3; i++) {
            Response response = given().filters(new BasePathFilter(token))
                    .contentType(ContentType.JSON)
                    .pathParam("id", id)
                    .put("/activities/{id}/end");
            if (response.getStatusCode() != 200) {
                logger.info("This should not have happened: " + response.toString());
            } else {
                break;
            }
        }
    }
}
