package ilex_ui_tests;

public class Ilex_ui_tests {

    public static void main(String[] args) throws Throwable {
      /*  String[] arguments = {};
        cucumber.api.cli.Main.main(arguments);*/
        //cucumber.api.cli.Main.main(new String[]{"-g", "classpath to step definition file", "Full path to feature file"});
        cucumber.api.cli.Main.main(new String[]{"-g", "step_definitions", System.getProperty("user.dir")+"/src/test/resources/features"});


    }
}
