**Welcome to my collection of LeetCode problem solutions! Here, I've tackled problems ranging from easy to hard difficulty levels. These solutions represent my own attempts, and while I've strived for accuracy, there may be mistakes or opportunities for optimisation.**

**I appreciate any feedback or suggestions for improving these solutions. You can contribute by forking this repository and submitting pull requests. Thank you for taking the time to review my work!**

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

- Without converting it to a (String Time Complexity O(Log10(N))

Without converting the number to a string, we first take care of the cases where `x` is 0, `x` is a multiple of 10, and `x` is a negative number. Then we reverse half of the number and compare it with the remaining half.

### First Iteration:

- **Before iteration:**
    - `x = 121`
    - `reversed = 0`
- **Calculation:**
    - `x % 10` gives `1`.
    - `reversed = reversed * 10 + x % 10` becomes `reversed = 0 * 10 + 1 = 1`.
    - `x /= 10` removes the last digit of `x`, resulting in `x = 121 / 10 = 12`.
- **After iteration:**
    - `reversed = 1`
    - `x = 12`

### Second Iteration:

- **Before iteration:**
    - `x = 12`
    - `reversed = 1`
- **Calculation:**
    - `x % 10` gives `2`.
    - `reversed = reversed * 10 + x % 10` becomes `reversed = 1 * 10 + 2 = 12`.
    - `x /= 10` removes the last digit of `x`, resulting in `x = 12 / 10 = 1`.
- **After iteration:**
    - `reversed = 12`
    - `x = 1`

The loop exits because `x` (1) is no longer greater than `reversed` (12).

### Comparison:

Now we compare the two numbers.

- **Even-length number**: `x == reversed`
- **Odd-length number**: `x == reversed / 10` (removes the middle digit, in this case, 2).

```
public static boolean isPalindrome(int x) {  
	if (x < 0 || (x % 10 == 0 && x != 0)) {  
	return false;
	}  
	int reversed = 0;  
	while (x > reversed) {  
		reversed = reversed * 10 + x % 10;  
		x = x / 10;  
	}  
	return x == reversed || x == reversed / 10;  
}
```


## 13. Roman to Integer

Roman numerals are represented by seven different symbols: `I`, `V`, `X`, `L`, `C`, `D` and `M`.

**Symbol**       **Value**
	I              1
	V             5
	X             10
	L             50
	C             100
	D             500
	M            1000

For example, `2` is written as `II` in Roman numeral, just two ones added together. `12` is written as `XII`, which is simply `X + II`. The number `27` is written as `XXVII`, which is `XX + V + II`.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not `IIII`. Instead, the number four is written as `IV`. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as `IX`. There are six instances where subtraction is used:

- `I` can be placed before `V` (5) and `X` (10) to make 4 and 9. 
- `X` can be placed before `L` (50) and `C` (100) to make 40 and 90. 
- `C` can be placed before `D` (500) and `M` (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.

**Example 1:**

**Input:** s = "III"
**Output:** 3
**Explanation:** III = 3.

**Example 2:**

**Input:** s = "LVIII"
**Output:** 58
**Explanation:** L = 50, V= 5, III = 3.

**Example 3:**

**Input:** s = "MCMXCIV"
**Output:** 1994
**Explanation:** M = 1000, CM = 900, XC = 90 and IV = 4.

**Constraints:**

- `1 <= s.length <= 15`
- `s` contains only the characters `('I', 'V', 'X', 'L', 'C', 'D', 'M')`.
- It is **guaranteed** that `s` is a valid roman numeral in the range `[1, 3999]`.

## Solution

- Although advised to use a `hashmap`, using a switch case would be more efficient on memory.
	A pretty self explanatory code. 
	Use debugger to look at the iterations and how the values update.
	
```
private static int translate(char c){  
	switch (c){  
		case 'I' :  
			return 1;  
		case 'V' :  
			return 5;  
		case 'X' :  
			return 10;  
		case 'L' :  
			return 50;  
		case 'C' :  
			return 100;  
		case 'D' :  
			return 500;  
		case 'M' :  
			return 1000;  
		default:  
			return 0;  
	}  
}

public static int romanToInt(String s) {  
	int integer = 0;  
	int length = s.length();  
	int current = translate(s.charAt(0));  
	for (int i = 1; i < length; i++) {  
		int next = translate(s.charAt(i));  
			if (current<next){  
				integer = integer - current;  
			} else {  
				integer = integer + current;  
			}  
			current = next;  
		}  
	integer = integer + current;  
	return integer;  
}
```

## 14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string `""`.

**Example 1:**

**Input:** strs = ["flower","flow","flight"]
**Output:** "fl"

**Example 2:**

**Input:** strs = ["dog","racecar","car"]
**Output:** ""
**Explanation:** There is no common prefix among the input strings.

**Constraints:**

- `1 <= strs.length <= 200`
- `0 <= strs[i].length <= 200`
- `strs[i]` consists of only lowercase English letters.

## Solution

- Using `StringBuilder` 
	This is the brute force approach where we compare and contrast every `char` in each `string` in the array.
	We use `Integer.MAX_VALUE` in Integer class to figure out the the length of the String with the minimum length.
```
public static String longestCommonPrefix(String[] strs) {  
	if (strs == null || strs.length == 0) return "";  
  
	StringBuilder sb = new StringBuilder();  
	int minLen = Integer.MAX_VALUE;  
	for (String str : strs) {  
		if (str.length() < minLen) {  
			minLen = str.length();  
		}  
	}  
  
	for (int i = 0; i < minLen; i++) {  
		char c = strs[0].charAt(i);  
		for (int j = 1; j < strs.length; j++) {  
			if (strs[j].charAt(i) != c) {  
				return sb.toString();  
			}  
		}  
		sb.append(c);  
	}  
	return sb.toString();  
}
```

- A more optimal method
	 Here too a `StringBuilder` is used.
	 Instead of comparing all the elements in the array, we first sort the array and we compare only first and last elements in the `string` array as two `char` arrays.
	 While comparing
		 - if the first characters are not same, then we return " "
		 - we keep comparing each `char` in the two strings until a different element is found 
	 We append the common terms into a `StringBuilder` object.

```
public static String longestCommonPrefix(String[] strs) {  
	StringBuilder sb = new StringBuilder();  
	Arrays.sort(strs);  
	char[] first = strs[0].toCharArray();  
	char[] last = strs[strs.length-1].toCharArray();  
  
	for (int i = 0; i < first.length; i++) {  
		if (first[i] != last[i]){  
			break;  
		} else sb.append(first[i]);  
	}  
	return sb.toString();  
}
```

## 20. Valid Parentheses

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

**Example 1:**

**Input:** s = "()"
**Output:** true

**Example 2:**

**Input:** s = "()[]{}"
**Output:** true

**Example 3:**

**Input:** s = "(]"
**Output:** false

**Constraints:**

- `1 <= s.length <= 104`
- `s` consists of parentheses only `'()[]{}'`.

## Solution

- We use a `Stack`.
Whenever the character at the index while iterating is a `'(', '{' or a '['` we push it into the stack. 
While checking the top element we pop from the stack when the character is `')', '}' or ']'`.
Be sure to check the emptiness of the array throughout.
```
public static boolean isValid(String s) {  
	Stack<Character> stack = new Stack<>();  
	for (int i = 0; i < s.length(); i++) {  
		if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {  
			stack.push(s.charAt(i));  
		} else {  
			if (stack.isEmpty()) {  
				return false;  
			}  
		if ((s.charAt(i) == ')' && stack.peek() == '(') || (s.charAt(i) == ']' && stack.peek() == '[') || (s.charAt(i) == '}' && stack.peek() == '{')) {  
			stack.pop();  
			} else {  
				return false;  
			}  
		}  
	}  
	return stack.isEmpty();  
}
```

## 21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists `list1` and `list2`.

Merge the two lists into one **sorted** list. The list should be made by splicing together the nodes of the first two lists.

Return _the head of the merged linked list_.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg)

**Input:** list1 = [1,2,4], list2 = [1,3,4]
**Output:** [1,1,2,3,4,4]

**Example 2:**

**Input:** list1 = [], list2 = []
**Output:** []

**Example 3:**

**Input:** list1 = [], list2 = [0]
**Output:** [0]

**Constraints:**

- The number of nodes in both lists is in the range `[0, 50]`.
- `-100 <= Node.val <= 100`
- Both `list1` and `list2` are sorted in **non-decreasing** order.
## Solution

A bit confusing when looking at it first but looking at this main method would help to understand it more clearly.
observe the instan

```
public static void main(String[] args) {  
	ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));  
	ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));  
	ListNode sol = mergeTwoLists(l1,l2);  
  
	while (sol != null) {  
	System.out.print(sol.val + ", ");  
	sol = sol.next;  
	}  
}
```

then our output would be,

``` 
1, 1, 2, 3, 4, 4, 
```

The method takes in two `ListNode` objects as parameters and returns a `ListNode` .
We must make sure to look at the edge cases where a list might have elements remaining even though the other has finished merging.

```
public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {  
	ListNode temp = new ListNode(0);  
	ListNode current = temp;  
  
	while(list1!=null && list2!=null){  
		if (list1.val < list2.val){  
			current.next = list1;  
			list1 = list1.next;  
		} else {  
			current.next = list2;  
			list2 = list2.next;  
		}  
		current = current.next;  
	}  
	if (list1!=null){  
		current.next = list1;  
		list1 = list1.next;  
	}  
	if (list2!=null){  
		current.next = list2;  
		list2 = list2.next;  
	}  
	return temp.next;  
}
```

## 26. Remove Duplicates from Sorted Array

Given an integer array `nums` sorted in **non-decreasing order**, remove the duplicates [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm) such that each unique element appears only **once**. The **relative order** of the elements should be kept the **same**. Then return _the number of unique elements in_ `nums`.

Consider the number of unique elements of `nums` to be `k`, to get accepted, you need to do the following things:

- Change the array `nums` such that the first `k` elements of `nums` contain the unique elements in the order they were present in `nums` initially. The remaining elements of `nums` are not important as well as the size of `nums`.
- Return `k`.

**Custom Judge:**

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}

If all assertions pass, then your solution will be **accepted**.

**Example 1:**

**Input:** nums = [1,1,2]
**Output:** 2, nums = [1,2,_]
**Explanation:** Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

**Example 2:**

**Input:** nums = [0,0,1,1,1,2,2,3,3,4]
**Output:** 5, nums = [0,1,2,3,4,_,_,_,_,_]
**Explanation:** Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

**Constraints:**

- `1 <= nums.length <= 3 * 104`
- `-100 <= nums[i] <= 100`
- `nums` is sorted in **non-decreasing** order.
## Solution

Again the context of the question is a bit confusing but once you understand it, the implementation is very easy.
We have to take in a `int[] nums` and reassign it within our method to an array of only the unique values in the original array. 
What occurs after the expected output does not matter.
we need to return the number of unique elements too.

```
public static int removeDuplicates(int[] nums) {  
int k = 0;  
for (int i = 0; i < nums.length; i++) {  
if (i == nums.length - 1 || nums[i] != nums[i + 1]) {  
nums[k] = nums[i];  
k++;  
}  
}  
return k;  
}
```

