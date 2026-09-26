package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class HeightsParser {

  public List<List<Integer>> parse(int gridSize, String[] args) {
    if (args.length != gridSize * 4) {
      return null;
    }
    List<List<Integer>> heights = new ArrayList<>(); // colUp, colDown, rowLeft, rowRight
    for (int i = 0; i < gridSize * 4; i++) {
      if (i % gridSize == 0) {
        heights.add(new ArrayList<>());
      }
      heights.get(heights.size() - 1).add(Integer.valueOf(args[i]));
    }
    return heights;
  }
}
