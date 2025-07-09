import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // Step 1: Sort 
        List<List<String>> result = new ArrayList<>();
        int left = 0, right = products.length - 1;
        String prefix = "";
        for (char ch : searchWord.toCharArray()) {
            prefix += ch;
            // Move left pointer to skip products not starting with prefix
            while (left <= right && !products[left].startsWith(prefix)) {
                left++;
            }
            // Move right pointer to skip products not starting with prefix
            while (left <= right && !products[right].startsWith(prefix)) {
                right--;
            }
            // 3 matching for suggestion
            List<String> suggestions = new ArrayList<>();
            for (int i = left; i <= right && suggestions.size() < 3; i++) {
                suggestions.add(products[i]);
            }
            result.add(suggestions);
        }
        return result;
    }
}
