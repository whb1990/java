package main.java.com.study.designPatterns.chain.filterChain;

/**
 * @author: whb
 * @date: 2019/6/13 14:13
 * @description: 定义封装请求的类Request
 */
public class Request {

    String requestStr;

    public String getRequestStr() {
        return requestStr;
    }

    public void setRequestStr(String requestStr) {
        this.requestStr = requestStr;
    }
}
