class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, ArrayList<String>> group = new HashMap<String, ArrayList<String>>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = String.valueOf(charArray);
            if (group.get(sorted) == null) {
                group.put(sorted, new ArrayList<String>(Arrays.asList(str)));
            } else {
                group.get(sorted).add(str);
            }
        }
        return new ArrayList<>(group.values());

    }
}

/*
 * Using a hashmap to group visited string by using their sorted value as the
 * key
 * 
 * IMPROVEMENT: should try to find more efficient JAVA APIs
 */