package com.mycompany.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineOptionFilter {

  public void clearByHeight(
      List<List<Integer>> heights, List<List<List<Integer>>> allLinesOptions) {
    for (int row = 0; row < allLinesOptions.size(); row++) {
      var lineOptions = new ArrayList<>(allLinesOptions.get(row));
      List<Integer> indexesToDelete = new ArrayList<>();
      for (int optionIndex = 0; optionIndex < lineOptions.size(); ++optionIndex) {
        int rowLeft = heights.get(2).get(row);
        int rowRight = heights.get(3).get(row);
        if (calculateVisibleTowers(lineOptions.get(optionIndex), 'l') != rowLeft
            || calculateVisibleTowers(lineOptions.get(optionIndex), 'r') != rowRight) {
          indexesToDelete.add(optionIndex);
        }
      }
      for (int j = indexesToDelete.size() - 1; j >= 0; --j) {
        lineOptions.remove((int) indexesToDelete.get(j));
      }
      allLinesOptions.set(row, lineOptions);
    }
  }

  private int calculateVisibleTowers(List<Integer> towers, char view_by) {
    if (view_by != 'l' && view_by != 'r') {
      return 0;
    }
    if (view_by == 'r') {
      towers = new ArrayList<>(towers);
      Collections.reverse(towers);
    }
    int sum = 0;
    int maxSeen = 0;
    for (int i = 0; i < towers.size(); i++) {
      if (towers.get(i) > maxSeen) {
        maxSeen = towers.get(i);
        ++sum;
      }
    }
    return sum;
  }
}
