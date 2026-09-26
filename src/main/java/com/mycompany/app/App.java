package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class App {

  private final HeightsParser heightsParser = new HeightsParser();
  private final LineOptionGenerator lineOptionGenerator = new LineOptionGenerator();
  private final SkyScraper scraper = new SkyScraper();

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
    List<List<Integer>> res = new ArrayList<>();
    scraper.findAnswer(allLinesOptions, heights, 0, gridSize, res, new ArrayList<>());

    if (res.isEmpty()) {
      System.out.println("Error");
    }

    for (int i = 0; i < res.size(); i++) {
      System.out.println(res.get(i));
    }
  }
}
