package distributedsystems.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class LeadElection implements Watcher {

    private static String ZOOKER_ADDRESS = "localhost:2181";
    private static int SESSION_TIMEOUT = 3000;
    private static String ELECTION_NAMESPACE = "/election";


    private String currentZNodeName;

    private ZooKeeper zookeeper;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        LeadElection leadElection = new LeadElection();
        leadElection.connectToZookeeper();
        leadElection.volunteenForLeadership();
        leadElection.electLeaders();
        leadElection.run();
        leadElection.close();
    }

    public void volunteenForLeadership() throws InterruptedException, KeeperException {
        String zNodePrefix = ELECTION_NAMESPACE + "/c_";
        String zNodeFullPath = zookeeper.create(zNodePrefix,new byte[]{}, Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("ZNodeFullPath " + zNodeFullPath);
        this.currentZNodeName = zNodePrefix.replace(ELECTION_NAMESPACE+"/","");
    }

    public void electLeaders() throws InterruptedException, KeeperException {
        List<String> zNodeChildresn = zookeeper.getChildren(ELECTION_NAMESPACE, false);
        Collections.sort(zNodeChildresn);
        String smallestChild = zNodeChildresn.get(0);
        if (smallestChild.equals(this.currentZNodeName)) {
            System.out.println("I am the leader " + smallestChild);
        } else {
            System.out.println("We are no the leader "+ smallestChild);
        }
    }

    public void run() throws InterruptedException {
        synchronized (zookeeper){
            zookeeper.wait();
        }
    }

    public void close() throws InterruptedException {
        synchronized (zookeeper){
            zookeeper.close();
        }
    }

    public void connectToZookeeper() throws IOException {
        this.zookeeper = new ZooKeeper(ZOOKER_ADDRESS, SESSION_TIMEOUT, this);
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("WatchedEvent we get" + event);

        switch (event.getType()){
            case None:
                if(event.getState() == KeeperState.SyncConnected){
                    System.out.println("Connected");
                }
                if(event.getState() == KeeperState.Disconnected){
                    System.out.println("Disconnected");
                    zookeeper.notifyAll();
                }
        }
    }
}
