package com.ll.jpa1209.global.rsData;
//23 11 27, p 13200, 3강, memberService.join, 1부, 구현
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static lombok.AccessLevel.PROTECTED;

@Getter
@AllArgsConstructor(access = PROTECTED)
public class RsData<T> {
    private String resultCode;
    private String msg;
    private final T data;
    private final int statusCode;
    public static <T> RsData<T> of(String resultCode , String msg ,T data){
        int statusCode = Integer.parseInt(resultCode);

        return new RsData<>(resultCode,msg,data,statusCode);
    }
    public boolean isSuccess(){
        return statusCode >= 200 && statusCode < 400;
    }
    public boolean isFail() {
        return !isSuccess();
    }

}
