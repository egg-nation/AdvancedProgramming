package com.optional;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=77sGWNGmLhw

public class ScpCommand {
    public static void execute() throws Exception {
        DefaultSessionFactory sessionFactory = new DefaultSessionFactory(
            "Current Session", "127.0.0.1", 22
        );
        Map props = new HashMap<String, String>();
        props.put("StrictHostKeyChecking", "no");
        sessionFactory.setConfig(props);
        sessionFactory.setPassword("87");

        CommandRunner runner = new CommandRunner (sessionFactory);
        String command = "scp /home/bin/reportGame.html elisa.giurgea@fenrir.info.uaic.ro.com:~";
        CommandRunner.ExecuteResult result = runner.execute(command);

        if (result.getStderr().isEmpty()){
            System.out.println(result.getStdout);
        }
        else{
            System.out.println(result.getStderr);
        }

        runner.close();
    }
}
