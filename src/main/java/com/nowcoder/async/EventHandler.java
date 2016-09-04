package com.nowcoder.async;

import java.util.List;

/**
 * Created by zhulehao on 16/8/6.
 */
public interface EventHandler {
    void doHandle(EventModel model);

    List<EventType> getSupportEventTypes();
}
