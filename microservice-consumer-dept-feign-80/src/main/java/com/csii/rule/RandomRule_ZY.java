package com.csii.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;


public class RandomRule_ZY extends AbstractLoadBalancerRule {
    private int total=0;
    private  int currentIndex=0;

    public Server choose(ILoadBalancer lb, Object key) {



        if (lb == null) {

            return null;

        }

        Server server = null;



        while (server == null) {

            if (Thread.interrupted()) {

                return null;

            }

            List<Server> upList = lb.getReachableServers();



            List<Server> allList = lb.getAllServers();




            int serverCount = allList.size();

            if (serverCount == 0) {
                return null;
            }

            if(total < 5 ){
                total++;
            }else{
                total=0;
                currentIndex++;
                if(currentIndex >allList.size()){
                    currentIndex=0;
                }
            }
        //    int index = chooseRandomInt(serverCount);


            server = upList.get(currentIndex);



            if (server == null) {

                /*

                 * The only time this should happen is if the server list were

                 * somehow trimmed. This is a transient condition. Retry after

                 * yielding.

                 */

                Thread.yield();

                continue;

            }



            if (server.isAlive()) {

                return (server);

            }
            server = null;

            Thread.yield();
        }
        return server;
    }

    public Server choose(Object o) {
        return choose(getLoadBalancer(), o);
    }

    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    protected int chooseRandomInt(int serverCount) {

        Random random= new Random();
        return  random.nextInt(serverCount);

    }


}
