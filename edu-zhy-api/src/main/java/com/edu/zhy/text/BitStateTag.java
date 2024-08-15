package com.edu.zhy.text;


import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description:: BitStateTag
 * 比特状态标
 *
 * @author lilingchen
 * @version 1.0
 * @date 2020/03/13.
 */
@AllArgsConstructor
@Getter
public enum BitStateTag {

	FORMAL_STUDENT(0, "formalStudent", "正式学员", 3, RoleEnum.STUDENT.getType()),
	POTENTIAL_STUDENT(1, "potentialStudent", "潜在学员", 6, RoleEnum.POTENTIAL_STUDENT.getType()),
	CUSTOMER_SEARCH(2, "customerSearch", "客户可见", 6, -1),
	POTENTIAL_CUSTOMER(9, "potentialCustomer", "潜在客户", 1 << 9, RoleEnum.POTENTIAL_CUSTOMER.getType()),
	;

	/**
	 * 位置
	 */
	private int bitPosition;

	/**
	 * 名称
	 */
	private String key;

	/**
	 * 描述
	 */
	private String desc;

	/**
	 * 最大值
	 */
	private long maxValue;

	/**
	 * 对应角色
	 */
	private int role;

	public static List<String> getTags(Long bitState) {
		if (bitState == null) {
			return new ArrayList<>();
		}
		return Arrays.stream(BitStateTag.values())
				.map(s -> {
					if (((1 << s.getBitPosition()) & bitState) != 0) {
						return s.getKey();
					}
					return null;
				})
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
	}

	public static Set<BitStateTag> getTags(RoleEnum roleEnum) {
		switch (roleEnum) {
			case STUDENT:
				return Sets.newHashSet(BitStateTag.FORMAL_STUDENT);
			case POTENTIAL_STUDENT:
				return Sets.newHashSet(BitStateTag.POTENTIAL_STUDENT, BitStateTag.CUSTOMER_SEARCH);
			case POTENTIAL_CUSTOMER:
				return Sets.newHashSet(BitStateTag.POTENTIAL_CUSTOMER);
			default:
				throw new NoSuchElementException();
		}
	}

	public static Set<Integer> getRoles(Long bitState) {
		if (bitState == null) {
			return Sets.newHashSet(4);
		}
		return Arrays.stream(BitStateTag.values())
				.filter(b -> (bitState & (1 << b.getBitPosition())) != 0)
				.map(BitStateTag::getRole)
				.filter(i -> i != -1)
				.collect(Collectors.toSet());
	}

	public static Integer getRole(Long bitState, Integer defaultRole) {
		if (bitState == null) {
			return defaultRole;
		}
		return Arrays.stream(BitStateTag.values())
				.filter(b -> (bitState & (1 << b.getBitPosition())) != 0)
				.map(BitStateTag::getRole)
				.filter(i -> i != -1)
				.findFirst()
				.orElse(defaultRole);
	}

	public static Long fromRole(RoleEnum roleEnum) {
		switch (roleEnum) {
			case STUDENT:
				return 1L << BitStateTag.FORMAL_STUDENT.getBitPosition();
			case POTENTIAL_STUDENT:
				return (1L << BitStateTag.POTENTIAL_STUDENT.getBitPosition()) | (1L << BitStateTag.CUSTOMER_SEARCH.getBitPosition());
			case POTENTIAL_CUSTOMER:
				return 1L << BitStateTag.POTENTIAL_CUSTOMER.getBitPosition();
			default:
				throw new NoSuchElementException();
		}
	}

	public static Long cancelBit(Long bitState, List<BitStateTag> tags) {
		for (BitStateTag tag : tags) {
			if (tag != null) {
				bitState = bitState & (~(1 << tag.getBitPosition()));
			}
		}
		return bitState;
	}

}
