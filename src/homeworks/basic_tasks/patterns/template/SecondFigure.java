package homeworks.basic_tasks.patterns.template;

class SecondFigure extends FigureTemplate {

    @Override
    public void buildSecondElement() {
        System.out.println("          *******\n" +
                "          *******\n" +
                "          *******\n" +
                "          *******");
    }
}
