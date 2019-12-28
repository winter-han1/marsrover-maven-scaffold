import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.api.Assertions.assertThat;

public class MarsRoverTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_warning_when_land_out_of_area_width() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("x=20 is out of width 10");
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 20, 30, "E");
    }

    @Test
    public void should_warning_when_land_out_of_area_height() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("y=30 is out of height 10");
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 2, 30, "E");
    }

    @Test
    public void should_warning_when_more_out_of_area_width_when_direction_to_east() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("out of area width 10, can't more");
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 10, 5, "E");
        rover.move();
    }

    @Test
    public void should_warning_when_more_out_of_area_width_when_direction_to_west() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("out of area width zero, can't more");
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 0, 5, "W");
        rover.move();
    }

    @Test
    public void should_warning_when_more_out_of_area_height_when_direction_to_north() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("out of area height 10, can't more");
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 2, 10, "N");
        rover.move();
    }

    @Test
    public void should_warning_when_more_out_of_area_height_when_direction_to_south() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("out of area height zero, can't more");
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 2, 0, "S");
        rover.move();
    }

    @Test
    public void should_land_the_rover_on_area() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, "E");
        String position = rover.getPosition();
        assertThat(position).isEqualTo("55E");

    }

    @Test
    public void should_move_forward_with_direction_to_east() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, "E");
        rover.move();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("65E");
    }
    @Test
    public void should_move_forward_with_direction_to_south() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, "S");
        rover.move();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("54S");
    }
    @Test
    public void should_move_forward_with_direction_to_west() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, "W");
        rover.move();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("45W");
    }
    @Test
    public void should_move_forward_with_direction_to_north() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, "N");
        rover.move();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("56N");
    }

    @Test
    public void should_change_direction_left() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, "E");
        rover.turnLeft();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("55N");

        rover.turnLeft();
        position = rover.getPosition();
        assertThat(position).isEqualTo("55W");

        rover.turnLeft();
        position = rover.getPosition();
        assertThat(position).isEqualTo("55S");

        rover.turnLeft();
        position = rover.getPosition();
        assertThat(position).isEqualTo("55E");

    }

    @Test
    public void should_change_direction_right() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, "E");
        rover.turnRight();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("55S");

        rover.turnRight();
        position = rover.getPosition();
        assertThat(position).isEqualTo("55W");

        rover.turnRight();
        position = rover.getPosition();
        assertThat(position).isEqualTo("55N");

        rover.turnRight();
        position = rover.getPosition();
        assertThat(position).isEqualTo("55E");

    }

    @Test
    public void should_execute_batch_commonds() {
        Rover rover = new Rover();
        RoverController roverController = new RoverController(rover);
        String mission = "10,10,5,5,E,M,L,M,R";
        String position = roverController.excute(mission);
        assertThat(position).isEqualTo("66E");

    }

}