class Solution {
    public String intToRoman(int num) {
        LinkedHashMap<Integer, String> valueSymbols = new LinkedHashMap<>();
        valueSymbols.put(1000, "M");
        valueSymbols.put(900, "CM");
        valueSymbols.put(500, "D");
        valueSymbols.put(400, "CD");
        valueSymbols.put(100, "C");
        valueSymbols.put(90, "XC");
        valueSymbols.put(50, "L");
        valueSymbols.put(40, "XL");
        valueSymbols.put(10, "X");
        valueSymbols.put(9, "IX");
        valueSymbols.put(5, "V");
        valueSymbols.put(4, "IV");
        valueSymbols.put(1, "I");
        
        StringBuilder roman = new StringBuilder();
        
        for (Map.Entry<Integer, String> entry : valueSymbols.entrySet()) {
            int value = entry.getKey();
            String symbol = entry.getValue();
            while (num >= value) {
                roman.append(symbol);
                num -= value;
            }
        }
        
        return roman.toString();
    }
}