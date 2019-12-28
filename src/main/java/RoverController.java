public class RoverController {
    private Rover rover;

    public RoverController(Rover rover) {
        this.rover = rover;
    }

    public String excute(String mission) {
        // 10,10,5,5,E,M,L,M,R


        return rover.getPosition();
    }
}
