**This is my collection of LeetCode problem solutions! Here, I've tackled problems ranging from easy to hard difficulty levels. These solutions represent my own attempts, and while I've strived for accuracy, there may be mistakes or opportunities for optimisation.**

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

The context of the question is a bit confusing but once you understand it, the implementation is quiet easy.
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

## 27. Remove Element

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in `nums` [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm). The order of the elements may be changed. Then return _the number of elements in_ `nums` _which are not equal to_ `val`.

Consider the number of elements in `nums` which are not equal to `val` be `k`, to get accepted, you need to do the following things:

- Change the array `nums` such that the first `k` elements of `nums` contain the elements which are not equal to `val`. The remaining elements of `nums` are not important as well as the size of `nums`.
- Return `k`.

**Custom Judge:**

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}

If all assertions pass, then your solution will be **accepted**.

**Example 1:**

**Input:** nums = [3,2,2,3], val = 3
**Output:** 2, nums = [2,2,_,_]
**Explanation:** Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).

**Example 2:**

**Input:** nums = [0,1,2,2,3,0,4,2], val = 2
**Output:** 5, nums = [0,1,4,0,3,_,_,_]
**Explanation:** Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).

**Constraints:**

- `0 <= nums.length <= 100`
- `0 <= nums[i] <= 50`
- `0 <= val <= 100`

## Solution

We have to take in a `int[] nums` and reassign it within our method to an array where the given value `val` is removed.
```
public static int removeElement(int[] nums, int val) {  
	int j = 0;  
	for (int i = 0; i < nums.length; i++) {  
		if (nums[i] != val){  
			nums[j] = nums[i];  
			j++;  
		}  
	}  
	return j;  
}
```

## 28. Find The Index Of The First Occurrence In A String

Given two strings `needle` and `haystack`, return the index of the first occurrence of `needle` in `haystack`, or `-1` if `needle` is not part of `haystack`.

**Example 1:**

**Input:** haystack = "sadbutsad", needle = "sad"
**Output:** 0
**Explanation:** "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

**Example 2:**

**Input:** haystack = "leetcode", needle = "leeto"
**Output:** -1
**Explanation:** "leeto" did not occur in "leetcode", so we return -1.

**Constraints:**

- `1 <= haystack.length, needle.length <= 104`
- `haystack` and `needle` consist of only lowercase English characters.
## Solution

Here we can make a substring of the length of `needle` and iterate thru indices of `haystack` to compare each newly made substring to `needle` itself and if so we can return the starting index `i`.
```
public static int strStr(String haystack, String needle) {  
	int haystackLength = haystack.length();  
	int needleLength = needle.length();  
  
	for (int i = 0; i <= haystackLength - needleLength; i++) {  
		if (haystack.substring(i, i + needleLength).equals(needle)) {  
			return i;  
		}  
	}  
	return -1;  
}
```

The funny thing is Java has a inbuilt method which would do exactly what we need,  so our code would simply be,

```
public static int strStr(String haystack, String needle) {  
	return haystack.indexOf(needle);  
}
```

## 35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with `O(log n)` runtime complexity.

**Example 1:**

**Input:** nums = [1,3,5,6], target = 5
**Output:** 2

**Example 2:**

**Input:** nums = [1,3,5,6], target = 2
**Output:** 1

**Example 3:**

**Input:** nums = [1,3,5,6], target = 7
**Output:** 4

**Constraints:**

- `1 <= nums.length <= 104`
- `-104 <= nums[i] <= 104`
- `nums` contains **distinct** values sorted in **ascending** order.
- `-104 <= target <= 104`
## Solution

A pretty straight forward solution with if cases while iterating thru each value in the sorted array.
```
public static int searchInsert(int[] nums, int target) {  
	for (int i = 0; i < nums.length; i++) {  
		if (nums[i] == target){  
		return i;  
		} else if (target < nums[0]){  
			return 0;  
		} else if (nums[nums.length-1] < target){  
			return nums.length;  
		} else if (nums[i] < target && target < nums[i+1]){  
			return i+1;  
		}  
	}  
return -1;  
}
```

## 58.  Length of Last Word

Given a string `s` consisting of words and spaces, return _the length of the **last** word in the string._

A **word** is a maximal 

substring

 consisting of non-space characters only.

**Example 1:**

