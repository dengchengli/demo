package springcloud.demo.rpc.transmission;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author: Dely
 * @Date: 2019/11/28 12:33
 */

/**
 * 响应 传输类
 */
public class RpcResponseBody implements Serializable {

    private long requestId;  //请求id
    private Object value; //响应数据
    private byte rpcProtocolVersion;  //协议版本
    private long processTime; //处理时间
    private int timeout; //超时时间
    private Exception exception; //异常信息
    private Map<String,String> attachments; //响应附加信息。

    public RpcResponseBody() {
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public byte getRpcProtocolVersion() {
        return rpcProtocolVersion;
    }

    public void setRpcProtocolVersion(byte rpcProtocolVersion) {
        this.rpcProtocolVersion = rpcProtocolVersion;
    }

    public long getProcessTime() {
        return processTime;
    }

    public void setProcessTime(long processTime) {
        this.processTime = processTime;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Map<String, String> getAttachments() {
        return attachments;
    }

    public void setAttachments(Map<String, String> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "RpcResponseBody{" +
                "requestId=" + requestId +
                ", value=" + value +
                ", rpcProtocolVersion=" + rpcProtocolVersion +
                ", processTime=" + processTime +
                ", timeout=" + timeout +
                ", exception=" + exception +
                ", attachments=" + attachments +
                '}';
    }
}
