package com.lcl.springcloud.consumer01.rule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MyRule implements IRule {

    private ILoadBalancer loadBalancer;
    private List<Integer> excludePorts;


    @Override
    public Server choose(Object o) {
        //获取所有provider
        List<Server> serverList = loadBalancer.getAllServers();
        //排除指定provider
        List<Server> availableServer = getAvailableServer(serverList);
        //从剩余的provider中选择
        return getAvailableRandomServer(availableServer);
    }

    private Server getAvailableRandomServer(List<Server> availableServer) {
        int index = new Random().nextInt(availableServer.size());
        return availableServer.get(index);
    }

    private List<Server> getAvailableServer(List<Server> serverList) {
        if(this.excludePorts == null || this.excludePorts.size() == 0){
            return serverList;
        }
        List<Server> availableServer = new ArrayList();
        for (Server server : serverList) {
            if(!this.excludePorts.contains(server.getPort())){
                availableServer.add(server);
            }
        }
        return availableServer;
    }
}