**Input:** s = "Hello World"
**Output:** 5
**Explanation:** The last word is "World" with length 5.

**Example 2:**

**Input:** s = "   fly me   to   the moon  "
**Output:** 4
**Explanation:** The last word is "moon" with length 4.

**Example 3:**

**Input:** s = "luffy is still joyboy"
**Output:** 6
**Explanation:** The last word is "joyboy" with length 6.

**Constraints:**

- `1 <= s.length <= 104`
- `s` consists of only English letters and spaces `' '`.
- There will be at least one word in `s`.

## Solution

Uses inbuilt methods in the String class.
we use `trim()` to get rid of all the white spaces at the end and beginning.
`contains()` is also used.
```
public static int lengthOfLastWord(String s) {  
	s = s.trim();  
	int i = 0;  
	if (!s.contains(" ")) return s.length();  
	for (int j = s.length()-1; j >= 0 ; j--) {  
		i++;  
		if (s.charAt(j) == ' ') {  
			break;  
		}  
	}  
	return i-1;  
}
```

## 66.Plus One

You are given a **large integer** represented as an integer array `digits`, where each `digits[i]` is the `ith` digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading `0`'s.

Increment the large integer by one and return _the resulting array of digits_.

**Example 1:**

**Input:** digits = [1,2,3]
**Output:** [1,2,4]
**Explanation:** The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

**Example 2:**

**Input:** digits = [4,3,2,1]
**Output:** [4,3,2,2]
**Explanation:** The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

**Example 3:**

**Input:** digits = [9]
**Output:** [1,0]
**Explanation:** The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].

**Constraints:**

- `1 <= digits.length <= 100`
- `0 <= digits[i] <= 9`
- `digits` does not contain any leading `0`'s.

## Solution
A bit confusing at first.
while iterating from the least significant value, we check whether it is a 9 or not and act accordingly. 
A special case comes when the values os all the digits are 9.
Then we have to declare a new `int[]` of length +1 and set index `0` to 1 and return that.
```
public static int[] plusOne(int[] digits) {  
	int n = digits.length;  
	for (int i = n - 1; i >= 0; i--) {  
		if (digits[i] < 9) {  
			digits[i]++;  
			return digits;  
		}  
		digits[i] = 0;  
	}  
	int[] newDigits = new int[n + 1];  
	newDigits[0] = 1;  
	return newDigits;  
}
```

## 67. Add Binary

Given two binary strings `a` and `b`, return _their sum as a binary string_.

**Example 1:**

**Input:** a = "11", b = "1"
**Output:** "100"

**Example 2:**

**Input:** a = "1010", b = "1011"
**Output:** "10101"

**Constraints:**

- `1 <= a.length, b.length <= 104`
- `a` and `b` consist only of `'0'` or `'1'` characters.
- Each string does not contain leading zeros except for the zero itself.

## Solution

Personally this was a very hard question.
We iterate through each of the input `String`s from the end in a while loop, which stops when both strings are fully traversed. We use a `StringBuilder` to construct the result and a `carry` variable to handle any overflow during addition. Inside the loop, we sum the current digits of `a` and `b` (if available) with the carry, then append the least significant bit of the sum (`sum % 2`) to the `StringBuilder` and update the carry (`sum / 2`). We decrement the indices `i` and `j` after processing. After the loop, if there's any remaining carry, we append it to the `StringBuilder`. Finally, we reverse the `StringBuilder` to obtain the correct binary result and return it as a string.
 ```
public static String addBinary(String a, String b) {  
	int i = a.length()-1;  
	int j = b.length()-1;  
	StringBuilder sb = new StringBuilder();  
	int carry = 0;  
	while(i>=0 || j>=0){  
		int sum = carry;  
		if(i >= 0) sum += a.charAt(i) - '0';  
		if(j >= 0) sum += b.charAt(i) - '0';  
		sb.append(sum%2);  
		carry = sum/2;  
		i--;  
		j--;  
	}  
	if (carry!=0) sb.append(carry);  
	return sb.reverse().toString();  
}
```

## 69. Sqrt(x)

Given a non-negative integer `x`, return _the square root of_ `x` _rounded down to the nearest integer_. The returned integer should be **non-negative** as well.

You **must not use** any built-in exponent function or operator.

- For example, do not use `pow(x, 0.5)` in c++ or `x ** 0.5` in python.

**Example 1:**

