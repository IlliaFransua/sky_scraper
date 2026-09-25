package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class PermutationFinder {

  public List<List<Integer>> backtracking(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    realBacktracking(result, nums, new ArrayList<>(), new boolean[nums.length]);
    return result;
  }

  private void realBacktracking(
      List<List<Integer>> result, int[] nums, List<Integer> current, boolean[] seen) {
    for (int i = 0; i < nums.length; i++) {
      if (current.size() == 3) {
        result.add(new ArrayList<>(current));
        return;
      }

      if (seen[i]) {
        continue;
      }

      current.add(nums[i]);
      seen[i] = true;
      realBacktracking(result, nums, current, seen);
      seen[i] = false;
      current.remove(current.size() - 1);
    }
  }
}
