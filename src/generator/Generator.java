package generator;

import AST.flask.Program;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Generator {

    private final StringBuilder pythonCode =
            new StringBuilder();

    private final StringBuilder htmlCode =
            new StringBuilder();

    private final StringBuilder cssCode =
            new StringBuilder();

    public void generate(Program program) throws IOException {

    //generate python code according to the AST





        saveFiles();
    }

    private void saveFiles() throws IOException {

        Files.createDirectories(
                Path.of("output/templates")
        );

        Files.createDirectories(
                Path.of("output/static")
        );

        Files.writeString(
                Path.of("output/app.py"),
                pythonCode.toString()
        );

        Files.writeString(
                Path.of("output/templates/index.html"),
                htmlCode.toString()
        );

        Files.writeString(
                Path.of("output/static/style.css"),
                cssCode.toString()
        );

    }


}