**Input:** x = 4
**Output:** 2
**Explanation:** The square root of 4 is 2, so we return 2.

**Example 2:**

**Input:** x = 8
**Output:** 2
**Explanation:** The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

**Constraints:**

- `0 <= x <= 231 - 1`

## Solution

We are instructed not to use any in-built function so we approach this using Binary Search. We can look at this using an 2 examples.

- When x = 16
`start` = 1 and `end` = 16

**First iteration** 
`mid` = 1 + (16 - 1) / 2 = 1 + 7 = 8 
`mid` is > 16 / 8 (2) 
`end` = 8 - 1 = 7

`start` = 1 and `end` = 7

**Second iteration** (hence 1 <= 7) 
`mid` = 1 + (7 - 1) / 2 = 1 + 3 = 4 
`mid` is <= 16 / 4 (4) 

`start` = 5 `res` = 4

`res` = 4 is returned

- When x = 20

`start` = 1 and `end` = 20

**First iteration** 
`mid` = 1 + (20 - 1) / 2 = 1 + 9 = 10
`mid` is > 20 / 10 (2) 
`end` = 10 - 1 = 9

`start` = 1 and `end` = 9

**Second iteration** (hence 1 <= 9) 
`mid` = 1 + (9 - 1) / 2 = 1 + 4 = 5 
`mid` is > 20 / 5 (4)
`end` = 5 - 1 = 4

`start` = 1 and `end` = 4

**Third iteration** (hence 1 <= 4) 
`mid` = 1 + (4 - 1) / 2 = 1 + 1 = 2
`mid` is <= 20 / 2 (10) 
`start` = 3 `res` = 2

`start` = 3 and `end` = 4

**Fourth iteration** (hence 3 <= 4) 
`mid` = 3 + (4 - 3) / 2 = 3 + 0 = 3
`mid` is <= 20 / 3 (6.67) 
`start` = 4 `res` = 3

`start` = 4 and `end` = 4

**Fifth iteration** (hence 4 <= 4) 
`mid` = 4 + (4 - 4) / 2 = 4 + 0 = 4 
`mid` is <= 20 / 4 (5) 
`start` = 5 `res` = 4

`res` = 4 is returned

```
public static int mySqrt(int x) {  
	int start = 1;  
	int end = x;  
	int res = 0;  
	while (start<=end){  
		int mid = start + (end - start)/2;  
		if (mid<=x/mid){  
			start = mid + 1; 
			res = mid;  
		} else {  
			end = mid-1;  
		}  
	}  
	return res;  
}
```

## 70. Climbing Stairs
You are climbing a staircase. It takes `n` steps to reach the top.

Each time you can either climb `1` or `2` steps. In how many distinct ways can you climb to the top?

**Example 1:**

**Input:** n = 2
**Output:** 2
**Explanation:** There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

**Example 2:**

**Input:** n = 3
**Output:** 3
**Explanation:** There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

**Constraints:**

- `1 <= n <= 45`

## Solution
- Brute Force Approach
Let us look at the pattern of increment of ways to climb the stairs
	when `n=1` --> `1`
	when `n=2` --> `2`
	when `n=3` --> `3`
	when `n=4` --> `5`
	when `n=5` --> `8`
We can see the Fibonacci sequence but for `n=n+1`
Therefore the solution would be,
```
public static int climbStairs(int n) {  
	if (n == 1) return 1;  
	return fib(n+1);  
}  
  
private static int fib(int n){  
	if (n <= 1) return n;  
	else {return fib(n-1) + fib(n-2);}  
}
```
But when you run this code we can see that we get a `Time Limit Exceeded` error.
This is because the Fibonacci method used is very time consuming.

- Efficient method
Here we use a `int[]` and we fill this out with the Fibonacci numbers from `0` to `n` and return the value at n<sup>th</sup> index.
```
public static int climbStairs(int n) {  
	if (n == 1) return 1;  
	if (n == 2) return 2;  
	int[] fib = new int[n+1];  
	fib[1] = 1;  
	fib[2] = 2;  
	for (int i = 3; i <= n ; i++) {  
		fib[i] = fib[i-1] + fib[i-2];  
	}  
	return fib[n];  
}
```
This is more efficient.

## 83. Remove Duplicates from Sorted List
Given the `head` of a sorted linked list, _delete all duplicates such that each element appears only once_. Return _the linked list **sorted** as well_.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/01/04/list1.jpg)

