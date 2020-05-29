package com.ruiheng.service.impl;

import com.ruiheng.entity.Enter_Prise;
import com.ruiheng.entity.User;
import com.ruiheng.mapper.EnterPriseMapper;
import com.ruiheng.mapper.EpPerListMapper;
import com.ruiheng.mapper.UserMapper;
import com.ruiheng.service.EnterPriseService;
import com.ruiheng.utils.result.Result;
import com.ruiheng.utils.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
public class EnterPriseServiceImpl implements EnterPriseService {

    /**
     * 企业
     */
    @Autowired
    private EnterPriseMapper enterPriseMapper;

    /**
     * 用户
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 企业人员关联
     */
    @Autowired
    private EpPerListMapper epPerListMapper;

    @Override
    @Transactional
    public Result<Integer> addEnterPriseMapper(Enter_Prise enter_prise) {
        Integer num = 0;
        Integer falg = enterPriseMapper.findReEnterPrisePhone(enter_prise.getEpPhone());
        Integer falg2 = enterPriseMapper.findReEnterPriseName(enter_prise.getEpName());
        if (falg > 0){
            System.out.println("企业账号手机号已存在");
            log.error("企业账号已存在");
            return new Result(ResultCode.newInstance(ResultCode.ENTERPRISEPHONEEXISTS,"企业账号已存在"));
        }else if (falg2 > 0){
            System.out.println("企业名称已存在");
            log.error("企业账号已存在");
            return new Result(ResultCode.newInstance(ResultCode.ENTERPRISENAMEEXISTS,"企业名称已存在"));
        }else {
            //判断用户信息是否为空
            if (enter_prise.getEpName() != null && enter_prise.getEpName() != "" && enter_prise.getEpAddress() != null && enter_prise.getEpAddress() != "" && enter_prise.getEpPeople() != null && enter_prise.getEpPeople() != ""
                && enter_prise.getEpSex() != null && enter_prise.getEpSex() != "" && enter_prise.getEpPwd() != null && enter_prise.getEpPwd() != null && enter_prise.getEpPhone() != null && enter_prise.getEpPhone() != null){
                try {
                    String password = new Md5Hash(enter_prise.getEpPwd(), enter_prise.getEpPhone(), 3).toString();
                    enter_prise.setEpPwd(password);
                    num = enterPriseMapper.addEnterPriseMapper(enter_prise);
                    if (num > 0) {
                        System.out.println("进入企业注册方法注册成功");
                        //查询企业id和账号
                        Enter_Prise enter_prise1 = enterPriseMapper.queryEnterPriseId(enter_prise.getEpName());
                        System.out.println("查询企业id:"+enter_prise1.getId()+"号码:"+enter_prise1.getEpPhone());
                        User user = userMapper.findPhoneAll(enter_prise1.getEpPhone());//查询用户id和企业id
                        Integer nums = userMapper.addUserEpId(enter_prise1.getId(),user.getId());//用户加入公司id
                        if (nums > 0){
                            User user1 = userMapper.findPhoneAll(enter_prise1.getEpPhone());//查询用户id和企业id
                            Integer numss = epPerListMapper.addEpPerList(user1.getUserEpId(),user1.getId());//添加企业用户关联
                            if (numss > 0){
                                System.out.println("用户id:"+user1.getId()+"企业id:"+user1.getUserEpId());
                                System.out.println("添加企业id成功");
                                return new Result(ResultCode.newInstance(ResultCode.SUCCESS, "企业注册信息成功"), num);
                            }else {
                                System.out.println("添加企业关联失败!");
                                return new Result(ResultCode.newInstance(ResultCode.FAILURE, "添加企业关联失败"));
                            }

                        }else {
                            System.out.println("企业id添加失败");
                            return new Result(ResultCode.newInstance(ResultCode.FAILURE, "企业id添加失败"));
                        }

                    } else {
                        System.out.println("企业注册失败!");
                        return new Result(ResultCode.newInstance(ResultCode.FAILURE, "注册信息失败"));
                    }
                } catch (Exception e) {
                    log.error("注册信息异常! -> {}", e.getMessage());
                    return new Result(ResultCode.newInstance(ResultCode.FAILURE, "注册信息异常"));
                }
            }else {
                System.out.println("用户信息有空值");
                return new Result(ResultCode.newInstance(ResultCode.FAILURE, "注册信息有空值不完整"));
            }

        }

    }

    /**
     * 添加企业客户
     */
    public Result<Integer> addEnterPriseClient(Enter_Prise enterPrise) {
        Integer num = enterPriseMapper.addEnterPriseClient(enterPrise);
        if (num > 0){
            System.out.println("添加客户成功");
            return new Result(ResultCode.SUCCESS,"添加客户成功");
        }else{
            System.out.println("添加失败");
            return new Result(ResultCode.FAILURE,"添加失败");
        }
    }

    /**
     * 查询公司客户
     */
    public List<Enter_Prise> findByEpType(String epType) {
        return enterPriseMapper.findByEpType(epType);
    }
}
