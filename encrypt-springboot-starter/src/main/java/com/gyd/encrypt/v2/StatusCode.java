package com.gyd.encrypt.v2;

/**
 * @ClassName StatusCode
 * @Description TODO
 * @Author guoyading
 * @Date 2023/11/23 14:08
 * @Version 1.0
 */
public enum StatusCode {
    OK(200),
    FAILURE(300),
    ERROR(500),
    UNLOGIN(401),
    BADREQUEST(400),
    NOAUTHORITY(403),
    AUTHREQUIRED(407),
    NOTFOUND(404);

    private final Integer code;

    private StatusCode(Integer code) {
        this.code = code;
    }

    public Integer value() {
        return this.code;
    }

    public static StatusCode value(int code) {
        StatusCode[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            StatusCode value = var1[var3];
            if (value.code == code) {
                return value;
            }
        }

        return null;
    }
}