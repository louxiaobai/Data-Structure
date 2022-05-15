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
 * @date 2021/10/10-11:18 ����
 */
public class IpLocationParser {
    //����һ��˽���ڲ���--ip��ַ
    private static class IpLocation {
        public long startIp;
        public long endIp;
        public String locationCity;
    }
    //����һ����̬����
    private static ArrayList<IpLocation> sortedIpLocations=new ArrayList<IpLocation>();

    //���ж�ȡ�ļ�
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
             throw new RuntimeException("����ip��ַ�����"+e);
        }
        // 2. ������ʼ ip ������������
        // ʱ�临�Ӷȣ�O(nlogn)
        Collections.sort(sortedIpLocations, new Comparator<IpLocation>() {
            @Override
            public int compare(IpLocation o1, IpLocation o2) {
                if (o1.startIp < o2.startIp) return -1;
                else if (o1.startIp > o2.startIp) return 1;
                else return 0;
            }
        });
    }

    //��ipת���ɳ�����
    public static Long ip2Score(String ip){
        String[] temps=ip.split("\\.");
        Long score=256*256*256*Long.parseLong(temps[0])
                +256*256*Long.parseLong(temps[1])
                +256*Long.parseLong(temps[2])
                +Long.parseLong(temps[3]);
        return score;
    }

    //����ip��ַ���в���
    public static String getIpLocation(String ip){
        //��ip����ת��
        Long ipAdress=ip2Score(ip);
        int left=0;
        int right=sortedIpLocations.size()-1;
        //���ж��ֲ���
        while (left<right){
            int mid=left+(right-left)/2;
            if (ipAdress>=sortedIpLocations.get(mid).startIp){
                  if (mid==sortedIpLocations.size()-1||sortedIpLocations.get(mid+1).startIp>ipAdress){
                      if (ipAdress<sortedIpLocations.get(mid).endIp){
                          return sortedIpLocations.get(mid).locationCity;
                      }else {
                          break;//����ѭ����˵��ip��ַ���ڴ����鷶Χ��
                      }
                  }else{
                      left=mid+1;
                  }
                  }else {
                    right=mid-1;
            }
            }
        return "û�в鵽��ip��ַ��������";
    }

    @Test
    public void test(){
        System.out.println(getIpLocation("202.102.56.254"));

    }



}