package com.edu.zhy.api.api.web.factory;

import com.edu.zhy.api.api.web.dto.DelayTaskMessage;
import com.edu.zhy.api.api.web.tsp.DefaultTspCallbackTask;
import com.edu.zhy.api.api.web.tsp.LiveBeginReminderTask;

public interface TspTaskExecutorFactory {




    AbstractTspTask handler(DelayTaskMessage delayTaskMessage);




    static TspTaskExecutorFactory getInstance(){


        return delayTaskMessage -> {

            switch (delayTaskMessage.getTaskType()){

                case TspTaskConstant.LIVE_BEGIN_REMINDER_TASK :
                    return new LiveBeginReminderTask(delayTaskMessage);


                default:
                    return new DefaultTspCallbackTask(delayTaskMessage);
            }

        };

    }


}
