JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        StringSet.java \
        StringNode.java \
        SpellChecker.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
