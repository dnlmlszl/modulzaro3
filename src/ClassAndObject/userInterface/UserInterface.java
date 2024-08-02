package ClassAndObject.userInterface;

import ClassAndObject.model.Line;

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
}
