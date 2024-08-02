package ClassAndObject.userInterface;

import ClassAndObject.model.Color;
import ClassAndObject.model.Line;
import ClassAndObject.model.Style;

public class UserInterface {

    private static final String STR_PIROS = "\u001B[31m";
    private static final String STR_KÉK = "\u001B[34m";
    private static final String STR_ZÖLD = "\u001B[32m";

    private static final String CHR_DUPLA = "=";
    private static final String CHR_PONT = ".";
    private static final String CHR_SZIMPLA = "-";

    public void draw(Line line) {

        String colorCode = switch (line.getColor()) {
            case PIROS -> STR_PIROS;
            case KÉK -> STR_KÉK;
            case ZÖLD -> STR_ZÖLD;
            default -> "\u001B[0m";
        };

        String styleChar = switch (line.getStyle()) {
            case DUPLA -> CHR_DUPLA;
            case PONT -> CHR_PONT;
            default -> CHR_SZIMPLA;
        };

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < line.getOffset(); i++) {
            output.append(" ");
        }

        for (int i = 0; i < line.getLength(); i++) {
            output.append(styleChar);
        }

        System.out.println(line);
        System.out.println(colorCode + output.toString() + "\u001B[0m");

    }

    public void runTests() {
        testValidLine();
        testLineWithOffset();
        testLineWithDifferentColorAndStyle();
        testLineWithZeroOffsetAndDifferentStyle();
        testInvalidLineCreation();
    }

    public void testValidLine() {
        Line line1 = new Line(3, Color.PIROS, Style.DUPLA);
        draw(line1);
        assert line1.getLength() == 3;
        assert line1.getColor() == Color.PIROS;
        assert line1.getStyle() == Style.DUPLA;
        assert line1.getOffset() == 0;
    }

    public void testLineWithOffset() {
        Line line2 = new Line(3, 2, Color.PIROS, Style.DUPLA);
        draw(line2);
        assert line2.getLength() == 3;
        assert line2.getColor() == Color.PIROS;
        assert line2.getStyle() == Style.DUPLA;
        assert line2.getOffset() == 2;
    }

    public void testLineWithDifferentColorAndStyle() {
        Line line3 = new Line(2, 3, Color.KÉK, Style.SZIMPLA);
        draw(line3);
        assert line3.getLength() == 2;
        assert line3.getColor() == Color.KÉK;
        assert line3.getStyle() == Style.SZIMPLA;
        assert line3.getOffset() == 3;
    }

    public void testLineWithZeroOffsetAndDifferentStyle() {
        Line line4 = new Line(5, 0, Color.ZÖLD, Style.PONT);
        draw(line4);
        assert line4.getLength() == 5;
        assert line4.getColor() == Color.ZÖLD;
        assert line4.getStyle() == Style.PONT;
        assert line4.getOffset() == 0;
    }

    public void testInvalidLineCreation() {
        try {
            Line invalidLine = new Line(0, Color.PIROS, Style.DUPLA);
            assert false : "IllegalArgumentException kivétel, ha a vonal hossza 1-nél kisebb";
        } catch (IllegalArgumentException e) {
            System.out.println("Egy vonal nem jött létre, mert nem létező a hossz!");
            assert e.getMessage().equals("A vonal hossza nem lehet kisebb, mint 1");
        }
    }
}
