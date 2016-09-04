package com.nowcoder.service;

import org.springframework.stereotype.Service;

/**
 * Created by zhulehao on 16/7/16.
 */
@Service
public class WendaService {
    public String getMessage(int userId){
        return "Hello Message:" + String.valueOf(userId);
    }
}
