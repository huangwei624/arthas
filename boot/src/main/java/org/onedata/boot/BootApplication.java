package org.onedata.boot;

import com.sun.tools.attach.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BootApplication {

    private static final String AGENT_JAR_PATH = "G:\\java\\workspace\\arthas\\agent\\target\\agent-demo.jar";

    private static final String AGENT_PARAMS = "@P-org.onedata.jvmtarget";
    private static final String PID = "10264";

    public static void main(String[] args) {
        List<VirtualMachineDescriptor> javaList = VirtualMachine.list();
        javaList.forEach(item -> {
            if (item.displayName().contains("JvmTarget")) {
                VirtualMachine attach = null;
                try {
                    attach = VirtualMachine.attach(item.id());
                    attach.loadAgent(AGENT_JAR_PATH, AGENT_PARAMS);
                    attach.detach();
                } catch (AttachNotSupportedException | IOException
                        | AgentLoadException | AgentInitializationException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
