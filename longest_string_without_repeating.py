class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        list = []
        max_length = 0
        i = 0
        j = 0
        while (j < len(s)):
            if s[j] not in list:
                list.append(s[j])
                j += 1
                max_length = max(max_length, j - i)
            else:
                list.remove(s[i])
                i += 1
        return max_length