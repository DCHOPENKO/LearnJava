package homeworks.basic_tasks.patterns.template;

import java.util.ArrayList;
import java.util.List;

class ForTest {

    public static void main(String[] args) {

        List<FigureTemplate> figures = new ArrayList<>();
        FigureTemplate first = new FirstFigure();
        FigureTemplate second = new SecondFigure();
        FigureTemplate third = new ThirdFigure();
        figures.add(first);
        figures.add(second);
        figures.add(third);

        for (FigureTemplate figure : figures) {
            figure.buildElements();
        }
    }

}
