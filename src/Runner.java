import java.util.*;

public class Runner {
    static List<Module> moduleList;

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);
        moduleList = new ArrayList<>(); // Instantiating for each program run

        //input
        String choice = "Y";
        while (choice.equals("Y") || choice.equals("y")) {
            input(inputScanner);
            System.out.println("Do you want to input more modules? Y or N ");
            choice = inputScanner.nextLine();
            if (!(choice.equals("Y") || choice.equals("y") || choice.equals("N") || choice.equals("n"))) {
                System.out.println("Please use Y or N to specify the choice");
                choice = inputScanner.nextLine();
            }
        }

        //output
        choice = "Y";
        while ((choice.equals("Y") || choice.equals("y"))) {
            System.out.println("Please choose the module whose dependencies you want to print");
            String moduleForGettingDependencies = inputScanner.nextLine();
            try {
                System.out.println("Dependencies for module : " + moduleForGettingDependencies.toUpperCase() + " are: " + getDependencies(moduleForGettingDependencies.toUpperCase()));
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
            System.out.println("Check more dependencies Y or N ?");
            choice = inputScanner.nextLine();
            if (!(choice.equals("Y") || choice.equals("y") || choice.equals("N") || choice.equals("n"))) {
                System.out.println("Please use Y or N to specify the choice");
                choice = inputScanner.nextLine();
            }


        }


    }

    public static List<String> getDependencies(String moduleForGettingDependencies) throws Exception {
        // setting flag visited as 0 for each getDependencies function run

        for (Module module : moduleList) {
            module.setVisited(0);
        }

        return getDependencies(moduleList, moduleForGettingDependencies);
    }

    private static List<String> getDependencies(List<Module> moduleList, String moduleForGettingDependencies) throws Exception {
        List<String> dependencies = new ArrayList<>();
        /*
         Find module from moduleList global variable
         */
        Module moduleData = moduleList.stream().
                filter(module -> moduleForGettingDependencies.equals(module.getName())).findAny().orElse(null);
        if (moduleData != null) {
            /* If module dependency has been
             visited in current function run
             throw exception. */
            if (moduleData.getVisited() > 0)
                throw new Exception("Illegal dependency");
            /*
             * Else for each dependency of current module
             * find dependency by recursion
             * */
            for (String dependency : moduleData.getDependencies()) {
                dependencies.addAll(getDependencies(moduleList, dependency));
                dependencies.add(dependency);
                moduleData.setVisited(1);

            }
        }
        return dependencies;

    }

    private static void input(Scanner inputScanner) {
        System.out.println("Module Name : ");
        String moduleName = inputScanner.nextLine();
        System.out.println("Module Dependencies (Please use space between different module dependencies): ");
        String moduleDependencies = inputScanner.nextLine();
        String[] arrayOfModuleDependencies = moduleDependencies.split(" ");
        Module moduleToAdd = new Module();
        moduleToAdd.setName(moduleName.toUpperCase());
        HashSet<String> hashSet = new HashSet<>();
        for(String dep : arrayOfModuleDependencies)
        {
            hashSet.add(dep.toUpperCase());
        }
        moduleToAdd.setDependencies(hashSet);
        moduleList.add(moduleToAdd);

    }
}
