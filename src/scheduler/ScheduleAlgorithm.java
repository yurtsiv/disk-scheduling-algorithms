package scheduler;

import request.Request;
import java.util.ArrayList;

public interface ScheduleAlgorithm {
    void serve(ArrayList<Request> activeRequests, int currentHeadPosition, ArrayList<Integer> headPath);
}
