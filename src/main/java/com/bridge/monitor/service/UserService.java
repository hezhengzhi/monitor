package com.bridge.monitor.service;

import com.bridge.monitor.entity.UserPo;
import com.bridge.monitor.model.UserInVo;
import com.bridge.monitor.repo.UserRepo;
import com.bridge.monitor.util.HttpResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class UserService {
    @Resource
    private UserRepo userRepo;


    public HttpResponse<Page<UserPo>> findUserList(String phone, int pageSize, int pageNum) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        PageRequest pageRequest = PageRequest.of(pageNum-1, pageSize, sort);
        Page<UserPo>userPos=userRepo.findAll(new A(phone),pageRequest);
        /*Page<UserPo> userPos = userRepo.findAll((Specification<UserPo>) (root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (!StringUtils.isEmpty(phone)) {
                predicate.getExpressions().add(criteriaBuilder.like(root.get("phone"), "%" + phone + "%"));
            }
            return predicate;
        }, pageRequest);*/
        return HttpResponse.SUCCESS(userPos);
    }

    class A implements Specification{

        private String phone;

        public A(String phone) {
            this.phone = phone;
        }

        @Override
        public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
            Predicate predicate = criteriaBuilder.conjunction();
            if (!StringUtils.isEmpty(phone))
                if (!StringUtils.isEmpty(phone)) {
                    predicate.getExpressions().add(criteriaBuilder.like(root.get("phone"), "%" + phone + "%"));
                }
            return predicate;
        }
    }
    private static Specification<UserPo> getWhereClause(final String phone)
    {
        return new Specification<UserPo>()
        {
            @Override
            public Predicate toPredicate(Root<UserPo> root, CriteriaQuery<?> query, CriteriaBuilder cb)
            {
                Predicate predicate = cb.conjunction();
                if (!StringUtils.isEmpty(phone))
                    if (!StringUtils.isEmpty(phone)) {
                        predicate.getExpressions().add(cb.like(root.get("phone"), "%" + phone + "%"));
                    }
                return predicate;
            }
        };
    }

    public HttpResponse<UserPo> saveUser(UserInVo userInVo) {
        UserPo userPo=new UserPo();
        BeanUtils.copyProperties(userInVo,userPo);
        userPo.setPassword("123456");
        userRepo.save(userPo);
        return HttpResponse.SUCCESS(userPo);
    }

    public HttpResponse<String> deleteUser(int id) {
        UserPo userPo=userRepo.findById(id).orElse(null);
        if (userPo==null){
            return HttpResponse.FAIL(HttpStatus.INTERNAL_SERVER_ERROR.value(),"删除失败，未查询到该用户");
        }
        userRepo.delete(userPo);
        return HttpResponse.SUCCESS("删除成功");
    }
}
