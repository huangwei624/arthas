package org.onedata.boot;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BootApplication {

    private static final String AGENT_JAR_PATH = "D:\\work\\arthas\\agent\\target\\agent-demo.jar";

    private static final String AGENT_PARAMS = "@M-org.onedata.jvmtarget.controller.HelloController$hello";
    private static final String PID = "24212";

    public static void main(String[] args) throws IOException, AgentLoadException,
            AgentInitializationException, AttachNotSupportedException, InterruptedException {
        VirtualMachine attach = VirtualMachine.attach(PID);
        attach.loadAgent(AGENT_JAR_PATH, AGENT_PARAMS);
        TimeUnit.SECONDS.sleep(1000);
    }

}
