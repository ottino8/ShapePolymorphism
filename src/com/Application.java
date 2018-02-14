package com;

public class Application {
    private static InputValidator validator;
    private UserShapes shapes;
    private ShapeFactory factory;

    public Application(InputValidator validator, UserShapes shapes, ShapeFactory factory){
        this.validator = validator;
        this.shapes = shapes;
        this.factory = factory;
        menu();

    }

    private void menu(){
        displayOptions();
        chooseOption(shapes);
    }

    private void displayOptions(){
        System.out.println("\n\nSelect one of the options: \n1) Insert New shape.\n2) Get Coordinates of the inputted shapes.\n3) Get Areas of inputted shapes. \n4) Get Volumes of inputted shapes. \n5) Get all info of inputted shapes. \n6) Last Item information. \n7) Exit from the program.");
    }

    private void chooseOption(UserShapes shapes){
        Option option = validator.getOption();
        int numberOfShape;
        while (option != Option.EXIT){
            switch (option){
                case CREATE:
                    float[] floatArgs = validator.newFloatArgs();
                    shapes.addShape(factory.makeShape(floatArgs));
                    break;
                case COORDS:
                    numberOfShape = 0;
                    for (Shape shape: shapes) {
                        numberOfShape++;
                        display("The shape number "+ numberOfShape+ " has coordinate X: " + shape.getX() + "and Y: " + shape.getY());
                    }
                    break;
                case AREA:
                    numberOfShape = 0;
                    for (Shape shape: shapes) {
                        numberOfShape++;
                        display("The shape number "+ numberOfShape+ " has Area " + shape.getArea());
                    }
                    break;
                case INFOS:
                    numberOfShape = 0;
                    for (Shape shape: shapes) {
                        numberOfShape++;
                        display("At position "+ numberOfShape+ shape.getAllInfo());
                    }
                    break;
                case VOLUME:
                    numberOfShape = 0;
                    for (Shape shape: shapes) {
                        numberOfShape++;
                        display("The shape number "+ numberOfShape+ " has Volume " + shape.getVolume());
                    }
                    break;
                case LAST:
                    display("The last inputted shape\n"+shapes.getLast().getAllInfo());
                    break;
                case EXIT:
                    System.exit(0);
                    break;
                default:
                    display("Your choice is not valid choose from the menu again");
                    break;
            }
            displayOptions();
            option = validator.getOption();
        }
    }

    private void display(String str){
        System.out.println(str);
    }
}
