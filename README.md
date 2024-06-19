## 1. Two Sum

Given an array of integers `nums` and an integer `target`, return _indices of the two numbers such that they add up to `target`_.

You may assume that each input would have **_exactly_ one solution**, and you may not use the _same_ element twice.

You can return the answer in any order.

**Example 1:**

**Input:** nums = [2,7,11,15], target = 9
**Output:** [0,1]
**Explanation:** Because nums[0] + nums[1] == 9, we return [0, 1].

**Example 2:**

**Input:** nums = [3,2,4], target = 6
**Output:** [1,2]

**Example 3:**

**Input:** nums = [3,3], target = 6
**Output:** [0,1]
## Solution
- Brute Force (Time Complexity O(n<sup>2</sup>)) - each for loop is n

```
public int[] twoSum(int[] nums, int target) {
	for (int i = 0; i < nums.length; i++) {
		for (int j = i+1; j < nums.length; j++) {
			if (nums[i]+nums[j] == target){
				return new int[] {i, j};
				}
			}
		}
	return nums;
	}
```

- HashMap Approach (Time Complexity O(n))

We implement a `HashMap` where each key represents the complementary value needed for the current element `nums[i]` to reach the target sum (`target - nums[i]`), and each value for the key represents the index of the current element `nums[i]`. As we iterate through the array:

1. For each element `nums[i]`, we calculate its complement (i.e., `target - nums[i]`).
2. We then check if the complement is already in the `HashMap`.
    - If it is, this means we have previously encountered its complement, and the stored index, along with the current index `i`, gives us the two numbers that add up to the target.
    - If it is not, we store the complement as a key in the `HashMap`, with the current index `i` as its value.

```
public static int[] twoSum(int[] nums, int target) {  
	Map<Integer, Integer> complements = new HashMap<>();  
	for (int i = 0; i < nums.length; i++) {  
		Integer complementIndex = complements.get(nums[i]);  
		if (complementIndex != null){  
		return new int[]{i, complementIndex};  
	}
	complements.put(target - nums[i], i);  
	}  
	return nums;  
}
```

## 9. Palindrome Number

Given an integer `x`, return `true` _if_ `x` _is a_ _**palindrome**__, and_ `false` _otherwise_.

**Example 1:**

**Input:** x = 121
**Output:** true
**Explanation:** 121 reads as 121 from left to right and from right to left.

**Example 2:**

**Input:** x = -121
**Output:** false
**Explanation:** From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

**Example 3:**

**Input:** x = 10
**Output:** false
**Explanation:** Reads 01 from right to left. Therefore it is not a palindrome.
## Solution
- By converting it into a `String` 

```
public static boolean isPalindrome(int x) {
	String
	 number = Integer.toString(x);
	StringBuilder reverse = new StringBuilder();
	for (int i = number.length()-1; i>=0; i--) {
		reverse.append(number.charAt(i));
		}
		if (reverse.toString().equals(number)){
			return true;
		}
	return false;
}
```

- Without converting it to a String

we only need to check half of 

```public static boolean(int x){
	if(x<0 || (x%10 = 0 && x!=0)){
	return false;
	}
	
	int reversed = 0;
	
	while(x > reversed){
		
	}
	
}
```

