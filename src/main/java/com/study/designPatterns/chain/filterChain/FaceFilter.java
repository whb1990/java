package main.java.com.study.designPatterns.chain.filterChain;

/**
 * @author: whb
 * @date: 2019/6/13 14:29
 * @description: 符号过滤规则
 */
public class FaceFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.requestStr = request.requestStr.replace(":):", "^V^")
                //后面添加的是便于我们观察代码执行步骤的字符串
                + "----FaceFilter()";
        chain.doFilter(request, response, chain);
        response.responseStr += "----FaceFilter()";
    }
}
