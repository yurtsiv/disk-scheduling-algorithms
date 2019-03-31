package scheduler;

import request.Request;

import java.util.ArrayList;

public class FCFS implements ScheduleAlgorithm {
    public Request getNextRequest(ArrayList<Request> activeRequests, int currentHeadPosition, ArrayList<Integer> headPath) {
        return activeRequests.get(0);
    }
}
