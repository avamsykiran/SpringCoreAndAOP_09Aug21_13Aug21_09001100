Spring Core
===========================================================================================
https://github.com/avamsykiran/SpringCoreAndAOP_09Aug21_13Aug21_09001100.git

Spring?

    spring is a java-ee deve-platform

    1. Modular
        Spring Core and Contect and IoC
        Spring Web MVC and Spring REST
        Spring Data
        Spring ORM
        Spring Boot
        Spring Security
        Spring AOP
        Spring Test
        ....................etc
    2. Light weight
    3. Interaperability


Spring Core, Context and IoC
-----------------------------------------------------------------------------------------------

    Dependency Injection?

        Modularity
            Coupling        the measue of dependency between different modules
            Cohesion        the correlation of the code resources that make up a module.


        Mulit-Layer Archetecture

            DAO -----model/dto------ SERVICES  -----model/dto------    UI

        Persistenc Logic            Bussiness Logic                 input and output operations
    database related code..     Computations/Validations..etc


    interface EmployeeDAO {
        Employee add(Emp e);
        void remove(int eid);
    }

    class EmployeeDAOImpl implements EmplpoyeeDAO {             class EmployeeService{              
                                                                    EmployeeDAO dao;
                                                                    
                                                                    public EmployeeService(EmployeeDAO dao){
                                                                        this.dao=dao;
                                                                    }
        
     public Employee add(Emp e){                                    public void validateAndSave(Employee emp){
         ...jdbc code to save emp                                       ...validatew the emp
     }                                                                  dao.add(em0);
                                                                    }
     public void remove(int eid){
         ...jdbc code....
     }
    }                                                            }  



    class EmployeeDAOJpaImpl implements EmplpoyeeDAO {            
                                         
     public Employee add(Emp e){          
         ...jpa code to save emp                   
     }                                            
                                           
     public void remove(int eid){
         ...jpa code....
     }
    }                                                                 

     Dependency Injection is a method of passing dependecny to the
     requried resources (passing dao into a service or a service into a ui)
     dynamically through constyructors or setter ...etc.,



    Container  is a peice of software that can manage the life cycle of a object,
                The creation of the object , managing its dependencie and 
                supplying it to the app code when needed and also destroying the object
                once its no more needed si al maanaged by the container (context)

    The  objects that are manged by a contianer are called container managed beans.

    Spring Core, Context    Containers are;
 
                BeanFactory
                ApplictionContext

    Spring Bean Configuaration
        
        is about informing the spring context
            1. how many objects (Beans) needed to be managed
            2. what is dependent on what.

        Xml Based Configuaration
        Annotation Based Configuaration
        Java Based Configuaration




