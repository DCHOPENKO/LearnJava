package homeworks.basic_tasks.patterns.template;

public abstract class FigureTemplate {

    public final void buildElements() {
        buildTriangle();
        System.out.println();
        buildSecondElement();
        System.out.println();
        buildTriangle();
    }

    public abstract void buildSecondElement();

    private void buildTriangle() {
        System.out.println("          *\n" +
                "         ***\n" +
                "        *****\n" +
                "       *******\n" +
                "      *********");
    }
}


