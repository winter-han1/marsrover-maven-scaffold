public class Area {
    private int width;
    private int height;

    public Area(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean containWidth(int position_x) {
        return width >= position_x;
    }
}
