package com.ruiheng.test;

import com.ruiheng.utils.IdWorker;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NumTest {


        public static void main(String[] args) {
//            IdWorker idWorker = new IdWorker();
//            String id = idWorker.nextId()+"";
//            System.out.println("id:"+id);
//            for (int i = 0; i < 10; i++) {
//                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//                System.out.println(uuid);
//            }
            String password = "123456";
            password = new Md5Hash(password, "13502389692", 3).toString();
            System.out.println("加码:"+password);

        }
}
