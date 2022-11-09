package ladder.view;

import java.util.List;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Name;
import ladder.domain.Point;

public class OutputView {

    private final static String POINT = "|";
    private final static String LINK = "-----";
    private final static String UNLINK = "     ";
    private final static int PLACE = 5;
    private final static StringBuilder STRING_BUILDER = new StringBuilder();

    private OutputView() {
    }

    public static void printResult(final Ladder ladder) {
        System.out.println("실행결과");
        System.out.println("-".repeat(10) + "\n");
        printParticipants(ladder.getParticipants());
        System.out.println();
        ladder.getLines().forEach(OutputView::printLine);
    }

    private static void printParticipants(final List<Name> participants) {
        participants.forEach(p -> {
            System.out.print(" ".repeat(PLACE - p.toString().length()));
            System.out.print(p + " ");
        });
    }

    private static void printLine(final Line line) {
        STRING_BUILDER.setLength(0);
        STRING_BUILDER.append("\t\t");
        line.getPoints().forEach(point -> {
            STRING_BUILDER.append(POINT);
            STRING_BUILDER.append(checkLinked(point));
        });
        System.out.println(STRING_BUILDER);
    }

    private static String checkLinked(final Point point) {
        if (point.isLinked()) {
            return LINK;
        }

        return UNLINK;
    }
}
