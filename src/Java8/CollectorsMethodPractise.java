package Java8;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsMethodPractise {

    public static void main(String[] args) {

        List<EmplooyeeData> listOfEmp = Stream.of(new EmplooyeeData("Abhishek","Dev",60000,4),
                new EmplooyeeData("Manali","Dev",80000,6),
                new EmplooyeeData("Jashma","QA",50000,5),
                new EmplooyeeData("Amit","QA",120000,3),
                new EmplooyeeData("Manoj","Dev",160000,18),
                new EmplooyeeData("Mahesh","Dev",260000,20),
                new EmplooyeeData("Vishal","DevOps",160000,19),
                new EmplooyeeData("Inder","DevOps",100000,12),
                new EmplooyeeData("Abhishek","Dev",60000,3)
        ).collect(Collectors.toList());

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
