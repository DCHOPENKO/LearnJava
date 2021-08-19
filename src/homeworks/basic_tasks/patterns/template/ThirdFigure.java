package homeworks.basic_tasks.patterns.template;

class ThirdFigure extends FigureTemplate {

    @Override
    public void buildSecondElement() {
        System.out.println("         ***\n" +
                "         ***\n" +
                "      **********\n" +
                "      **********\n" +
                "         ***\n" +
                "         ***");
    }
}