**Input:** head = [1,1,2]
**Output:** [1,2]

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/01/04/list2.jpg)

**Input:** head = [1,1,2,3,3]
**Output:** [1,2,3]

**Constraints:**

- The number of nodes in the list is in the range `[0, 300]`.
- `-100 <= Node.val <= 100`
- The list is guaranteed to be **sorted** in ascending order.

## Solution
Again a pretty straight forward answer.
A temporary variable is used to iterate and skip over duplicate values.
```
public static ListNode deleteDuplicates(ListNode head) {  
		ListNode temp = head;  
		while(temp!=null && temp.next!=null){  
			if (temp.val == temp.next.val){  
			temp.next = temp.next.next;  
		} else {  
			temp = temp.next;  
		}  
	}  
return head;  
}
```

## 88. Merged Sorted Array
You are given two integer arrays `nums1` and `nums2`, sorted in **non-decreasing order**, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2` respectively.

**Merge** `nums1` and `nums2` into a single array sorted in **non-decreasing order**.

The final sorted array should not be returned by the function, but instead be _stored inside the array_ `nums1`. To accommodate this, `nums1` has a length of `m + n`, where the first `m` elements denote the elements that should be merged, and the last `n` elements are set to `0` and should be ignored. `nums2` has a length of `n`.

**Example 1:**

**Input:** nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
**Output:** [1,2,2,3,5,6]
**Explanation:** The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

**Example 2:**

**Input:** nums1 = [1], m = 1, nums2 = [], n = 0
**Output:** [1]
**Explanation:** The arrays we are merging are [1] and [].
The result of the merge is [1].

**Example 3:**

**Input:** nums1 = [0], m = 0, nums2 = [1], n = 1
**Output:** [1]
**Explanation:** The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

**Constraints:**

- `nums1.length == m + n`
- `nums2.length == n`
- `0 <= m, n <= 200`
- `1 <= m + n <= 200`
- `-109 <= nums1[i], nums2[j] <= 109`

## Solution
This was the solution I came up with at first.
Even-though the code seems to do what is needed, Leetcode does not approve.
```
public static void merge(int[] nums1, int m, int[] nums2, int n) {  
	int j = 0;  
	if (m==0) nums1 = nums2;  
	else if (n!=0){  
		for (int i = m; i < m+n; i++) {  
			nums1[i] = nums2[j];  
			j++;  
		}  
	}  
	Arrays.sort(nums1);  
}
```

I used the following method to do it without using inbuilt classes with the use of pointers.
```
public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1; // Pointer for nums1
    int j = n - 1; // Pointer for nums2
    int k = m + n - 1; // Pointer for the merged array

    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[k--] = nums1[i--];
        } else {
            nums1[k--] = nums2[j--];
        }
    }

    while (j >= 0) {
        nums1[k--] = nums2[j--];
    }
}

```

## 94. Binary Tree In-order Traversal
Given the `root` of a binary tree, return _the inorder traversal of its nodes' values_.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/09/15/inorder_1.jpg)

**Input:** root = [1,null,2,3]
**Output:** [1,3,2]

**Example 2:**

**Input:** root = []
**Output:** []

**Example 3:**

**Input:** root = [1]
**Output:** [1]

**Constraints:**

- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

## Solution
We use a 2nd function for recursion here.
A pretty straight-forward answer.
```
public static List<Integer> inorderTraversal(TreeNode root) {  
	List<Integer> result = new ArrayList<>();  
	inOrderRec(root, result);  
	return result;  
}  
  
