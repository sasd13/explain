JFLAGS = -g
JC = javac
CLASSPATH = lib/gson-2.2.4.jar:lib/postgresql-9.3-1101.jdbc41.jar:./

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) -classpath $(CLASSPATH) $*.java

SRC = \
        main.java 

default: classes

classes: $(SRC:.java=.class)

clean:
	$(RM) *.class