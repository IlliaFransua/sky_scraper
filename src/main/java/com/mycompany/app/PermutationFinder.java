package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class PermutationFinder {

  public List<List<Integer>> findAll(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtracking(result, nums, new ArrayList<>(), new boolean[nums.length]);
    return result;
  }

  private void backtracking(
      List<List<Integer>> result, int[] nums, List<Integer> current, boolean[] seen) {
    for (int i = 0; i < nums.length; i++) {
      if (current.size() == seen.length) {
        result.add(new ArrayList<>(current));
        return;
      }

      if (seen[i]) {
        continue;
      }

      current.add(nums[i]);
      seen[i] = true;
      backtracking(result, nums, current, seen);
      seen[i] = false;
      current.remove(current.size() - 1);
    }
  }
}
