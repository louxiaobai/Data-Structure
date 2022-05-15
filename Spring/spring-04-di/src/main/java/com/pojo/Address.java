package com.pojo;

/**
 * @author lqw
 * @date 2021/10/18-9:04 ÏÂÎç
 */
public class Address {
    private String address;

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}