package com.mycompany.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LineOptionService {

  public void clearLinesByHeights(
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

  public boolean is_valid_vertical(List<List<Integer>> current, List<List<Integer>> heights) {
    return are_columns_vertical_uniq(current) && are_vertical_heights_valid(heights, current);
  }

  private boolean are_columns_vertical_uniq(List<List<Integer>> current) {
    if (current.isEmpty()) {
      return true;
    }
    for (int col = 0; col < current.get(0).size(); col++) {
      Set<Integer> seen = new HashSet<>();
      for (int row = 0; row < current.size(); row++) {
        var digit = current.get(row).get(col);
        if (seen.contains(digit)) {
          return false;
        }
        seen.add(digit);
      }
      seen.clear();
    }
    return true;
  }

  private boolean are_vertical_heights_valid(
      List<List<Integer>> heights, List<List<Integer>> rows) {
    List<Integer> towers;
    for (int col = 0; col < rows.get(0).size(); ++col) {
      towers = new ArrayList<>();
      for (int row = 0; row < rows.size(); row++) {
        var number = rows.get(row).get(col);
        towers.add(number);
      }
      int colUp = heights.get(0).get(col);
      int colDown = heights.get(1).get(col);
      if (calculateVisibleTowers(towers, 'l') != colUp
          || calculateVisibleTowers(towers, 'r') != colDown) {
        return false;
      }
      towers.clear();
    }
    return true;
  }
}
