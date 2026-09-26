package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class App {

  private final HeightsParser heightsParser = new HeightsParser();
  private final PermutationFinder permutationFinder = new PermutationFinder();
  private final LineOptionFilter lineOptionFilter = new LineOptionFilter();

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

    var nums = new int[] {1, 2, 3, 4};
    List<List<Integer>> res = permutationFinder.findAll(nums);

    List<List<List<Integer>>> allLinesOptions = new ArrayList<>();

    allLinesOptions.add(List.copyOf(res));
    allLinesOptions.add(List.copyOf(res));
    allLinesOptions.add(List.copyOf(res));
    allLinesOptions.add(List.copyOf(res));

    int sum = 0;
    for (int i = 0; i < allLinesOptions.size(); i++) {
      for (int j = 0; j < allLinesOptions.get(i).size(); j++) {
        ++sum;
      }
    }
    System.out.println(sum);

    lineOptionFilter.clearByHeight(heights, allLinesOptions);

    sum = 0;
    for (int i = 0; i < allLinesOptions.size(); i++) {
      for (int j = 0; j < allLinesOptions.get(i).size(); j++) {
        ++sum;
      }
    }
    System.out.println(sum);
    System.out.println(allLinesOptions);
  }
}
