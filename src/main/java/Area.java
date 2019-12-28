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

    public Integer getWidth() {
        return this.width;
    }

    public boolean containHeight(int position_y) {
        return height >= position_y;
    }

    public Integer getHeight() {
        return this.height;
    }
}