public static void inOrderRec(TreeNode root, List<Integer> list) {  
	if (root == null) {  
		return;  
	}  
	inOrderRec(root.left, list);  
	list.add(root.val);  
	inOrderRec(root.right, list);  
}
```

## 100. Same Tree
Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/12/20/ex1.jpg)

**Input:** p = [1,2,3], q = [1,2,3]
**Output:** true

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/12/20/ex2.jpg)

**Input:** p = [1,2], q = [1,null,2]
**Output:** false

**Example 3:**

![](https://assets.leetcode.com/uploads/2020/12/20/ex3.jpg)

**Input:** p = [1,2,1], q = [1,1,2]
**Output:** false

**Constraints:**

- The number of nodes in both trees is in the range `[0, 100]`.
- `-104 <= Node.val <= 104`

## Solution
We use recursion within the method to compare first the roots and then the left and right subtrees.
```
public static boolean isSameTree(TreeNode p, TreeNode q) {  
	if (p == null && q == null) {  
		return true;  
	} else if (p == null || q == null) {  
		return false;  
	} else {  
		return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);  
	}  
}
```

## 101. Symmetric Tree

Given the `root` of a binary tree, _check whether it is a mirror of itself_ (i.e., symmetric around its center).

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/02/19/symtree1.jpg)

**Input:** root = [1,2,2,3,4,4,3]
**Output:** true

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/02/19/symtree2.jpg)

**Input:** root = [1,2,2,null,3,null,3]
**Output:** false

**Constraints:**

- The number of nodes in the tree is in the range `[1, 1000]`.
- `-100 <= Node.val <= 100`

## Solution
We use the `isMirror` method to find out whether the subtrees of 
```
public static boolean isSymmetric(TreeNode root) {  
	if (root != null){  
		return isMirror(root.left, root.right);  
	}  
	return false;  
}  
  
private static boolean isMirror(TreeNode left, TreeNode right){  
	if (left == null && right == null) return true;  
	if (left == null || right == null) return false;  
	if (left.val != right.val) return false;  
		return isMirror(left.left, right.right) && isMirror(left.right, right.left);  
	}
```

## 104. Maximum Depth of Binary Tree
Given the `root` of a binary tree, return _its maximum depth_.

A binary tree's **maximum depth** is the number of nodes along the longest path from the root node down to the farthest leaf node.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/11/26/tmp-tree.jpg)

**Input:** root = [3,9,20,null,null,15,7]
**Output:** 3

**Example 2:**

**Input:** root = [1,null,2]
**Output:** 2

**Constraints:**

- The number of nodes in the tree is in the range `[0, 104]`.
- `-100 <= Node.val <= 100`

## Solution
A pretty straight forward solution using recursion.

```
public static int maxDepth(TreeNode root) {
	if(root==null) return 0;
	int depthL = maxDepth(root.left);
	int depthR = maxDepth(root.right);
	return Math.max(depthR,depthL) + 1;
}
```

## 108. Convert Sorted Array to Binary Search Tree

Given an integer array `nums` where the elements are sorted in **ascending order**, convert _it to a_ 
**_height-balanced_** _binary search tree_.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/02/18/btree1.jpg)

**Input:** nums = [-10,-3,0,5,9]
**Output:** [0,-3,9,-10,null,5]
**Explanation:** [0,-10,5,null,-3,null,9] is also accepted:
![](https://assets.leetcode.com/uploads/2021/02/18/btree2.jpg)

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/02/18/btree.jpg)

**Input:** nums = [1,3]
**Output:** [3,1]
**Explanation:** [1,null,3] and [3,1] are both height-balanced BSTs.

**Constraints:**

- `1 <= nums.length <= 104`
- `-104 <= nums[i] <= 104`
- `nums` is sorted in a **strictly increasing** order.
## Solution
This was my first approach.
```
public static TreeNode sortedArrayToBST(int[] nums) {  
	TreeNode tree = new TreeNode(nums[nums.length/2]);  
	for (int i = 0; i < nums.length; i++) {  
		insert(tree, nums[i]);  
	}  
  
	return tree;  
}  
  
public static void insert(TreeNode tree, int data){  
	tree = insertRec(tree,data);  
}  
  
private static TreeNode insertRec(TreeNode tree, int data){  
	if (tree == null) return new TreeNode(data);  
	if (tree.val > data){  
		tree.left = insertRec(tree.left, data);  
	} else if (tree.val < data){  
		tree.right = insertRec(tree.right, data);  
	}  
	return tree;  
}
```

But with this method I ran into there following errors.
- **Incorrect Initial Tree Construction:** The initial tree construction should not start with the middle element and then insert all elements. This will not guarantee a balanced tree.
- **Inefficient Tree Insertion:** Inserting elements one by one into the tree from a sorted array does not ensure a balanced tree.

Similar to earlier, we take the middle term of the array and create a new tree from that middle term.
Then we add the elements on the left side of the middle term to the left sub tree and elements on the right side of the middle term to the right sub tree.

```
public static TreeNode sortedArrayToBST(int[] nums) {  
	if (nums == null || nums.length == 0) {  
	return null;  
	}  
	return sortedArrayToBST(nums, 0, nums.length - 1);  
}  
  
