package com.amrita.task.service;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskOneService {
    public String HelloWorldTest() {
        String str = "Hello World";
        return str;
    }

    public Map<String, Object> alpha(Map<String, Object> request) {
        Map<String, Object> map = new TreeMap<>(request);
        return map;
    }

    public Map<String, Object>  flatten(Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();
        for (String name: request.keySet()) {
            if(request.get(name) instanceof List) {
                List list = java.util.Arrays.asList(request.get(name));
                StringBuffer strBuff = new StringBuffer();
                list.stream().forEach(
                    abc -> {
                        strBuff.append(abc);
                    }
                );
                strBuff.delete(strBuff.length()-1, strBuff.length());
                strBuff.delete(0, 1);
                String str = strBuff.toString();
                response.put(name, str);
            }else {
                response.put(name, request.get(name));
            }
        }
        return response;
    }

    public Map<String, Object> getStatus() {
        Map<String, Object> response = new HashMap<>();
        //Getting Used Memory.
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long memUsedPct=afterUsedMem-beforeUsedMem;
        response.put("mem-used-pct", memUsedPct);

        //Getting Disk name with spaces available.
        File[] drives = File.listRoots();
        List<Map<String, Object>> driveList = new ArrayList<>();
        if(drives != null && drives.length>0) {
            for (File drive: drives) {
                Map<String, Object> map = new HashMap<>();
                map.put("discname", drive);
                map.put("availbytes", drive.getFreeSpace());
                driveList.add(map);
            }
        }
        response.put("disc-space-avail", driveList);

        //Getting Cpu used percentage.
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        for (Method method: operatingSystemMXBean.getClass().getDeclaredMethods()) {
            method.setAccessible(true);
            if(method.getName().startsWith("get")) {
                Object cpuUsedValue;
                try {
                    cpuUsedValue = method.invoke(operatingSystemMXBean);
                }catch (Exception e) {
                    cpuUsedValue = e;
                }
                response.put("cpu-used-pct", cpuUsedValue);
            }
        }


        return response;
    }
}
