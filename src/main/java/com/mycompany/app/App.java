package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

    int[] nums = IntStream.rangeClosed(1, gridSize).toArray();
    List<List<Integer>> res = permutationFinder.findAll(nums);

    List<List<List<Integer>>> allLinesOptions = new ArrayList<>();

    allLinesOptions.add(List.copyOf(res));
    allLinesOptions.add(List.copyOf(res));
    allLinesOptions.add(List.copyOf(res));
    allLinesOptions.add(List.copyOf(res));

    lineOptionFilter.clearByHeight(heights, allLinesOptions);
  }
}
