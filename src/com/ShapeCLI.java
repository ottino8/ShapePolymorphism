package com;

import static com.ShapeFactory.aShapeFactory;

public class ShapeCLI {

    private static InputValidator validator = new InputValidator();


    private void menu(UserShapes shapes){
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
                    shapes.addShape(aShapeFactory().makeShape(floatArgs));
                    break;
                case COORDS:
                    numberOfShape = 0;
                    for (Shape shape: shapes) {
                        numberOfShape++;
                        display("The shape number "+ numberOfShape+ "has coordinate X: " + shape.getX() + "and Y: " + shape.getY());
                    }
                    break;
                case AREA:
                    numberOfShape = 0;
                    for (Shape shape: shapes) {
                        numberOfShape++;
                        display("The shape number "+ numberOfShape+ "has Area " + shape.getArea());
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
                        display("The shape number "+ numberOfShape+ "has Volume " + shape.getVolume());
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



    public static void main(String[] args) {
        ShapeCLI cli = new ShapeCLI();
        ShapeFactory factory = aShapeFactory();
        InputValidator validator = new InputValidator();


        // Set up user shapes
        UserShapes shapes = new UserShapes();

        // Parse and validate arguments
        float[] floatArgs = validator.validateArgs(args);
        shapes.addShape(factory.makeShape(floatArgs));
        Application application = new Application(validator, shapes, factory);
    }
}
