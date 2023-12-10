package com.ll.jpa1209.standard.util;
//10강, 파트 1, 2부


import lombok.SneakyThrows;

public class Ut {
    public static class Thread{
        @SneakyThrows
        public static void sleep(int milli){
            Thread.sleep(milli);
        }
    }
}
