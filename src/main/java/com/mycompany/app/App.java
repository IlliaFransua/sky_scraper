package com.mycompany.app;

import java.util.List;

public class App {

  private final HeightsParser heightsParser = new HeightsParser();
  private final PermutationFinder permutationFinder = new PermutationFinder();

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
    System.out.println(res);
  }
}
