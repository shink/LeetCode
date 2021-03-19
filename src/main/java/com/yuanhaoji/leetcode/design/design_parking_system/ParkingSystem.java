package com.yuanhaoji.leetcode.design.design_parking_system;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/2/1
 * @desp: 1603简单题——设计停车系统，https://leetcode-cn.com/problems/design-parking-system/
 */

public class ParkingSystem {

    private final int[] parkingSpaceNum;

    public ParkingSystem(int big, int medium, int small) {
        parkingSpaceNum = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        --carType;
        if (parkingSpaceNum[carType] > 0) {
            --parkingSpaceNum[carType];
            return true;
        }
        return false;
    }

}