private static TreeNode sortedArrayToBST(int[] nums, int left, int right) {  
	if (left > right) {  
	return null;  
	}  
	int mid = left + (right - left) / 2;  
	TreeNode node = new TreeNode(nums[mid]);  
	node.left = sortedArrayToBST(nums, left, mid - 1);  
	node.right = sortedArrayToBST(nums, mid + 1, right);  
	return node;  
}
```

## 110. Balanced Binary Tree

Given a binary tree, determine if it is 

**height-balanced**

.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/10/06/balance_1.jpg)

**Input:** root = [3,9,20,null,null,15,7]
**Output:** true

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/10/06/balance_2.jpg)

**Input:** root = [1,2,2,3,3,null,null,4,4]
**Output:** false

**Example 3:**

**Input:** root = []
**Output:** true

**Constraints:**

- The number of nodes in the tree is in the range `[0, 5000]`.
- `-104 <= Node.val <= 104`

## Solution
We take the heights of the left and right subtrees of the root.
then we look at the difference of the heights there.

```
public static boolean isBalanced(TreeNode root) {  
	if (root == null || (root.left == null && root.right == null)) return true;  
	int leftHeight = iterateTree(root.left);  
	int rightHeight = iterateTree(root.right);  
	int difference = Math.abs(leftHeight - rightHeight);  
	return difference <= 1 && isBalanced(root.left) && isBalanced(root.right);  
}  
  
public static int iterateTree(TreeNode root) {  
	if (root == null) {  
		return 0;  
	}  
	int heightRight = iterateTree(root.right);  
	int heightLeft = iterateTree(root.left);  
	return Math.max(heightLeft, heightRight) + 1;  
}
```


## 3194. Minimum Average Of Smallest And Largest Elements

You have an array of floating point numbers `averages` which is initially empty. You are given an array `nums` of `n` integers where `n` is even.

You repeat the following procedure `n / 2` times:

- Remove the **smallest** element, `minElement`, and the **largest** element `maxElement`, from `nums`.
- Add `(minElement + maxElement) / 2` to `averages`.

Return the **minimum** element in `averages`.

**Example 1:**

**Input:** nums = [7,8,3,4,15,13,4,1]

**Output:** 5.5

**Explanation:**

|step|nums|averages|
|---|---|---|
|0|[7,8,3,4,15,13,4,1]|[]|
|1|[7,8,3,4,13,4]|[8]|
|2|[7,8,4,4]|[8,8]|
|3|[7,4]|[8,8,6]|
|4|[]|[8,8,6,5.5]|

The smallest element of averages, 5.5, is returned.

**Example 2:**

**Input:** nums = [1,9,8,3,10,5]

**Output:** 5.5

**Explanation:**

|step|nums|averages|
|---|---|---|
|0|[1,9,8,3,10,5]|[]|
|1|[9,8,3,5]|[5.5]|
|2|[8,5]|[5.5,6]|
|3|[]|[5.5,6,6.5]|

**Example 3:**

**Input:** nums = [1,2,3,7,8,9]

**Output:** 5.0

**Explanation:**

|step|nums|averages|
|---|---|---|
|0|[1,2,3,7,8,9]|[]|
|1|[2,3,7,8]|[5]|
|2|[3,7]|[5,5]|
|3|[]|[5,5,5]|

**Constraints:**

- `2 <= n == nums.length <= 50`
- `n` is even.
- `1 <= nums[i] <= 50`

## Solution
A pretty straightforward approach we use `java.util.Arrays` to sort both the initial array and the temporary array used to store the averages of min and max.
We should parse the value obtained as average to `double` since it might cause an error with the values.

```
public static double minimumAverage(int[] nums) {  
	int min = 0;  
	int max = 0;  
	int j = 0;  
	Arrays.sort(nums);  
	double[] averages = new double[nums.length/2];  
	for (int i = 0; i < nums.length; i++) {  
		if (j == averages.length){  
			break;  
		}  
		min = nums[i];  
		max = nums[nums.length-1-i];  
		averages[j] = (double) (min+max)/2;  
		j++;  
	}  
	Arrays.sort(averages);  
	return averages[0];  
}
```

