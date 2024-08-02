package ClassAndObject.model;

public class Line {
    private Integer length;
    private Integer offset;
    private Color color;
    private Style style;

    public Line(Integer length, Color color, Style style) {
        this(length, 0, color, style);
    }

    public Line(Integer length, Integer offset, Color color, Style style) {
        if (length < 1) throw new IllegalArgumentException("A hossznak legalább 1-nek kell lennie.");
        if (offset < 0) throw new IllegalArgumentException("Az eltolásnak pozitivnak kell lennie..");

        this.length = length;
        this.offset = offset;
        this.color = color;
        this.style = style;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Vonal {" +
                "hossz=" + length +
                ", eltolás=" + offset +
                ", szin=" + color +
                ", stilus=" + style +
                '}';
    }
}
