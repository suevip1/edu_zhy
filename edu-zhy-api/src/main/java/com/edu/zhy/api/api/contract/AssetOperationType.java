package com.edu.zhy.api.api.contract;

import com.edu.zhy.biz.dubboBean.businessException.BusinessException;
import com.edu.zhy.biz.dubboBean.businessException.enumerror.CommonErrorCodes;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by .w_zhanghongyi
 * Time 2023/11/17 16:17
 * Desc 文件描述
 */
@Getter
public enum AssetOperationType {

    CREATE(0B1, "create", "创建资产"),
    DELETE(0B10, "delete", "删除资产"),

    LOCK(0B100, "lock", "锁定"),
    UNLOCK(0B1_000, "unlock", "解锁"),
    CONSUME(0B10_000, "consume", "消耗"),
    UNCONSUME(0B100_000, "unconsume", "回退消耗"),

    ADD_USER(0B1_000_000, "add_user", "增加用户"),
    REMOVE_USER(0B10_000_000, "remove_user", "移除用户"),
    ADD_SCOPE(0B100_000_000, "add_scope", "增加范围"),
    REMOVE_SCOPE(0B1_000_000_000, "remove_scope", "移除范围"),
    ADD_TAG(0B10_000_000_000, "add_tag", "增加标签"),
    REMOVE_TAG(0B100_000_000_000, "remove_tag", "移除标签"),

    CHANGE_VALUE(0B1_000_000_000_000, "change_value", "修改资产总值"),
    DEDUCT_VALUE(0B10_000_000_000_000, "deduct_value", "手动扣减资产值"),
    CHANGE_VALIDITY_INTERVAL(0B100_000_000_000_000, "change_validity_interval", "修改有限期"),
    CHANGE_VALIDITY_TIME_AMOUNT(0B1_000_000_000_000_000, "change_validity_time_amount", "修改有效期量"),

    VALIDITY_ACTIVATE(0B10_000_000_000_000_000, "validity_activate", "资产激活"),
    CHANGE_OWNER(0B100_000_000_000_000_000, "change_owner", "资产拥有者变更"),
    ;

    private final int code;
    private final String name;
    private final String desc;

    AssetOperationType(int code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    public static AssetOperationType getByCode(int code) {
        return Arrays.stream(AssetOperationType.values())
                .filter(value -> value.getCode() == code)
                .findAny()
                .orElseThrow(() -> new BusinessException(CommonErrorCodes.ILLEGAL_PARAM));
    }

    public static AssetOperationType getByName(String name) {
        return Arrays.stream(AssetOperationType.values())
                .filter(value -> value.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new BusinessException(CommonErrorCodes.ILLEGAL_PARAM));
    }

    /**
     * 拆分合并编码
     * @param combined 合并后的操作编码
     * @return 操作列表
     */
    public static List<AssetOperationType> divide(int combined) {
        return Arrays.stream(AssetOperationType.values())
                .filter(value -> (value.getCode() & combined) > 0)
                .collect(Collectors.toList());
    }

    /**
     * 合并编码
     * @param codes 需要合并的编码列表
     * @return 合并后的编码
     */
    public static int combine(int[] codes) {
        int combinedCode = 0;
        for (int code : codes) {
            combinedCode = combinedCode | code;
        }
        return combinedCode;
    }

    /**
     * @see #combine(int[])
     */
    public static int combine(List<AssetOperationType> operationTypes) {
        int[] codes = new int[operationTypes.size()];
        for (int i = 0; i < operationTypes.size(); i++) {
            codes[i] = operationTypes.get(i).getCode();
        }
        return combine(codes);
    }

    public static boolean isValueOperation(int typeCode) {
        return typeCode == LOCK.getCode()
                || typeCode == UNLOCK.getCode()
                || typeCode == CONSUME.getCode()
                || typeCode == UNCONSUME.getCode();
    }

    public static boolean isValueOperation(AssetOperationType type) {
        return isValueOperation(type.getCode());
    }


    /**
     * *直接获取全部的values
     * @return
     */
    public static List<AssetOperationType> getAssetOperationType() {
        return Arrays.asList(AssetOperationType.values());
    }




}
