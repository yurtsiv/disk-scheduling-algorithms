package request;

import util.RandomNums;

import java.util.ArrayList;

public class RequestsGenerator {
    public static ArrayList<Request> getSeries(int seriesLenght, int maxDiskLocation, int maxArrivalTime) {
        ArrayList<Request> res = new ArrayList<>();

        int zeroArrivalTimeRequests = RandomNums.randomInt(0, seriesLenght / 3);
        for (int i = 0; i < seriesLenght; i++) {
            int diskLocation = RandomNums.randomInt(1, maxDiskLocation);
            int arrivalTime = i <= zeroArrivalTimeRequests ? 0 : RandomNums.randomInt(0, maxArrivalTime);
            res.add(new Request(i, diskLocation, arrivalTime));
        }

        return res;
    }
}
