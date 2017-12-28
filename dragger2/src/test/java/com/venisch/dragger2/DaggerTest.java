package com.venisch.dragger2;

import com.venisch.dragger2.model.User;

import org.junit.Test;

import javax.inject.Inject;

/**
 * Created by shenwenjie on 2017/12/28.
 */

public class DaggerTest {


    @Inject
    User user;

    @Test
    public void testDagger(){

//        if(user!=null){
//            user =
//        }
        
        System.out.println("DaggerTest.testDagger >> \n");
    }
}
