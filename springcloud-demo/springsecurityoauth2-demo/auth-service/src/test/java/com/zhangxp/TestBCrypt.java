package com.zhangxp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Date 2021/2/4 11:08
 * Created by zhangxp.
 */
@RunWith(SpringRunner.class)
public class TestBCrypt {

    @Test
    public void testBCrypt() {
       String pass =  BCrypt.hashpw("123456", BCrypt.gensalt());
       System.out.println(pass);
       String pass1 =  BCrypt.hashpw("secret", BCrypt.gensalt());
       System.out.println(pass1);
    }
}
