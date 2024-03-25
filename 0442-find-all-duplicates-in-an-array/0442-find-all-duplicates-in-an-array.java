class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> resultSet = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      // Get the index, the element corresponds to
      int index = Math.abs(nums[i]) - 1;

      // If the number is already negative, it means we are 
      // encountering it twice
      if (nums[index] < 0)
        resultSet.add(index + 1);

      // Flip the number at the index to negative
      nums[index] = nums[index] * -1;
    }

    return resultSet;
    }
}