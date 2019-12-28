public class Rover {

    private Area area;
    private int position_x;
    private int position_y;
    private String direction;


    public void land(Area area, int position_x, int position_y, String direction) {
        if (!area.containWidth(position_x)) {
            throw new IllegalArgumentException("x=" + position_x + " is out of width " + area.getWidth());
        }
        if (!area.containHeight(position_y)) {
            throw new IllegalArgumentException("y=" + position_y + " is out of height " + area.getHeight());
        }

        this.area = area;
        this.position_x = position_x;
        this.position_y = position_y;
        this.direction = direction;
    }

    public String getPosition() {
        return "" + position_x + position_y + direction;
    }

    public void move() {
        switch (this.direction) {
            case "E":
                this.position_x += 1;
                break;
            case "S":
                this.position_y -= 1;
                break;
            case "W":
                this.position_x -= 1;
                break;
            case "N":
                this.position_y += 1;
                break;
            default:
                break;
        }
    }

    public void turnLeft() {
        switch (this.direction) {
            case "E":
                this.direction = "N";
                break;
            case "S":
                this.direction = "E";
                break;
            case "W":
                this.direction = "S";
                break;
            case "N":
                this.direction = "W";
                break;
            default:
                break;
        }
    }

    public void turnRight() {
        switch (this.direction) {
            case "E":
                this.direction = "S";
                break;
            case "S":
                this.direction = "W";
                break;
            case "W":
                this.direction = "N";
                break;
            case "N":
                this.direction = "E";
                break;
            default:
                break;
        }
    }
}
