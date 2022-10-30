package com.agileboot.domain.system.post.model;

import com.agileboot.common.exception.ApiException;
import com.agileboot.common.exception.error.ErrorCode;
import com.agileboot.orm.entity.SysPostEntity;
import com.agileboot.orm.service.ISysPostService;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
public class PostModel extends SysPostEntity {

    public PostModel(SysPostEntity entity) {
        if (entity != null) {
            BeanUtils.copyProperties(entity, this);
        }
    }

    public void checkCanBeDelete(ISysPostService postService) {
        if (postService.isAssignedToUsers(this.getPostId())) {
            throw new ApiException(ErrorCode.Business.POST_ALREADY_ASSIGNED_TO_USER_CAN_NOT_BE_DELETED);
        }
    }

}
