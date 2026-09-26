package com.mycompany.app;

public class App {

  private final HeightsParser heightsParser = new HeightsParser();
  private final LineOptionGenerator lineOptionGenerator = new LineOptionGenerator();

  public static void main(String[] args) {
    new App().run(args);
  }

  public void run(String[] args) {
    int gridSize = 4;
    var heights = heightsParser.parse(gridSize, args);
    if (heights == null) {
      System.out.println("Wrong args count");
      return;
    }

    var allLinesOptions = lineOptionGenerator.generateAllPosibleLines(gridSize, heights);
    System.out.println(allLinesOptions);
  }
}
