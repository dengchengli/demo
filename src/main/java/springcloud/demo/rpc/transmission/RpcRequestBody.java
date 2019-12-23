package springcloud.demo.rpc.transmission;

import springcloud.demo.rpc.serializable.Serialization;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author: Dely
 * @Date: 2019/11/28 12:33
 */

/**
 * 请求传输类
 */
public class RpcRequestBody implements Serializable {
    private long requestId;   //请求id
    private byte rpcProtocolVersion; //协议版本号

    private String InterfaceName; //接口名

    private String methodName; //方法名
    private Object arguments; //参数列表
    private String parametersDesc; //参数描述

    private int retries = 0;  //重试次数
    private Map<String, String> attachments; //附加信息

    public RpcRequestBody() {
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public byte getRpcProtocolVersion() {
        return rpcProtocolVersion;
    }

    public void setRpcProtocolVersion(byte rpcProtocolVersion) {
        this.rpcProtocolVersion = rpcProtocolVersion;
    }

    public String getInterfaceName() {
        return InterfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        InterfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object getArguments() {
        return arguments;
    }

    public void setArguments(Object arguments) {
        this.arguments = arguments;
    }

    public String getParametersDesc() {
        return parametersDesc;
    }

    public void setParametersDesc(String parametersDesc) {
        this.parametersDesc = parametersDesc;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }

    public Map<String, String> getAttachments() {
        return attachments;
    }

    public void setAttachments(Map<String, String> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "RpcRequestBody{" +
                "requestId=" + requestId +
                ", rpcProtocolVersion=" + rpcProtocolVersion +
                ", InterfaceName='" + InterfaceName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", arguments=" + arguments +
                ", parametersDesc='" + parametersDesc + '\'' +
                ", retries=" + retries +
                ", attachments=" + attachments +
                '}';
    }
}
