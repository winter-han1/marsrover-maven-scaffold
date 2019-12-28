public class RoverController {
    private Rover rover;

    public RoverController(Rover rover) {
        this.rover = rover;
    }

    public String excute(String mission) {
        // 10,10,5,5,E,M,L,M,R
        String[] commands = mission.split(",");

        Integer area_weight = Integer.valueOf(commands[0]);
        Integer area_height = Integer.valueOf(commands[1]);
        Integer rover_x = Integer.valueOf(commands[2]);
        Integer rover_y = Integer.valueOf(commands[3]);
        rover.land(new Area(area_weight, area_height), rover_x, rover_y, commands[4]);

        for (int i = 5; i < commands.length; i++) {
            executeOneCommand(commands[i]);
        }

        return this.rover.getPosition();
    }

    public void executeOneCommand(String command) {
        if (command.equals("M")) {
            rover.move();
        } else if (command.equals("L")) {
            rover.turnLeft();
        } else if (command.equals("R")) {
            rover.turnRight();
        }
    }
}
