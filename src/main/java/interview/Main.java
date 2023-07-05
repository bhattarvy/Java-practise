package interview;

import lombok.Data;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    void run(){

        List<Engineer> enggList = new ArrayList<>();
        enggList.addAll(Arrays.asList(new Engineer("1",null),new Engineer("2",null),new Engineer("3",null)));

        List<Machine> machineList = new ArrayList<>();
        machineList.addAll(Arrays.asList(new Machine("1"),new Machine("2")));

        System system = new System(machineList);

        for(int i=0; i<enggList.size(); i++){
            system.assign(enggList.get(i));
        }
        java.lang.System.out.println(system.getWaitList());
        system.getWaitList().forEach((e)-> java.lang.System.out.println(e.id));
        java.lang.System.out.println("");
        system.release(enggList.get(0));

        system.getWaitList().forEach((e)-> java.lang.System.out.println(e.id));

    }

    class Engineer{
        String id;
        String machineId;
        Engineer(String id, String machineId){
            this.id=id;
            this.machineId=machineId;
        }
    }

    class Machine{
        public String id;
        public boolean isAvailable=true;
        public String enggId;
        Machine(String id){
            this.id=id;
        }
    }


    @Data
    class System{

        Queue<Engineer> waitList  = new LinkedList<>();
        List<Machine> machinePool;

        System(List<Machine> machinePool){
            this.machinePool=machinePool;
        }

        void assign(Engineer eng){
            boolean isMachineAllocated = false;
            for(int i=0; i<machinePool.size(); i++){
                if(machinePool.get(i).isAvailable == true){
                    Machine machine = machinePool.get(i);
                    machine.isAvailable = false;
                    machine.enggId = eng.id;
                    eng.machineId=machine.id;
                    isMachineAllocated=true;
                }
            }
            if(!isMachineAllocated){
                waitList.add(eng);
            }
        }

        void release(Engineer eng){

            String machineId = eng.machineId;
            Machine freeMachine = null;
            eng.machineId = null;

            for(Machine  machine : machinePool){
                if(machine.id==machineId){
                    freeMachine = machine;
                    break;
                }
            }

            freeMachine.isAvailable=true;
            freeMachine.enggId=null;

            if(!waitList.isEmpty()) {
                Engineer eng1 = waitList.poll();
                eng1.machineId = freeMachine.id;
                freeMachine.enggId = eng1.id;
                freeMachine.isAvailable = false;

            }
        }
    }
}
