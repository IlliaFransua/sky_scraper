package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LineOptionGenerator {

  private final DigitPermutationGenerator permutationFinder = new DigitPermutationGenerator();
  private final LineOptionService lineOptionService = new LineOptionService();

  public List<List<List<Integer>>> generateAllPosibleLines(
      int gridSize, List<List<Integer>> heights) {
    int[] nums = IntStream.rangeClosed(1, gridSize).toArray();
    List<List<Integer>> res = permutationFinder.generateAllPosible(nums);

    List<List<List<Integer>>> allLinesOptions = new ArrayList<>();

    for (int i = 0; i < gridSize; ++i) {
      allLinesOptions.add(List.copyOf(res));
    }

    lineOptionService.clearLinesByHeights(heights, allLinesOptions);

    return allLinesOptions;
  }
}
