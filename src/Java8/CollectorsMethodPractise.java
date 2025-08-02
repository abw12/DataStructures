package Java8;

import Java8.StreamAPI.EmplooyeeData;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CollectorsMethodPractise {

    public static void main(String[] args) {

        EmplooyeeData empObj = new EmplooyeeData();
        List<EmplooyeeData> listOfEmp = empObj.getInitialList();

        //retrieve the name of employee groupBy department
        Map<String, List<String>> collect =
                listOfEmp.stream().collect(Collectors.groupingBy(EmplooyeeData::getDept,
                        Collectors.mapping(
                                EmplooyeeData::getName,Collectors.toList()

                )));
//        collect.forEach((key,value)->{
//            System.out.println(key + " -- value" + value);
//        });

        //grouping by using the 3rd overloaded method groupingBy(Function,Supplier,Collector);
        TreeMap<Integer, Set<String>> collect1 = listOfEmp.stream()
                .collect(Collectors.groupingBy(EmplooyeeData::getYearsOfExp, TreeMap::new, Collectors.mapping(EmplooyeeData::getName, Collectors.toSet())));


        //If we don't give the Supplier as give above then the order of the grouped output will not be maintained
        listOfEmp.stream()
                .collect(
                        Collectors.groupingBy(EmplooyeeData::getYearsOfExp, Collectors.mapping(EmplooyeeData::getName, Collectors.toSet())))
                                .forEach((key,value)->{
                            System.out.println(key + " value --- " + value);
                        });


    }

}
