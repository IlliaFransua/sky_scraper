package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LineOptionGenerator {

  private final PermutationFinder permutationFinder = new PermutationFinder();
  private final LineOptionFilter lineOptionFilter = new LineOptionFilter();

  public List<List<List<Integer>>> generateAllPosibleLines(
      int gridSize, List<List<Integer>> heights) {
    int[] nums = IntStream.rangeClosed(1, gridSize).toArray();
    List<List<Integer>> res = permutationFinder.findAll(nums);

    List<List<List<Integer>>> allLinesOptions = new ArrayList<>();

    allLinesOptions.add(List.copyOf(res));
    allLinesOptions.add(List.copyOf(res));
    allLinesOptions.add(List.copyOf(res));
    allLinesOptions.add(List.copyOf(res));

    lineOptionFilter.clearByHeight(heights, allLinesOptions);

    return allLinesOptions;
  }
}
