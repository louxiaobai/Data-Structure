package com.line.algo.bs;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
/**
 * @author lqw
 * @date 2021/10/10-11:18 上午
 */
public class IpLocationParser {
    //定义一个私有内部类--ip地址
    private static class IpLocation {
        public long startIp;
        public long endIp;
        public String locationCity;
    }
    //定义一个动态数组
    private static ArrayList<IpLocation> sortedIpLocations=new ArrayList<IpLocation>();

    //进行读取文件
    static{
        try {
            BufferedReader reader=new BufferedReader(new FileReader("data/ip_location"));
            String line=null;
            while ((line=reader.readLine())!=null){
                String[] temps=line.split(" ");
                IpLocation ipLocation=new IpLocation();
                ipLocation.startIp=ip2Score(temps[0]);
                ipLocation.endIp=ip2Score(temps[1]);
                ipLocation.locationCity=temps[2];
                sortedIpLocations.add(ipLocation);
            }
        } catch (IOException e) {
             throw new RuntimeException("解析ip地址库出错"+e);
        }
        // 2. 按照起始 ip 进行升序排列
        // 时间复杂度：O(nlogn)
        Collections.sort(sortedIpLocations, new Comparator<IpLocation>() {
            @Override
            public int compare(IpLocation o1, IpLocation o2) {
                if (o1.startIp < o2.startIp) return -1;
                else if (o1.startIp > o2.startIp) return 1;
                else return 0;
            }
        });
    }

    //将ip转化成长整形
    public static Long ip2Score(String ip){
        String[] temps=ip.split("\\.");
        Long score=256*256*256*Long.parseLong(temps[0])
                +256*256*Long.parseLong(temps[1])
                +256*Long.parseLong(temps[2])
                +Long.parseLong(temps[3]);
        return score;
    }

    //给定ip地址进行查找
    public static String getIpLocation(String ip){
        //对ip进行转换
        Long ipAdress=ip2Score(ip);
        int left=0;
        int right=sortedIpLocations.size()-1;
        //进行二分查找
        while (left<right){
            int mid=left+(right-left)/2;
            if (ipAdress>=sortedIpLocations.get(mid).startIp){
                  if (mid==sortedIpLocations.size()-1||sortedIpLocations.get(mid+1).startIp>ipAdress){
                      if (ipAdress<sortedIpLocations.get(mid).endIp){
                          return sortedIpLocations.get(mid).locationCity;
                      }else {
                          break;//跳出循环。说明ip地址不在此数组范围内
                      }
                  }else{
                      left=mid+1;
                  }
                  }else {
                    right=mid-1;
            }
            }
        return "没有查到此ip地址所属城市";
    }

    @Test
    public void test(){
        System.out.println(getIpLocation("202.102.56.254"));

    }



}