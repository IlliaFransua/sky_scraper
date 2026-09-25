package com.mycompany.app;

import java.util.List;

public class App {

  public static void main(String[] args) {
    new App().run();
  }

  public void run() {
    PermutationFinder permutationFinder = new PermutationFinder();
    var nums = new int[] {1, 2, 3, 4};
    List<List<Integer>> res = permutationFinder.backtracking(nums);
    System.out.println(res);
  }
}
