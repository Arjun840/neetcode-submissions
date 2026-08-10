class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()){
            return "";
        }
        StringBuilder res = new StringBuilder();
        for (String str : strs){
            res.append(str.length()).append('#').append(str);
        }
        return res.toString();
    }
    public List<String> decode(String str) {
        if (str.length() == 0){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()){
            int j = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            res.add(str.substring(i, i + length));
            i += length;
        }
    return res;
    }
}
