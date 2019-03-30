package request;

import java.util.ArrayList;
import java.util.Random;

public class RequestsGenerator {
    private static int randomInt(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static ArrayList<Request> getSeries(int seriesLenght, int maxDiskLocation, int maxArrivalTime) {
        ArrayList<Request> res = new ArrayList<>();

        int zeroArrivalTimeRequests = RequestsGenerator.randomInt(0, seriesLenght / 3);
        for (int i = 0; i < seriesLenght; i++) {
            int diskLocation = RequestsGenerator.randomInt(1, maxDiskLocation);
            int arrivalTime = i <= zeroArrivalTimeRequests ? 0 : RequestsGenerator.randomInt(0, maxArrivalTime);
            res.add(new Request(i, diskLocation, arrivalTime));
        }

        return res;
    }
}
