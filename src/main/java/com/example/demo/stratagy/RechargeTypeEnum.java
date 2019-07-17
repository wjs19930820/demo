package com.example.demo.stratagy;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2019/3/522:32
 */
public enum RechargeTypeEnum {

    CASH(1, "现金支付"),
    BANK(2, "银行卡支付"),
    MOBILE(3, "手机支付"),
    OTHER(4, "其他支付");

    private final int code;

    private final String value;

    RechargeTypeEnum(int code, String value){
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public boolean equalsTo(Integer status) {
        return status == null ? false : status.equals(code);
    }

}
