class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ret = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            compareAdd(ret, strs[i]);
        }
        return ret;

    }

    private void compareAdd(List<List<String>> ret, String str) {
        for (int i = 0; i < ret.size(); i++) {
            StringBuilder compared = new StringBuilder(ret.get(i).get(0));
            if (compared.length() != str.length())
                continue;
            for (int n = 0; n < str.length(); n++) {
                for (int m = 0; m < compared.length(); m++) {
                    if (compared.charAt(m) == str.charAt(n)) {
                        compared.deleteCharAt(m);
                        break;
                    }
                }
            }
            if (compared.length() == 0) {
                ret.get(i).add(str);
                return;
            }
        }
        ret.add(new ArrayList<>(Arrays.asList(str)));
    }
}

// Limited time exceeded