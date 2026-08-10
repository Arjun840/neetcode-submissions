class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()){
            return "";
        }
        StringBuilder res = new StringBuilder();
        for (String s : strs){
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()){
            int j = i;
            while (str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1; // Ajust to start of word
            j = i + length; // Adjsut to end of word
            res.add(str.substring(i, j));
            i = j; // Move to next word
        }
        return res;
    }
}
