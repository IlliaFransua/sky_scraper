package com.mycompany.app;

import java.util.List;

public class SkyScraper {

  private final LineOptionService lineOptionService = new LineOptionService();

  public void findAnswer(
      List<List<List<Integer>>> allLinesOptions,
      List<List<Integer>> heights,
      int rowIndex,
      int gridSize,
      List<List<Integer>> res,
      List<List<Integer>> current) {
    if (rowIndex == gridSize) {
      if (lineOptionService.is_valid_vertical(current, heights)) {
        for (var line : current) {
          res.add(line);
        }
      }
      return;
    }

    var lineOptions = allLinesOptions.get(rowIndex);
    for (var option : lineOptions) {
      current.add(option);
      findAnswer(allLinesOptions, heights, rowIndex + 1, gridSize, res, current);
      if (!res.isEmpty()) {
        return;
      }
      current.remove(option);
    }
  }
}
