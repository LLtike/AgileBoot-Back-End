package com.agileboot.infrastructure.web.domain.permission;

import lombok.Builder;
import lombok.Data;

/**
 * 供 DataPermissionChecker使用的 数据条件
 */
@Data
@Builder
public class DataCondition {

    private Long targetDeptId;
    private Long targetUserId;

}
