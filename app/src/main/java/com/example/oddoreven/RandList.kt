package com.example.oddoreven

class RandList {
    private var list: MutableList<Int> = mutableListOf()
    fun RandomListOrSum(n : Int): Pair<String, Int>{
        var rnd = 0;
        while(list.size < n) {
            rnd = (1..6).random()
            list.add(rnd)
        }
        var str = "";
        var sum = 0;
        for(c in list) {
            str = str + "      $c"
            sum = sum + c
        }
        return Pair(str,sum)
    }
}
