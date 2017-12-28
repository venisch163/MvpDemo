package com.venisch.dragger2.module;

import com.venisch.dragger2.model.User;
import com.venisch.dragger2.model.User2;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shenwenjie on 2017/12/28.
 * 用于提供带有参数的被依赖类，实际使用中为了解耦一般调用userCase来初始化数据，此处变成一个接口
 * 使用Module模式时被依赖类可以不必添加Inject注解
 *
 * @Named 用于区分传递给被依赖类的参数类型
 */

@Module
public class UserModule {

    @Provides
    public User provideUser() {
        return new User();
    }

    @Named("TypeOneParam")
    @Provides
    public User2 provideUser2A() {
        return new User2("lily");
    }

    @Named("TypeTwoParam")
    @Provides
    public User2 provideUser2B(){
        return new User2("david",20);
    }

}
