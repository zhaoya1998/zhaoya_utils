package com.zhaoya.common.untils;

import java.awt.geom.Point2D;

public class DistanceUtil {

	private static final double EARTH_RADIUS = 6371393;//平均半径 单位：m
    //输入经纬度，计算两个坐标间的距离
	public static double getDistance(double j1, double w1, double j2, double w2) {
		Point2D pointDD = new Point2D.Double(j1, w1);
		Point2D pointXD = new Point2D.Double(j2, w2);
		return calculate(pointDD, pointXD);
	}

	//通过AB点经纬度获取距离
	public static double calculate(Point2D pointA, Point2D pointB) {

		//经纬度(角度)转弧度，弧度用作参数,以调用Math.cos和Math.sin
		double radiansAX = Math.toRadians(pointA.getX());//A经弧度
		double radiansAY = Math.toRadians(pointA.getY());
		double radiansBX = Math.toRadians(pointB.getX());
		double radiansBY = Math.toRadians(pointB.getY());
		double cos = Math.cos(radiansAY) * Math.cos(radiansBY) * Math.cos(radiansAX - radiansBX)
				+ Math.sin(radiansAY) * Math.sin(radiansBY);
		double acos = Math.acos(cos);
		return EARTH_RADIUS * acos;
	}

	public static void main(String[] args) {
        
		double d = getDistance(116.425249, 39.914504, 116.382001, 39.913329);
		System.out.println("两地的距离是" + d+"m");
	}
}
