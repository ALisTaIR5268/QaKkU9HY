// 代码生成时间: 2025-09-22 10:16:16
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

// 日志收集器类
public class ErrorLogCollector {
    private static final Logger LOGGER = Logger.getLogger(ErrorLogCollector.class.getName());

    
    // 捕获并记录异常
    public void captureException(Exception ex) {
        LOGGER.severe(buildExceptionMessage(ex));
    }

    
    // 构建异常信息字符串
    private String buildExceptionMessage(Exception ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String stackTrace = sw.toString();
        return stackTrace;
    }

    
    // JSF 导航处理方法，用于捕获并记录用户界面中的异常
    public String handleException(FacesContext context) {
        Throwable throwable = context.getRootCause();
        if (throwable != null) {
            captureException(new Exception(buildExceptionMessage(throwable)));
        }
        return "error?faces-redirect=true"; // 导航到错误页面
    }

    
    // HttpServletRequest 扩展类，用于获取请求相关的错误信息
    public static class HttpServletRequestWrapper extends HttpServletRequest {
        private HttpServletRequest request;

        public HttpServletRequestWrapper(HttpServletRequest request) {
            this.request = request;
        }

        
        @Override
        public String getRemoteAddr() {
            // 模拟获取客户端IP地址
            return "127.0.0.1";
        }
    }
}
