package request;

public class Request {
    private int id, arrivalTime, diskLocation;

    public Request(int id, int diskLocation, int arrivalTime) {
        this.id = id;
        this.diskLocation = diskLocation;
        this.arrivalTime = arrivalTime;
    }


    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getDiskLocation() {
        return diskLocation;
    }

    public Request clone() {
        return new Request(id, diskLocation, arrivalTime);
    }
}

