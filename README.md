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
                once its no more needed is all maanaged by the container (context)

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

    Spring Core Maven Dependencies
    ------------------------------
	<properties>
      <maven.compiler.target>1.8</maven.compiler.target>
		<maven.compiler.source>1.8</maven.compiler.source>
		<spring-version>5.1.4.RELEASE</spring-version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<version>${spring-version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${spring-version}</version>
		</dependency>
	</dependencies>


    Xml Based Configuaration
    -------------------------------

        <?xml version="1.0" encoding="UTF-8"?>
        <beans xmlns="http://www.springframework.org/schema/beans"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

            <!--Here go bean definitions-->

        </beans>


        bean definition
        ------------------------------------
            <bean
                id=""                               identity for the bean to used while asking for it
                class=""                            fully qualified name of the class to which we need a bean
                scope=""                            singleton / prototype / request / session /global-session
                autowire=""                         byType / byName / auto / none
                init-method=""                      is a method that has to execute after a bean is created
                destroy-method=""                   is a method that has to execute before a bean is destroyed
            >
                <property name="" value="" ref=""/>                 is used for setter injection
                <constructor-arg index="" value="" ref="" />        is used for constructor injection
            </bean>


        Injecting Collections
        ------------------------------------

            <property name="taxesRateList">
                <list>
                    <value>12.0</value>
                    <value>10.0</value>
                    <value>1.0</value>
                    <value>0.50</value>
                </list>
            </property>

            <property name="countries">
                <set>
                    <value>India</value>
                    <value>Russia</value>
                    <value>USA</value>
                    <value>Britan</value>
                </set>
            </property>

             <property name="greetings">
                <map>
                   <entry key="ENG" value="Hello" />
                   <entry key="HIN" value="Namaskar" />
                   <entry key="TEL" value="Namasthey" />
                   <entry key="TAM" value="Vanakkam" />
                </map>
            </property>

    Annotation Based Configuaration
    -------------------------------
      @Component("id")
      @Scope("singleton/prototype/request/session/global-session")
      public class MyComponent{

          @Value("value/SpEL expression")
          private String field1;

          @Autowired
          @Qualifier("idOfAnothercompoennt")
          private AnotherComponent field2;
          
      }

      @Configuaration
      @ComponentScan("packageName")
      public class MyConfiguaration{

      }

      AppplicationContext context = new AnnotationApplicationContext(MyConfiguaration.class)

      @Component
        @Service
        @Repository
        @Controller
        ....etc