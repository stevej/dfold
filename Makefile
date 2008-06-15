all:
	scalac -d classes `find ./ -name "*.scala" -print`
run:
	scala -classpath classes dfold.Main
