DIR_CLASSES = main/java/domain/classes
DIR_ALGORITMO = main/java/domain/algoritmo
DIR_CONTROLADOR = main/java/domain/controlador
DIR_PERSISTENCIA = main/java/persistence
DIR_PRESENTACION = main/java/presentacion
DIR_DRIVER = main/java/driver

LIB_JARS = ../lib/junit-4.12.jar:../lib/hamcrest-core-1.3.jar:../lib/gson-2.8.9.jar

CLASS_INPUT = $(DIR_CLASSES)/*java \
				$(DIR_ALGORITMO)/*java \
				$(DIR_CONTROLADOR)/*java \
				$(DIR_PERSISTENCIA)/*java 


CLASS_OUTPUT = ../EXE/CLASS
TEST_OUTPUT = ../EXE/CLASS2
JAR_OUTPUT = ../EXE/JAR

SRC_CLASSES = $(wildcard $(DIR_CLASSES)/*.java)
SRC_ALGORITMO = $(wildcard $(DIR_ALGORITMO)/*.java)
SRC_CONTROLADOR = $(wildcard $(DIR_CONTROLADOR)/*.java)
SRC_PERSISTENCIA = $(wildcard $(DIR_PERSISTENCIA)/*.java)
SRC_PRESENTACION = $(wildcard $(DIR_PRESENTACION)/*.java)
SRC_DRIVER = $(wildcard $(DIR_DRIVER)/*.java)


all: jars

smartLayout: jars
	java -cp $(LIB_JARS) -jar $(JAR_OUTPUT)DriverPresentacion.jar

jars: presentacion
	javac -cp $(CLASS_OUTPUT):$(LIB_JARS) -d $(CLASS_OUTPUT) $(CLASS_INPUT) $(SRC_DRIVER) 
	echo "Main-Class: driver.DriverPresentacion\nClass-Path: ../lib/junit-4.12.jar ../lib/hamcrest-core-1.3.jar ../lib/gson-2.8.9.jar" > ./main/java/driver/DriverPresentacion.mf 
	jar cmvf ./main/java/driver/DriverPresentacion.mf $(JAR_OUTPUT)DriverPresentacion.jar -C $(CLASS_OUTPUT) .


presentacion: controlador $(SRC_PRESENTACION)
	javac -cp $(CLASS_OUTPUT):$(LIB_JARS) -d $(CLASS_OUTPUT) $(SRC_PRESENTACION)

controlador: classes algoritmo persistencia $(SRC_CONTROLADOR)
	javac -cp $(CLASS_OUTPUT):$(LIB_JARS) -d $(CLASS_OUTPUT) $(SRC_CONTROLADOR)

persistencia: $(SRC_PERSISTENCIA)
	javac -cp $(LIB_JARS) -d $(CLASS_OUTPUT) $(SRC_PERSISTENCIA)

algoritmo: $(SRC_ALGORITMO)
	javac -d $(CLASS_OUTPUT) $(SRC_ALGORITMO)

classes: $(SRC_CLASSES)
	javac -d $(CLASS_OUTPUT) $(SRC_CLASSES)

clean:
		rm  -r ../EXE/
